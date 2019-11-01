package com.javatechie.loadbalance.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class RibbConfig {

	@Autowired
	IClientConfig ribbonClient;

	@Bean
	public IPing  ribbonPing(IClientConfig ribbonClient)//ping(IClientConfig ribbonClient)
	{
		return new PingUrl();
	}
	@Bean
	public IRule ribbonRule(IClientConfig ribbonClient)//rule(IClientConfig ribbonClient)
	{
		return new AvailabilityFilteringRule();
	}
}
