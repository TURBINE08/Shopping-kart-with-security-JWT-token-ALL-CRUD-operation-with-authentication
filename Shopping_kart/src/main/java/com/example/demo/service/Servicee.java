package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDetails;
import com.example.demo.entity.common;
import com.example.demo.repo.AdminRepo;
import com.example.demo.repo.CategoryRepo;
import com.example.demo.repo.ProductDetailsRepo;
import com.example.demo.repo.ProductRepo;

@Service
@Component
public class Servicee

{
	@Autowired
	private Admin admin;

	@Autowired
	private Category cat;

	@Autowired
	private Product pro;

	@Autowired
	private ProductDetails pd;

	@Autowired
	private AdminRepo adminrepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private ProductDetailsRepo productDetailsRepo;

	public void saveEntities(common com) {
		admin.setAdmin(com.getAdmin());
		admin.setEmployee(com.getEmployee());
		admin.setUsername(com.getUsername());
		admin.setPassword(com.getPassword());
		adminrepo.save(admin);

		cat.setCategoryname(com.getCategory());
		Category category = categoryRepo.save(cat);
		int catid = category.getCategoryid();
//		System.err.println(catid);

		pro.setCategoryid(catid);
		pro.setProduct(com.getProduct());
		Product product = productRepo.save(pro);
		System.err.println("888888888 " + product.getSubCategoryid());

		pd.setProductname(com.getProductname());
		pd.setProdctprice(com.getProdctprice());
		pd.setProductquantity(com.getProductquantity());
		pd.setCategoryid(catid);
//		pd.setProductdetailsid(product.getSubCategoryid());
		pd.setSubcategoryid(product.getSubCategoryid());
		productDetailsRepo.save(pd);

		cat.setCategoryid(0);
		pro.setSubCategoryid(0);
		admin.setAdminID(0);
		pd.setProductdetailsid(0);

	}

	public void deletedata(int id) {
		System.err.println("0000000000 " + id);
//		categoryRepo.deleteByCategoryid(id);
		categoryRepo.deleteById(id);
//		categoryRepo.findByCategoryid(id);
		System.err.println("111111111 " + id);
		Product proo = (Product) productRepo.findByCategoryid(id);
		productRepo.deleteById(proo.getSubCategoryid());
//		productRepo.deleteBySubCategoryid(id);
//		productRepo.deleteById(id);
		System.err.println("2222222222 " + id);
//		productDetailsRepo.deleteByCategoryid(id);
		ProductDetails prod = productDetailsRepo.findByCategoryid(id);
		productDetailsRepo.deleteById(prod.getProductdetailsid());
		System.err.println("3333333333 " + id);
	}

//	

	public List<Category> getalldataCategory() {
		List<Category> rtn = categoryRepo.findAll();
		return rtn;
	}

	public List<Product> getalldataProduct() {
		List<Product> rtn = productRepo.findAll();
		return rtn;
	}

	public List<ProductDetails> getalldataProductdetails() {
		List<ProductDetails> rtn = productDetailsRepo.findAll();
		return rtn;
	}

	public List<Admin> getalldataAdmin() {

		List<Admin> rtn = adminrepo.findAll();
		return rtn;
	}

	public Optional<Admin> getalldataAdmin(int id) {

		Optional<Admin> rtn = adminrepo.findById(id);
		return rtn;
	}

	public Optional<Category> getalldataCategory(int id) {
		Optional<Category> rtn = categoryRepo.findById(id);
		return rtn;
	}

	public Product getalldataProduct(int id) {
		Product rtn = productRepo.findByCategoryid(id);
		return rtn;
	}

	public ProductDetails getalldataProductdetails(int id) {
		ProductDetails rtn = productDetailsRepo.findByCategoryid(id);
		return rtn;
	}

	public Product updateProduct(int id) {
		Product rtn = productRepo.findByCategoryid(id);
//		System.err.println(rtn.getProduct());
		return rtn;
	}

	public Product updatedProductt(common com) {
		Product pro = productRepo.findByCategoryid(com.getID());
		pro.setProduct(com.getProduct());
		Product updatedrtn = productRepo.save(pro);
		return updatedrtn;
	}

	public ProductDetails updateProductdetails(int id) {
		ProductDetails rtn = productDetailsRepo.findByCategoryid(id);
		return rtn;
	}

	public ProductDetails updatedProductdetails(common com) {
		ProductDetails pd = productDetailsRepo.findByCategoryid(com.getID());
		pd.setProductname(com.getProductname());
		pd.setProdctprice(com.getProdctprice());
		pd.setProductquantity(com.getProductquantity());
		ProductDetails rtn = productDetailsRepo.save(pd);
		return rtn;
	}

	public Boolean exist(String admin2, String userName, String password) {

		Boolean rtn = adminrepo.existsByAdminAndUsernameAndPassword(admin2, userName, password);

		return rtn;
	}

	public boolean existss(String employee, String username, String password) {
		Boolean rtn = adminrepo.existsByEmployeeAndUsernameAndPassword(employee, username, password);
		
		return rtn;
	}

	public Category updatecategory(common com) 
	{
		Category catt = categoryRepo.findByCategoryid(com.getID());
		
//		Category catt = categoryRepo.findById(com.getID());
		catt.setCategoryname(com.getCategory());
		Category rtn =categoryRepo.save(catt);
		
		return rtn;
	}

	public Category updatecategory(int id) {
		Category rtn = categoryRepo.findByCategoryid(id);
		
		return rtn;
	}

}
