package com.masai.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.NotFoundException;
import com.masai.Model.Customer;
import com.masai.Repository.ICustomer;

@Service
public class CustomerService implements ICustomerSevice {

	@Autowired
	private ICustomer custRepo;
	
	
	public CustomerService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Customer AddCustomer(Customer c) {
		if(c==null)throw new NotFoundException("Value is Null");
		Customer customer=custRepo.findById(c.getCustomerId()).get();
		if(customer!=null)throw new NotFoundException("Already Exists");
		
		return custRepo.save(c);
	}

	@Override
	public Customer UpdateCustomer(Customer C) {
		// TODO Auto-generated method stub
		Optional<Customer> customer=custRepo.findById(C.getCustomerId());
		if(!customer.isPresent()) {
			throw new NotFoundException("Customer not found");
		}
		return custRepo.save(C);
	}

	@Override
	public Page<Customer> viewAll() {
		
		return custRepo.findAll(PageRequest.of(0, 5));
	}

	@Override
	public Customer viewCustomerById(Long id) {
		// TODO Auto-generated method stub
		return custRepo.findById(id).orElseThrow(()-> new NotFoundException("No Customer found"));
	}

	@Override
	public Customer DeleteCustomer(Long id) {
		// TODO Auto-generated method stub
		Optional<Customer> opt=custRepo.findById(id);
		if(!opt.isPresent()) {
			throw new NotFoundException("No Customer Found");
		}
		custRepo.deleteById(id);
		return opt.get();
	}

}
