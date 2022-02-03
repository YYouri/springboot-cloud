package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

	@Value("${config_type.sub_type}")
	private String configStr;
	
	@GetMapping("/test")
	public String test() {
		return configStr;
	}
	/*
	 * @Value("${test.str}") private String configStr;
	 * 
	 * @GetMapping("/test") public String test() { return configStr; }
	 */
}
