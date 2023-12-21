package com.kh.ex02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {
	
	//직접 new PersonServiceImpl() - x
	public static void main(String[] args) {
		BeanFactory factory = new GenericXmlApplicationContext(
				new FileSystemResource("person2.xml"));
		// personService 라는 객체를 얻어 온다.
		PersonService person1 = factory.getBean("personService1", PersonServiceImpl.class);
		PersonService person2 = factory.getBean("personService2", PersonServiceImpl.class);
		person1.sayHello();
		person2.sayHello();
		
	
	}

}
