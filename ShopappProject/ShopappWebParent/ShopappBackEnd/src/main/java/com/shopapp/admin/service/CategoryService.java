package com.shopapp.admin.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.shopapp.admin.exception.CategoryNotFoundException;
import com.shopapp.common.entity.Category;

public interface CategoryService {
	
	List<Category> getAll();
	
	Page<Category> getByPage(int pageNum, String sortField, String sortDir, String keyword);
	
	List<Category> getCategoryUsedInForm();
	
	Category save(Category category);
	
	Category get(int id) throws CategoryNotFoundException;
	
	void delete(int id) throws CategoryNotFoundException;
	
	String checkUnique(Integer id, String name, String alias);

	void updateEnabledStatus(Integer id, boolean enable);
}
