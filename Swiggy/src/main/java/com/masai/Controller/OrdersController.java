package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.masai.Model.Orders;
import com.masai.Services.IOrdersService;

import jakarta.validation.Valid;

public class OrdersController {

	@Autowired
	IOrdersService oService;
	
	@GetMapping("/DeliveryPartners")
	public ResponseEntity<List<Orders>> getAllCustomers(){
		return new ResponseEntity<List<Orders>>(oService.viewAll(),HttpStatus.OK);
	}
	@GetMapping("/DeliveryPartner/{id}")
	public ResponseEntity<Orders> getCustomerById(@Valid@PathVariable Long id){
		return new ResponseEntity<Orders>(oService.viewById(id),HttpStatus.OK);
	}
	@PostMapping("/DeliveryPartnerAdd")
	public ResponseEntity<Orders> addCustomer(@Valid@RequestBody Orders c){
		return new ResponseEntity<Orders>(oService.create(c),HttpStatus.OK);
	}
	@PutMapping("/DeliveryPartnerUpdate")
	public ResponseEntity<Orders> updateCustomer(@Valid@RequestBody Orders c){
		return new ResponseEntity<Orders>(oService.update(c),HttpStatus.OK);
	}
	@DeleteMapping("/DeliveryPartnerDelete/{id}")
	public ResponseEntity<Orders> updateCustomer(@Valid@PathVariable Long id){
		return new ResponseEntity<Orders>(oService.delete(id),HttpStatus.OK);
	}
}
