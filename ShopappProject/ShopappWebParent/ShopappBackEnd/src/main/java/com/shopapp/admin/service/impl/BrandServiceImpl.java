package com.shopapp.admin.service.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopapp.admin.common.Common;
import com.shopapp.admin.exception.BrandNotFoundException;
import com.shopapp.admin.repository.BrandRepository;
import com.shopapp.admin.service.BrandService;
import com.shopapp.common.entity.Brand;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandRepository brandRepository;

	@Override
	public Page<Brand> getByPage(int pageNum, String sortField, String sortDir, String keyword) {
		Sort sort = Sort.by(sortField);
		sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
		
		Pageable pageable = PageRequest.of(pageNum - 1, Common.BRANDS_PER_PAGE, sort);
		
		if(keyword == null) {
			return brandRepository.findAll(pageable);
		}
		return brandRepository.findAll(keyword, pageable);
	}
	
	@Override
	public Brand save(Brand brand) {
		return brandRepository.save(brand);
	}

	@Override
	public Brand get(Integer id) throws BrandNotFoundException {
		try {
			return brandRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new BrandNotFoundException("Could not find any brand with id " + id);
		}
	}

	@Override
	public void delete(Integer id) throws BrandNotFoundException {
		Long count = brandRepository.countById(id);
		
		if(count == null || count == 0) {
			throw new BrandNotFoundException("Cound not find any brand with id " +  id);
		}

		brandRepository.deleteById(id);
	}

	@Override
	public String checkUnique(Integer id, String name) {
		boolean isCreatingNew = (id == null || id == 0);
		Brand brand = brandRepository.findByName(name);
		if(isCreatingNew) {
			if(brand != null) {
				return "Duplicate";
			}
		}else {
			if(brand != null && id != brand.getId()) {
				return "Duplicate";
			}
		}
		
		return "OK";
	}
	
	
}
