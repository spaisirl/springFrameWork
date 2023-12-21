package com.kh.ex02;

public class PersonServiceImpl implements PersonService {
	private String name;
	private int age;
	
	// 기본 생성자 없는 상태
	
	public PersonServiceImpl(String name) {
		this.name = name;
	}
	
	public PersonServiceImpl(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public void sayHello() {
		System.out.println("이름:" + this.name);
		System.out.println("나이:" + this.age);
		
	}
	
}
