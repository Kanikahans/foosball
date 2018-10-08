package com.know.foosballleaderBrd;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import com.mysql.jdbc.Connection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FoosballLeaderBrdApplicationTests {

	@Autowired
    DataSource dataSource;
	@Test
	public void contextLoads() {
	}
	@Test
	public void test1() throws SQLException {
	    try (Connection connection = dataSource.getConnection()) {
	    	System.out.println("catalog:" + connection.getCatalog());
	        //log.info("catalog:" + connection.getCatalog());
	    }
	}

}
