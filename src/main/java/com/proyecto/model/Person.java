package com.proyecto.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Person {
	@NotNull
	private String name;
	@NotNull 
	@Min(18)
	private int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Person() {}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
