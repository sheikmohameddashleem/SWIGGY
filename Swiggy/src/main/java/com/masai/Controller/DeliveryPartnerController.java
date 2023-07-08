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
import org.springframework.web.bind.annotation.RestController;

import com.masai.Model.DeliveryPartner;
import com.masai.Services.IDeliveryPartnerService;

import jakarta.validation.Valid;

@RestController
public class DeliveryPartnerController {

	@Autowired
	IDeliveryPartnerService dService;
	
	@GetMapping("/DeliveryPartners")
	public ResponseEntity<List<DeliveryPartner>> getAllCustomers(){
		return new ResponseEntity<List<DeliveryPartner>>(dService.viewAll(),HttpStatus.OK);
	}
	@GetMapping("/DeliveryPartner/{id}")
	public ResponseEntity<DeliveryPartner> getCustomerById(@Valid@PathVariable Long id){
		return new ResponseEntity<DeliveryPartner>(dService.viewById(id),HttpStatus.OK);
	}
	@PostMapping("/DeliveryPartnerAdd")
	public ResponseEntity<DeliveryPartner> addCustomer(@Valid@RequestBody DeliveryPartner c){
		return new ResponseEntity<DeliveryPartner>(dService.create(c),HttpStatus.OK);
	}
	@PutMapping("/DeliveryPartnerUpdate")
	public ResponseEntity<DeliveryPartner> updateCustomer(@Valid@RequestBody DeliveryPartner c){
		return new ResponseEntity<DeliveryPartner>(dService.update(c),HttpStatus.OK);
	}
	@DeleteMapping("/DeliveryPartnerDelete/{id}")
	public ResponseEntity<DeliveryPartner> updateCustomer(@Valid@PathVariable Long id){
		return new ResponseEntity<DeliveryPartner>(dService.delete(id),HttpStatus.OK);
	}
}
