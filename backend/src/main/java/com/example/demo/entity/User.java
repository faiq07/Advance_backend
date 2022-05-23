package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Data
@Entity
public class User {
	@Id
	GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer Uno;
	private String username;
	private String email;
	private String password;
	private String phonenumber;
	private String Address;

}
