package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SubCategory")
@Component
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @SequenceGenerator(name = "player_seq", sequenceName = "player_sequence")
	private int subCategoryid;
	private int categoryid;
	private String product;
	
}
