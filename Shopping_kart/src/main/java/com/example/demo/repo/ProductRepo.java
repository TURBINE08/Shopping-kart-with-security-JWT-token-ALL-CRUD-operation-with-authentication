package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Product;

public interface ProductRepo extends JpaRepository< Product,Integer>  {

//	void deleteBySubCategoryid(int id);

//	Product findBySubCategoryid(int id);

	Product findByCategoryid(int id);

//	Product findByCategoryid(int id);



}
