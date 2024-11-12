package com.shopapp.admin.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shopapp.admin.exception.CategoryNotFoundException;
import com.shopapp.admin.repository.CategoryRepository;
import com.shopapp.admin.service.CategoryService;
import com.shopapp.common.entity.Category;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAll() {
		List<Category> rootCategories = categoryRepository.getRootCategories();
		return listHierarchicalCategories(rootCategories);
	}
	
	@Override
	public Page<Category> getByPage(int pageNum, String sortField, String sortDir, String keyword) {
		
		
		return null;
	}
	
	private List<Category> listHierarchicalCategories(List<Category> rootCategories){
		List<Category> hierarchicalCategories = new ArrayList<>();
		
		for (Category category: rootCategories) {
			hierarchicalCategories.add(Category.copyFull(category)); // avoid update db
			
			listSubCategoriesHierarchical(hierarchicalCategories, category, 0);
		}
		
		return hierarchicalCategories;
	}
	
	private void listSubCategoriesHierarchical(List<Category> hierarchicalCategories,
			Category parent, int subLevel) {
		int newSubLevel = subLevel + 1;
		for (Category subCategory: parent.getChildren()) {
			StringBuilder sb = new StringBuilder("");
			for(int i = 0; i < newSubLevel; i++) {
				sb.append("--");
			}
			String name = sb.append(" ").append(subCategory.getName()).toString();
			hierarchicalCategories.add(Category.copyFull(subCategory, name));
			listSubCategoriesHierarchical(hierarchicalCategories, subCategory, newSubLevel);
		}
	}
	
	@Override
	public List<Category> getCategoryUsedInForm() {
		List<Category> categoriesInForm = new ArrayList<>();
		List<Category> categories = getAll();
		
		for (Category category: categories) {
			if(category.getParent() == null) {
				categoriesInForm.add(Category.copyIdAndName(category));
				listSubCategoriesUsedInForm(category, 0, categoriesInForm);
			}
		}
		
		return categoriesInForm;
	}
	
	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}
	
	private void listSubCategoriesUsedInForm(Category parent, int subLevel, List<Category> categoriesInForm) {
		int newSubLevel = subLevel + 1;
		for (Category subCategory: parent.getChildren()) {
			StringBuilder sb = new StringBuilder("");
			for(int i = 0; i < newSubLevel; i++) {
				sb.append("--");
			}
			String name = sb.append(" ").append(subCategory.getName()).toString();
			categoriesInForm.add(Category.copyIdAndName(subCategory.getId(), name));
			listSubCategoriesUsedInForm(subCategory, newSubLevel, categoriesInForm);
		}
	}
	
	@Override
	public Category get(int id) throws CategoryNotFoundException {
		try {
			return categoryRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new CategoryNotFoundException("Could not find category with id " + id);
		}
	}
	
	@Override
	public void delete(int id) throws CategoryNotFoundException {
		Long count = categoryRepository.countById(id);
		if(count == null || count == 0) {
			throw new CategoryNotFoundException("Could not find any category with id " + id);
		}
		categoryRepository.deleteById(id);
	}
	
	@Override
	public String checkUnique(Integer id, String name, String alias) {
		
		boolean isCreatingNew = (id == null || id == 0);
		Category categoryByName = categoryRepository.findByName(name);
		Category categoryByAlias = categoryRepository.findByAlias(alias);
		
		if(isCreatingNew) {
			if(categoryByName != null) {
				return "Duplicate name";
			}else if(categoryByAlias != null) {
				return "Duplicate alias";
			}
		}else {
			if(categoryByName != null && categoryByName.getId() != id) {
				return "Duplicate name";
			}else if(categoryByAlias != null && categoryByAlias.getId() != id) {
				return "Duplicate alias";
			}
		}
		
		return "OK";
	}
	
	@Override
	public void updateEnabledStatus(Integer id, boolean enable) {
		categoryRepository.updateEnabled(id, enable);
	}
}
