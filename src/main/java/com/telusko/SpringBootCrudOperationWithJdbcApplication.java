package com.telusko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import com.telusko.service.ManageOperations;

@SpringBootApplication
public class SpringBootCrudOperationWithJdbcApplication {

	public static void main(String[] args) {
		
		ApplicationContext context=SpringApplication.run(SpringBootCrudOperationWithJdbcApplication.class, args);
		
		ManageOperations manageOperations=context.getBean(ManageOperations.class);
		manageOperations.task();
		
		
		
		
		
	}

}
