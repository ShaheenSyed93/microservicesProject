package com.learn.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.microservices.limitsservice.bean.Limits;
import com.learn.microservices.limitsservice.configuration.LimitsConfiguration;

@RestController
public class LimitsController {
	
	@Autowired
	private LimitsConfiguration conf;
	
	@GetMapping("/limits")
	public Limits getLimitValue(){
		
		return new Limits(conf.getMin(),conf.getMax());
		//return new Limits(1,10);
		
		
	}

}
