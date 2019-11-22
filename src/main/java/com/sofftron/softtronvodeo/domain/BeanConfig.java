package com.sofftron.softtronvodeo.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
	@Bean("bill")
	@Conditional({WindowsCondition.class})
	public Person person1() {
		return new Person("xiaoming",(short)4);
	}
	
}
