package com.sofftron.softtronvodeo.domain;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;


public class Person {
	private String name;
	private short age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public short getAge() {
		return age;
	}
	public void setAge(short age) {
		this.age = age;
	}
	public Person(String name, short age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
