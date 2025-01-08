package com.telusko.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Student {
	
	
	private int id;
	private String address;
	private int age;
	private String name;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Student Object Created..");
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", address=" + address + ", age=" + age + ", name=" + name + "]";
	}
	
	
	

}
