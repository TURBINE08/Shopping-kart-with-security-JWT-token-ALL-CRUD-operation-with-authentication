package com.example.demo.entity;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class common 
{
	 
	@Id
	private int iD;
	private String Admin;
	private String Employee;
	private String username;
	private String password;
	private String category;
	private String product;
//	private int Productname1;
	private String productname;
	private String prodctprice;
	private String productquantity;
	

}
