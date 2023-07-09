package com.masai.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryPartner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deliveryId;
	private String deliveryName;
	private String address;
	
	 @JsonIgnore
	@OneToMany(mappedBy = "deliveryPartner")
	private List<Orders> orders;
	
	

}
