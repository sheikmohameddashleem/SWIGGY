package com.masai.Exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//
//
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MyErrorDetails {

	private LocalDateTime timeStamps;
	private String message;
	private String description;
//	public MyErrorDetails(LocalDateTime timeStamps, String message, String description) {
//		super();
//		this.timeStamps = timeStamps;
//		this.message = message;
//		this.description = description;
//	}
//	public MyErrorDetails() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public LocalDateTime getTimeStamps() {
//		return timeStamps;
//	}
//	public void setTimeStamps(LocalDateTime timeStamps) {
//		this.timeStamps = timeStamps;
//	}
//	public String getMessage() {
//		return message;
//	}
//	public void setMessage(String message) {
//		this.message = message;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
	
	
    	
}
