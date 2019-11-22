package com.softtron.softtronvodeo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.softtron"})
@MapperScan("com.softtron.softtronvodeo.dao")
public class Init {
	public static void main(String[] args) {
		SpringApplication.run(Init.class, args);
	}
}