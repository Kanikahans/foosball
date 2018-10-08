package com.know.foosballleaderBrd;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.know.controllers")
public class FoosballLeaderBrdApplication {
	
	@Autowired
    DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(FoosballLeaderBrdApplication.class, args);
		//System.out.println("Our DataSource is = " + dataSource);
		 
	}
}
