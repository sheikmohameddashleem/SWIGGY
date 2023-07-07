package com.masai.Services;

import java.util.List;

import com.masai.Model.DeliveryPartner;

public interface IDeliveryPartnerService {

	public DeliveryPartner create(DeliveryPartner r);
	public DeliveryPartner update(DeliveryPartner r);
	public DeliveryPartner isPresent(Long id);
	public List<DeliveryPartner> viewAll();
	public DeliveryPartner viewById(Long id);
	public DeliveryPartner delete(Long id);
}
