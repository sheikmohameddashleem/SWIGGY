package com.masai.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manager extends User {

	@Column(unique = true)
	private Long managerId;
	
	@NotNull
	private String name;
	
	@NotNull
	@Size(min=10,max=10)
	private String mobileNo;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	private String position;

	public Manager(String username, @NotNull String password, @NotNull String role, @NotNull String name,
			@NotNull @Size(min = 10, max = 10) String mobileNo, @NotNull @Email String email,
			@NotNull String position) {
		super(username, password, role);
		this.name = name;
		this.mobileNo = mobileNo;
		this.email = email;
		this.position = position;
	}

	
	
}
