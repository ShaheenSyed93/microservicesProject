package com.learn.microservices.currencyexchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

	@Autowired
	private CurrencyExchangeRepository repo;

	@Autowired
	private Environment environment;

	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValues(@PathVariable String from, @PathVariable String to) {

		// CurrencyExchange currencyExchange = new
		// CurrencyExchange(1000L,"USD","INR",BigDecimal.valueOf(10));
		CurrencyExchange currencyExchange = repo.findByFromAndTo(from, to);
		
		if(currencyExchange == null){
			throw new RuntimeException("Data not found for from ::"+from +"::and for to::"+to);
		}
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnv(port);
		return currencyExchange;

	}

}
