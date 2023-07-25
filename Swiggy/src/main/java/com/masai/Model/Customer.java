package com.masai.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User {

	@Column(unique=true)
	private Long customerId;
	
	@NotNull
	private String name;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	private String address;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="customer")
	private List<Orders> orders=new ArrayList<>();


	public Customer(String username, @NotNull String password, @NotNull String role, Long customerId,
			@NotNull String name, @NotNull @Email String email, @NotNull String address, List<Orders> orders) {
		super(username, password, role);
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.address = address;
		this.orders = orders;
	}

	
	
}
