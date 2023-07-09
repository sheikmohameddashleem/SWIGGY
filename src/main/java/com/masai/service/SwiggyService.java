package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.exception.SwiggyException;
import com.masai.model.Customer;
import com.masai.model.DeliveryPartner;
import com.masai.model.Orders;
import com.masai.model.Resturant;
import com.masai.repository.CustomerRepository;
import com.masai.repository.DelRepository;
import com.masai.repository.OrderRepository;
import com.masai.repository.RestRepository;

@Service
public class SwiggyService {
	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private DelRepository delRepository; 
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private RestRepository repository ;
	
	public Customer addCustomer(Customer customer) throws SwiggyException{
		
		if(customer == null) throw new  SwiggyException("Value is null") ;
//		Customer customer2 = customerRepository.findById(customer.getCutomerId()).get() ;
//		if(customer2 != null) throw new SwiggyException("Customer already exist") ;
		Customer customer3 = customerRepository.save(customer) ;
		return customer3 ;
	}
	
	public Resturant  addRest(Resturant res) throws SwiggyException{
		
		if(res == null) throw new  SwiggyException("Value is null") ;
//		Customer customer2 = customerRepository.findById(customer.getCutomerId()).get() ;
//		if(customer2 != null) throw new SwiggyException("Customer already exist") ;
		Resturant res2 = repository.save(res) ;
		return res2 ;
	}
	
public DeliveryPartner  addDP(DeliveryPartner dp) throws SwiggyException{
		
		if(dp == null) throw new  SwiggyException("Value is null") ;
//		Customer customer2 = customerRepository.findById(customer.getCutomerId()).get() ;
//		if(customer2 != null) throw new SwiggyException("Customer already exist") ;
		return delRepository.save(dp) ;
	}
	
	public Orders giveOrder(Orders order , Integer customerId , Integer resId , Integer dpId ) throws SwiggyException {
			Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new SwiggyException("Null value") ) ;
			Resturant rest = repository.findById(resId).orElseThrow(() -> new SwiggyException("Null value")) ;
			DeliveryPartner dp = delRepository.findById(dpId).orElseThrow(() -> new SwiggyException("No Del Pat"));
			order.setCustomer(customer) ;
			customer.getOrders().add(order) ;
			rest.getOrders().add(order) ;
			order.setResturant(rest) ;
			order.setDeliveryPartner(dp);
			dp.getOrders().add(order);
			return orderRepository.save(order) ;
	}
	
	public List<Orders> getOrder(){
		Pageable p = PageRequest.of(0, 5 , Sort.by("orderId")) ;
		List<Orders> orders = orderRepository.findAll(p).getContent() ;
		if(orders.isEmpty()) throw new SwiggyException("No order") ;
		return orders ;
	}
}
