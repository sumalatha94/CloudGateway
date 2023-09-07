package com.example.demo.cloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {
	
	@GetMapping("orderServiceFallBack")
	public String orderServiceFallBack()
	{
		return "order service is down";
	}

	@GetMapping("productServiceFallBack")
	public String productServiceFallBack()
	{
		return "product service is down";
	}
	
	@GetMapping("paymentServiceFallBack")
	public String paymentServiceFallBack()
	{
		return "payment service is down";
	}
}
