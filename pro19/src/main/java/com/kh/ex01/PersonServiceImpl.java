package com.kh.ex01;

public class PersonServiceImpl implements PersonService {
	private String name;
	private int age;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public void sayHello() {
		System.out.println("이름:" + this.name);
		System.out.println("나이:" + this.age);
		
	}
	
}
