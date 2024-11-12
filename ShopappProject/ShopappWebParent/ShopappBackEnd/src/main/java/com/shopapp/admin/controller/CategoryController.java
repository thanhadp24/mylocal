package com.shopapp.admin.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shopapp.admin.exception.CategoryNotFoundException;
import com.shopapp.admin.service.CategoryService;
import com.shopapp.admin.utils.FileUploadUtil;
import com.shopapp.common.entity.Category;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
	public String viewCategories(Model model) {
		model.addAttribute("categories", categoryService.getAll());
		return "categories/categories";
	}
	
	@GetMapping("/categories/new")
	public String categoryForm(Model model) {
		List<Category> categories = categoryService.getCategoryUsedInForm();
		
		model.addAttribute("category", new Category());
		model.addAttribute("categories", categories);
		model.addAttribute("pageTitle", "Create new category");
		return "categories/category_form";
	}
	
	@PostMapping("/categories/save")
	public String saveCategory(RedirectAttributes redirectAttributes, 
			Category category, @RequestParam("fileImage") MultipartFile multipartFile) throws IOException {
		
		if(!multipartFile.isEmpty()) {
			String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
			category.setImage(fileName);
			
			Category savedCategory = categoryService.save(category);
			
			String path = "../category-images/" + savedCategory.getId();
			
			FileUploadUtil.cleanDir(path);
			FileUploadUtil.saveFile(path, fileName, multipartFile);
		}else {
			categoryService.save(category);
		}
		
		redirectAttributes.addFlashAttribute("message", "The category name " + category.getName() + " has been saved successfully");
		
		return "redirect:/categories";
	}
	
	@GetMapping("/categories/edit/{id}")
	public String editCategory(@PathVariable("id") Integer id,
			Model model, RedirectAttributes ra) {
		
		try {
			model.addAttribute("category", categoryService.get(id));
			model.addAttribute("categories", categoryService.getCategoryUsedInForm());
			model.addAttribute("pageTitle", "Edit category (ID: " + id + ")");
			
			return "categories/category_form";
		} catch (CategoryNotFoundException e) {
			ra.addFlashAttribute("message", e.getMessage());
			return "redirect:/categories";
		}
	}
	
	@GetMapping("/categories/delete/{id}")
	public String deleteCategory(@PathVariable("id") Integer id, RedirectAttributes ra) {
		
		try {
			categoryService.delete(id);
			ra.addFlashAttribute("message", "Category with id " + id + " has been deleted!");
		} catch (CategoryNotFoundException e) {
			ra.addFlashAttribute("message", e.getMessage());
		}
		
		return "redirect:/categories";
	}
	
	@GetMapping("/categories/{id}/enabled/{status}")
	public String enabledCategory(@PathVariable("id") Integer id,
			@PathVariable("status") boolean enable, RedirectAttributes ra) {
		
		categoryService.updateEnabledStatus(id, enable);
		
		String status = enable ? "enabled": "disabled";
		String message = "The user ID " + id + " has been " + status;
		
		ra.addFlashAttribute("message", message);
		
		return "redirect:/categories";
	}
	
	@GetMapping("/categories/page/{pageNum}")
	public String pagination(@PathVariable("pageNum") Integer pageNum) {
		
		
		
		return "redirect:/categories";
	}
	
}
