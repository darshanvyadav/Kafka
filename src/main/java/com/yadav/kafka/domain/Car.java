package com.yadav.kafka.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EntityScan // considered as base package for scanning entities by spring boot auto configuration
public class Car {

	
	private long id;
	private String carName;
	private String carModel;
	private String carMake;
	private int carYear;
	
}
