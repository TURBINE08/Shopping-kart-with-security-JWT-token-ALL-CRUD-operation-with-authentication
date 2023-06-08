package com.example.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Category;

@EnableJpaRepositories
public interface AdminRepo extends JpaRepository<Admin,Integer> 
{

//	Boolean existsByAdmin(String admin2);

	Boolean existsByAdminAndUsernameAndPassword(String admin2, String userName, String password);

	Boolean existsByEmployeeAndUsernameAndPassword(String employee, String username, String password);

	Admin findByUsername(String userName);



	

}
 