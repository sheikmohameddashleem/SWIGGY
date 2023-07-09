package com.masai.Services;

import org.springframework.data.domain.Page;

import com.masai.Model.Customer;

public interface ICustomerSevice {

	public Customer AddCustomer(Customer c);
	public Customer UpdateCustomer(Customer C);
	public Page<Customer> viewAll();
	public Customer viewCustomerById(Long id);
	public Customer DeleteCustomer(Long id);
}
