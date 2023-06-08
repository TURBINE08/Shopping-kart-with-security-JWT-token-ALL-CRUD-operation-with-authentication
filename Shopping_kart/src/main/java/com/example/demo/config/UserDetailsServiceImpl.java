//package com.example.demo.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.example.demo.entity.Admin;
//import com.example.demo.repo.AdminRepo;
//
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//	@Autowired
//	private AdminRepo adminRepo;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//		Admin adm = adminRepo.getByUserName(username);
//		 if(adm == null)
//		 {
//			 System.err.println("could not found user");
//		 }
//		
//		 CustomUserDetails customUserDetails = new CustomUserDetails(adm);
//		 
//		return customUserDetails;
//	}
//
//}
