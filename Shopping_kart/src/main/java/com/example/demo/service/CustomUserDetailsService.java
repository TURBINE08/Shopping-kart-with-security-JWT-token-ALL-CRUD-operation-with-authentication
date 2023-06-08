package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.repo.AdminRepo;
@Service
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private AdminRepo adminRepo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		System.err.println(userName);
		Admin ob = adminRepo.findByUsername(userName);
//		
//		
//		if(userName.equals("Durgesh"))
//		{
//			return new User("Durgesh","Durgesh@123",new ArrayList<>());
////			new ArrayList<>()
//		}else
//		{
//			throw new UsernameNotFoundException("user not found");
//		}
//		return null;
		
		
		
		
		

		
		if(userName.equals(ob.getUsername()) && ob != null)
		{
			return new User(ob.getUsername(),ob.getPassword(),new ArrayList<>());
//			new ArrayList<>()
		}else
		{
			throw new UsernameNotFoundException("user not found");
		}
	}

	 
}


//@Override
//public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//	
//	if(userName.equals("Durgesh"))
//	{
//		return new User(username:"Durgesh",password:"Durgesh@123",new ArrayList<>());
//	}else
//	{
//		throw new UsernameNotFoundException("user not found");
//	}
//	return null;
//}