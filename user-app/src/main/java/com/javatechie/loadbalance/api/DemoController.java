package com.javatechie.loadbalance.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {
	@Autowired
	private LoadBalancerClient loadBalancer;
	
	@GetMapping("/getEndPoint")	
	public String greeting()
	{
		ServiceInstance instance = loadBalancer.choose("Myservice");
		
		return instance.getHost() + instance.getPort();		
	}
	
	//2.cagri
	@Autowired
	private RestTemplate template;
	
	@Bean
	@LoadBalanced
	public RestTemplate template() 
	{
		return new RestTemplate();
	}
	
	@GetMapping("/invoke")
	public String invokeChatbook()
	{
		//String url = "http://localhost:8081/chatbook-application/chat";

		String url = "http://chatbook/chat";

		return template.getForObject(url, String.class);
	}

}
