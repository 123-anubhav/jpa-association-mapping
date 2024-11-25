package com.developers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.developers.onetomany.entity.User;
import com.developers.onetoone.runner.OneToManyAppRunner;

@SpringBootApplication
public class JpaPracticeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JpaPracticeApplication.class, args);
		/*
		 * WHEN UN-COMMENT RUNNER CODE THEN UN-COMMENT THIS CODE OneToManyAppRunner
		 * runner = context.getBean(OneToManyAppRunner.class);
		 * 
		 * User emp = runner.getEmp(4); System.out.println(emp);
		 */
	}

}
