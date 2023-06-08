package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDetails;
import com.example.demo.entity.common;
import com.example.demo.service.Servicee;

@Component
@RestController
@RequestMapping("/api")
public class Homee {

	@Autowired
	private Servicee servicee;

	@RequestMapping("/welcome")
	public String welcome() {
		String text = "this is private page";
		return text;
	}

	@PostMapping("/saveall")
	public ResponseEntity<?> save(@RequestBody common com) {
		servicee.saveEntities(com);
		Map<String, String> map = new LinkedHashMap<>();
		map.put("Admin", "ok");
		return new ResponseEntity<>(map, HttpStatus.OK);

	}

	@DeleteMapping("/deleteByID/{id}")
	public ResponseEntity<?> deletebyid(@PathVariable int id) {
		System.err.println("********* " + id);
		servicee.deletedata(id);
		Map<String, String> map = new LinkedHashMap<>();
		map.put("status", "ok");
		return new ResponseEntity<>(map, HttpStatus.OK);

	}

	@GetMapping("/getall")
	public ResponseEntity<?> viewAll() {
		List<Admin> adm = servicee.getalldataAdmin();

		List<Category> cat = servicee.getalldataCategory();

		List<Product> pro = servicee.getalldataProduct();

		List<ProductDetails> pds = servicee.getalldataProductdetails();

		Map<String, Object> map = new LinkedHashMap<>();
		map.put("Admin", adm);
		map.put("Category", cat);
		map.put("Product", pro);
		map.put("ProductDetails", pds);
		return new ResponseEntity<>(map, HttpStatus.OK);

	}

	@GetMapping("/getallById/{id}")
	public ResponseEntity<?> viewById(@PathVariable int id) {

//		Optional<Admin> adm = servicee.getalldataAdmin(id);

		Optional<Category> cat = servicee.getalldataCategory(id);

		Product pro = servicee.getalldataProduct(id);

		ProductDetails pds = servicee.getalldataProductdetails(id);

		Map<String, Object> map1 = new LinkedHashMap<>();
//		map1.put("Admin", adm);
		map1.put("Category", cat);
		map1.put("Product", pro);
		map1.put("ProductDetails", pds);
		return new ResponseEntity<>(map1, HttpStatus.OK);
	}

	@PutMapping("update")
	public ResponseEntity<?> updateById(@RequestBody common com) {

		Product pro = servicee.updateProduct(com.getID());
		ProductDetails prod = servicee.updateProductdetails(com.getID());
		if (com.getID() == pro.getCategoryid() && com.getID() == prod.getCategoryid()) {
			Product updatedproduct = servicee.updatedProductt(com);

			ProductDetails upprodtls = servicee.updatedProductdetails(com);

			Map<String, Object> map11 = new LinkedHashMap<>();
			map11.put("Product", updatedproduct);
			map11.put("ProductDetails", upprodtls);
			return new ResponseEntity<>(map11, HttpStatus.OK);
		} else {
			Map<String, String> map12 = new LinkedHashMap<>();
			map12.put("status", "false");
			map12.put("message", "invalid user id");
			return new ResponseEntity<>(map12, HttpStatus.BAD_REQUEST);
		}

	}
	
//	@PutMapping("update")
//	public ResponseEntity<?> update(@RequestBody common com) {
//		
//		Boolean x = servicee.existss(com.getEmployee(),com.getUsername(),com.getPassword());
//		
//		if(com.getAdmin()!=null && com.getEmployee()==null)
//		{
//			Boolean k = servicee.exist(com.getAdmin(),com.getUsername(),com.getPassword());
//			if(k)
//			{
//				Product pro = servicee.updateProduct(com.getID());
//				ProductDetails prod = servicee.updateProductdetails(com.getID());
////				Category cate = servicee.updatecategory(com.getID());
//				
//				if (com.getID() == pro.getCategoryid() && com.getID() == prod.getCategoryid()  ) 
//				{
//					
//					Category updatedcategory = servicee.updatecategory(com);
//					
//					Product updatedproduct = servicee.updatedProductt(com);
//
//					ProductDetails upprodtls = servicee.updatedProductdetails(com);
//
//					Map<String, Object> map11 = new LinkedHashMap<>();
//					map11.put("category", updatedcategory);
//					map11.put("Product", updatedproduct);
//					map11.put("ProductDetails", upprodtls);
//					return new ResponseEntity<>(map11, HttpStatus.OK);
//				} else {
//					Map<String, String> map12 = new LinkedHashMap<>();
//					map12.put("status", "false");
//					map12.put("message", "invalid user id");
//					return new ResponseEntity<>(map12, HttpStatus.BAD_REQUEST);
//				}
//			}else
//			{
//				Map<String, String> map13 = new LinkedHashMap<>();
//				map13.put("status", "false");
//				map13.put("message", "invalid user");
//				return new ResponseEntity<>(map13, HttpStatus.BAD_REQUEST);
//			}
//			
//		}
////		Boolean k1 = servicee.exist(com.getEmployee(),com.getUsername(),com.getPassword());
//		else if(com.getEmployee()!=null && servicee.existss(com.getEmployee(),com.getUsername(),com.getPassword()))
//		{
//			System.err.println("56566666 1"+x);
//			Product pro = servicee.updateProduct(com.getID());
////			int  y = pro.getCategoryid();
//			System.err.println("56566666 2"+x);
//			ProductDetails prod = servicee.updateProductdetails(com.getID());
//			System.err.println("56566666 3"+x);
//			if (com.getID() == pro.getCategoryid() && com.getID() == prod.getCategoryid()) {
//				System.err.println("56566666 4"+x);
//				Product updatedproduct = servicee.updatedProductt(com);
//
//				ProductDetails upprodtls = servicee.updatedProductdetails(com);
//
//				Map<String, Object> map11 = new LinkedHashMap<>();
//				map11.put("Product", updatedproduct);
//				map11.put("ProductDetails", upprodtls);
//				return new ResponseEntity<>(map11, HttpStatus.OK);
//			} else {
//				Map<String, String> map12 = new LinkedHashMap<>();
//				map12.put("status", "false");
//				map12.put("message", "invalid user id");
//				return new ResponseEntity<>(map12, HttpStatus.BAD_REQUEST);
//			}
//		}else
//		{
//			Map<String, String> map12 = new LinkedHashMap<>();
//			map12.put("status", "false");
//			map12.put("message", "Enter proper input");
//			return new ResponseEntity<>(map12, HttpStatus.BAD_REQUEST);
//		}
//
//	}

}
