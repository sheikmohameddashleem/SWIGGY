package com.masai.Model;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class DeliveryPartner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long deliveryPartnerId;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	@NotNull(message = "Name is mandotory")
	@Size(min = 2, message = "name should be of greater than 2 letters")
	private String name;

	@NotNull
	@Pattern(regexp = "^[6-9][0-9]{9}")
	private String phoneNumber;
	
	@OneToMany(mappedBy="deliveryPartner")
	private List<Orders> orders;

	@Enumerated(EnumType.STRING)
	private Condition status;

//	public DeliveryPartner() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	public DeliveryPartner(
			@NotNull(message = "Name is mandotory") @Size(min = 2, message = "name should be of greater than 2 letters") String name,
			@NotNull @Pattern(regexp = "^[6-9][0-9]{9}") String phoneNumber, Condition status) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Condition getStatus() {
		return status;
	}

	public void setStatus(Condition status) {
		this.status = status;
	}

	public Long getDeliveryPartnerId() {
		return deliveryPartnerId;
	}

	@Override
	public String toString() {
		return "DeliveryPartner [deliveryPartnerId=" + deliveryPartnerId + ", name=" + name + ", phoneNumber="
				+ phoneNumber + ", status=" + status + "]";
	}

}
