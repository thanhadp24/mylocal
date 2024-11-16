package com.shopapp.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopapp.common.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
