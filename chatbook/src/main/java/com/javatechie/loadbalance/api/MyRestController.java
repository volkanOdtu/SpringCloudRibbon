package com.javatechie.loadbalance.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/chat")
	public String chatNow()
	{
		return "application is on port: " + port;
	}

}
