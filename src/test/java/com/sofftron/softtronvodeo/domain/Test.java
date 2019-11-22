package com.sofftron.softtronvodeo.domain;

import static org.junit.Assert.*;

import java.util.Map;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.bytebuddy.implementation.attribute.AnnotationAppender;

public class Test {

	@org.junit.Test
	public void test() {
		AnnotationConfigApplicationContext ann = new AnnotationConfigApplicationContext(BeanConfig.class);
		 Map<String, Person> ps = ann.getBeansOfType(Person.class);
		 System.out.println(ps);
	}

}
