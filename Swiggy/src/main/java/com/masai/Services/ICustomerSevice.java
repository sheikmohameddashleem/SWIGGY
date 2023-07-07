package com.masai.Services;

import java.util.List;

import com.masai.Model.Customer;

public interface ICustomerSevice {

	public Customer AddCustomer(Customer c);
	public Customer UpdateCustomer(Customer C);
	public List<Customer> viewAll();
	public Customer viewCustomerById(Long id);
	public Customer DeleteCustomer(Long id);
}
