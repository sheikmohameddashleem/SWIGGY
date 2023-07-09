package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.masai.Model.Customer;

public interface ICustomer extends JpaRepository<Customer,Long >,PagingAndSortingRepository<Customer, Long> {

}
