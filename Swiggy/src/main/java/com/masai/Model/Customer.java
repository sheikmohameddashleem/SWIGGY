package com.masai.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long customerId;
	
	@NotNull
	private String customerName;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	private String address;
	
	@OneToMany(mappedBy="customer")
	private List<Orders> orders=new ArrayList<>();

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String customerName, String email, String address) {
		super();
		this.customerName = customerName;
		this.email = email;
		this.address = address;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getCustomerId() {
		return customerId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", email=" + email
				+ ", address=" + address + "]";
	}
	
	
}
