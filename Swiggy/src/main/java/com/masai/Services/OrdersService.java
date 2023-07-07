package com.masai.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.NotAvailableException;
import com.masai.Exceptions.NotFoundException;
import com.masai.Model.Condition;
import com.masai.Model.DeliveryPartner;
import com.masai.Model.Orders;
import com.masai.Model.Status;
import com.masai.Repository.IOrders;

@Service
public class OrdersService implements IOrdersService {

	@Autowired
	private IOrders orders;
	@Autowired
	private IDeliveryPartnerService dp;
	
	@Override
	public Orders create(Orders r) {
		// TODO Auto-generated method stub
		return orders.save(r);
	}

	@Override
	public Orders update(Orders r) {
		// TODO Auto-generated method stub
		Optional<Orders> opt=orders.findById(r.getOrderId());
		if(!opt.isPresent()) {
			throw new NotFoundException("Not Found Exception");
		}
		
		return orders.save(r);
	}

	@Override
	public Orders updateOrderStatus(Status s,Long id) {
		// TODO Auto-generated method stub
		Optional<Orders> opt=orders.findById(id);
		if(!opt.isPresent()) {
			throw new NotFoundException("Not Found Exception");
		}
		Orders o=opt.get();
		o.setOrderStatus(s);
		return orders.save(o);
	}

	@Override
	public List<Orders> viewAll() {
		// TODO Auto-generated method stub
		return orders.findAll();
	}

	@Override
	public Orders viewById(Long id) {
		// TODO Auto-generated method stub
		Optional<Orders> opt=orders.findById(id);
		if(!opt.isPresent()) {
			throw new NotFoundException("Not Found Exception");
		}
		return opt.get();
	}

	@Override
	public List<Orders> viewByCustomerId(Long id) {
		// TODO Auto-generated method stub
		List<Orders> opt=orders.findAll();
		List<Orders> cid=new ArrayList<Orders>();
		for(Orders i:opt) {
			if(i.getCustomerId().getCustomerId()== id) {
				cid.add(i);
			}
		}
		return cid;
	}

	@Override
	public Orders delete(Long id) {
		// TODO Auto-generated method stub
		Optional<Orders> opt=orders.findById(id);
		if(!opt.isPresent()) {
			throw new NotFoundException("Not Found Exception");
		}
		orders.deleteById(id);
		return opt.get();
	}

	@Override
	public Orders assignToDeliveryPartner(Long did, Long oid) {
	
		Optional<Orders> opt=orders.findById(oid);
		if(!opt.isPresent()) {
			throw new NotFoundException("No Orders Found with id");
		}
		DeliveryPartner dps=dp.isPresent(did);
		
		if(dps.getStatus().equals(Condition.ENGAGED)) {
			throw new NotAvailableException("Not available");
		}
		if(opt.get().getOrderStatus().equals(Status.DELIVERED) || opt.get().getOrderStatus().equals(Status.ON_THE_WAY)) {
			throw new NotAvailableException("Already Assigned");
		}
		Orders order= opt.get();
		order.setDeliveryPartnerId(dps);
		dps.setStatus(Condition.ENGAGED);
		
		
		return orders.save(order);
	}

}
