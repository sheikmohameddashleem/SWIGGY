package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cutomerId;
	@NotNull(message="Name can not be null")
	private String name;
	@NotNull(message="Name can not be null")
	@Email(message="email should be in proper format")
	private String email;
	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	private List<Orders> orders = new ArrayList<>();

	public Customer(@NotNull(message = "Name can not be null") String name,
			@NotNull(message = "Name can not be null") @Email(message = "email should be in proper format") String email,
			List<Orders> orders) {
		super();
		this.name = name;
		this.email = email;
		this.orders = orders;
	}

	
}
