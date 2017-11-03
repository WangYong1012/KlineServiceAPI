package com.brave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class ApplicationBootstrap {

	public static void main(String[] args)
	{
		//程序入口点
		SpringApplication.run(ApplicationBootstrap.class, args);
	}
}
