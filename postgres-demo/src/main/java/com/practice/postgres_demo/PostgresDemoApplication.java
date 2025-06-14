package com.practice.postgres_demo;

import java.sql.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostgresDemoApplication {


	/*
		import Package
		load and register
		create connection
		create statement
		execute statement
		process the results
		close
	 */

    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost:5432/demo";
        String userName = "postgres";
        String password = "rekhAjay@0907";
        String sql = "SELECT * FROM student where id % 2 = 0;";

//		Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, userName, password);
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Connection Established");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int age = resultSet.getInt("age");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");

            System.out.println(name + " | " + age + " | " + email);
        }

        con.close();
        System.out.println("Connection Closed!!");


//		SpringApplication.run(PostgresDemoApplication.class, args);
    }

}
