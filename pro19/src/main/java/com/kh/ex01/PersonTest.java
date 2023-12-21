package com.kh.ex01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {
	
	//직접 new PersonServiceImpl() - x
	public static void main(String[] args) {
		BeanFactory factory = new GenericXmlApplicationContext(
				new FileSystemResource("person.xml"));
		// personService 라는 객체를 얻어 온다.
		PersonService person = factory.getBean("personService", PersonServiceImpl.class);
		PersonService person2 = factory.getBean("personService", PersonServiceImpl.class);
		person.sayHello();
		person2.sayHello();
		System.out.println("person:" + person);
		System.out.println("person2:" + person2);
	}

}
