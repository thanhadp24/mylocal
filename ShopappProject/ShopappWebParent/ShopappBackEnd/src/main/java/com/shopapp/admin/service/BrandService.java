package com.shopapp.admin.service;

import org.springframework.data.domain.Page;

import com.shopapp.admin.exception.BrandNotFoundException;
import com.shopapp.common.entity.Brand;

public interface BrandService {
	
	Page<Brand> getByPage(int pageNum, String sortField, String sortDir, String keyword);
	
	Brand save(Brand brand);
	
	Brand get(Integer id) throws BrandNotFoundException;
	
	void delete(Integer id) throws BrandNotFoundException;
	
	String checkUnique(Integer id, String name);

}
