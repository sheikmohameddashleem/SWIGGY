package com.masai.Services;

import java.util.List;

import com.masai.Model.Orders;
import com.masai.Model.Status;



public interface IOrdersService {

	public Orders create(Orders r);
	public Orders update(Orders r);
	public Orders updateOrderStatus(Status s,Long id);
	public Orders assignToDeliveryPartner(Long did,Long oid);
	public List<Orders> viewAll();
	public Orders viewById(Long id);
	public List<Orders> viewByCustomerId(Long id);
	public Orders delete(Long id);
	

}
