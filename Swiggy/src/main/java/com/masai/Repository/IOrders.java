package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.Orders;

public interface IOrders extends JpaRepository<Orders, Long> {

//	public List<Orders> findByCustomerId(Long Id);
}
