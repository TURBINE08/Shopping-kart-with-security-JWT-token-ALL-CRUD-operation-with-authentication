package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ProductDetails;

public interface ProductDetailsRepo extends JpaRepository< ProductDetails,Integer>  
{

//	void deleteByCategoryid(int id);

	ProductDetails findByCategoryid(int id);



}
