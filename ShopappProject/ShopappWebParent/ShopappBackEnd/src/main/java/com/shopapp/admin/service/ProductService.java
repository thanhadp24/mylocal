package com.shopapp.admin.service;

import org.springframework.data.domain.Page;

import com.shopapp.common.entity.Product;
import com.shopapp.common.exception.ProductNotFoundException;

public interface ProductService {
	Page<Product> getByPage(int numPage, String sortDir, String sortField, String keyword, Integer categoryId);

	Product get(Integer id) throws ProductNotFoundException;

	Product save(Product product);
	
	void saveProductPrice(Product productInForm);
	
	String checkUnique(String name, Integer id);
	
	void delete(Integer id) throws ProductNotFoundException;
	
	void updateEnabled(Integer id, boolean status);

}
