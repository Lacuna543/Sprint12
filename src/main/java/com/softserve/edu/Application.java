package com.softserve.edu;

import com.softserve.edu.dto.MentorStudent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	MentorStudent m = context.getBean("MentorStudent", MentorStudent.class);

	//context.close();
}
