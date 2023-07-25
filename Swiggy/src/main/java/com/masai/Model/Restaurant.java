package com.masai.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Restaurant {

	@NotNull
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long restaurantId;
	
	@NotNull
	private String restaurantName;
	
	@NotNull
	private String address;
	
	@OneToMany(mappedBy="restaurant")
	private List<Orders> orders;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	public Restaurant(String restaurantName, String address) {
		super();
		this.restaurantName = restaurantName;
		this.address = address;
	}

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", address="
				+ address + "]";
	}
	
	
}
