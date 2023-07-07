package com.masai.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="OrdersTable")
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	private Long orderId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customerId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	private Restaurant restaurantId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="deliveryPartnerId")
	private DeliveryPartner deliveryPartnerId;
	
	private List<String> items=new ArrayList<>();
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Status orderStatus;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(Customer customerId, Restaurant restaurantId, DeliveryPartner deliveryPartnerId, List<String> items,
			@NotNull Status orderStatus) {
		super();
		this.customerId = customerId;
		this.restaurantId = restaurantId;
		this.deliveryPartnerId = deliveryPartnerId;
		this.items = items;
		this.orderStatus = orderStatus;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Restaurant getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Restaurant restaurantId) {
		this.restaurantId = restaurantId;
	}

	public DeliveryPartner getDeliveryPartnerId() {
		return deliveryPartnerId;
	}

	public void setDeliveryPartnerId(DeliveryPartner deliveryPartnerId) {
		this.deliveryPartnerId = deliveryPartnerId;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	public Status getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Status orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customerId=" + customerId + ", restaurantId=" + restaurantId
				+ ", deliveryPartnerId=" + deliveryPartnerId + ", items=" + items + ", orderStatus=" + orderStatus
				+ "]";
	}

	
	
}
