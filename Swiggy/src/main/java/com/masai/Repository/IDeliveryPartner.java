package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.DeliveryPartner;

public interface IDeliveryPartner extends JpaRepository<DeliveryPartner, Long> {

}
