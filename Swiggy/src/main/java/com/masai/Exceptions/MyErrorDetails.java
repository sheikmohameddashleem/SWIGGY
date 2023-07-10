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
    	
}
