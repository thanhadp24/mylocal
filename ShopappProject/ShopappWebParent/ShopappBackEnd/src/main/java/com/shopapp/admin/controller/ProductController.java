package com.shopapp.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.shopapp.admin.service.BrandService;
import com.shopapp.admin.service.ProductService;
import com.shopapp.common.entity.Product;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private BrandService brandService;
	
	@GetMapping("/products")
	public String viewProducts(Model model) {
		model.addAttribute("products", productService.getAll());
		return "products/products";
	}
	
	@GetMapping("/products/new")
	public String createProduct(Model model) {
		
		Product product = new Product();
		product.setEnabled(true);
		product.setInStock(true);
		
		model.addAttribute("product", product);
		model.addAttribute("brands", brandService.getAll());
		model.addAttribute("pageTitle", "Create new product");
		
		return "products/product_form";
	}
	
	@PostMapping("/products/save")
	public String saveProduct(Product product, Model model) {
		System.out.println(product.getName());
		return "products/products";
	}
}
