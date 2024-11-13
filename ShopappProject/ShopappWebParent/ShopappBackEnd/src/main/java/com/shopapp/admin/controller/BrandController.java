package com.shopapp.admin.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shopapp.admin.common.Common;
import com.shopapp.admin.exception.BrandNotFoundException;
import com.shopapp.admin.service.BrandService;
import com.shopapp.admin.service.CategoryService;
import com.shopapp.admin.utils.FileUploadUtil;
import com.shopapp.common.entity.Brand;

@Controller
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/brands")
	public String viewBrands(Model model) {
		return viewBrandPerPage("asc", "name", 1, null, model);
	}
	
	@GetMapping("/brands/page/{pageNum}")
	public String viewBrandPerPage(@Param("sortDir") String sortDir,
			@Param("sortField") String sortField,
			@PathVariable("pageNum") int pageNum, 
			@Param("keyword") String keyword, Model model) {
		if (sortDir == null || sortDir.isEmpty()) {
			sortDir = "asc";
		}

		Page<Brand> brandPages = brandService.getByPage(pageNum, sortField, sortDir, keyword);
		brandPages.getContent().forEach(System.out::println);
		String reverseSortDir = (sortDir.equals("asc") ? "desc" : "asc");
		long startCount = (pageNum - 1) * Common.BRANDS_PER_PAGE + 1;
		long endCount = startCount + Common.BRANDS_PER_PAGE - 1;
		
		if(endCount > brandPages.getTotalElements()) {
			endCount = brandPages.getTotalElements();
		}
		
		model.addAttribute("currentPage", pageNum);
		model.addAttribute("totalPages", brandPages.getTotalPages());
		model.addAttribute("totalItems", brandPages.getTotalElements());
		model.addAttribute("brands", brandPages.getContent());
		model.addAttribute("sortField", sortField);
		model.addAttribute("reverseSortDir", reverseSortDir);
		model.addAttribute("keyword", keyword);
		model.addAttribute("startCount", startCount);
		model.addAttribute("endCount", endCount);

		return "brands/brands";
	}
	
	@GetMapping("/brands/new")
	public String createBrand(Model model) {
		model.addAttribute("brand", new Brand());
		model.addAttribute("categories", categoryService.getCategoryUsedInForm());
		model.addAttribute("pageTitle", "Create Brand");
		return "brands/brand_form";
	}
	
	@PostMapping("/brands/save")
	public String saveCategory(RedirectAttributes ra, 
			Brand brand, @RequestParam("fileImage") MultipartFile multipartFile) throws IOException {
		
		if(!multipartFile.isEmpty()) {
			String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
			brand.setLogo(fileName);
			
			Brand savedBrand = brandService.save(brand);
			String dir = "../brand-logos/" + savedBrand.getId();
			FileUploadUtil.cleanDir(dir);
			FileUploadUtil.saveFile(dir, fileName, multipartFile);
		}else {
			brandService.save(brand);
		}
		
		ra.addFlashAttribute("message", "Brand " + brand.getName() + " has been saved successfully");
		
		return "redirect:/brands";
	}
	
	@GetMapping("/brands/edit/{id}")
	public String editBrand(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
		try {
			Brand brand = brandService.get(id);
			model.addAttribute("brand", brand);
			model.addAttribute("categories", categoryService.getCategoryUsedInForm());
			model.addAttribute("pageTitle", "Edit brand (ID: " + id + ")");
			
			return "brands/brand_form";
		} catch (BrandNotFoundException e) {
			ra.addFlashAttribute("message", e.getMessage());
			return "redirect:/brands";
		}
	}
	
	@GetMapping("/brands/delete/{id}")
	public String deleteBrand(@PathVariable("id")Integer id, RedirectAttributes ra) {
		try {
			brandService.delete(id);
			String dir = "../brand-logos/" + id;
			FileUploadUtil.removeDir(dir);
			ra.addFlashAttribute("message", "The brand " + id + " has been deleted!");
		} catch (BrandNotFoundException e) {
			ra.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/brands";
	}
}
