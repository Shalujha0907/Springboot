package com.practice.postgres_demo;

import java.sql.*;

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
        readFromTable();
        updateTheTable();
        delFromTheTable();
        problemWithStatement();
        prepardStatement();

    }

    private static void prepardStatement() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "rekhAjay@0907";
        int id = 14;
        int age = 20;
        String name = "Krishna d";
        String email = "else@gmail.com";

        System.out.println("Connection Established");

        Connection con = DriverManager.getConnection(url, username, password);
        String sql = "INSERT INTO student (id, name, age, email) values (?,?,?,?)";
        PreparedStatement statement = con.prepareStatement(sql);

        statement.setInt(1, id);
        statement.setString(2, name);
        statement.setInt(3, age);
        statement.setString(4, email);
        statement.execute();
        con.close();
        System.out.println("Connection Close");
    }

    private static void problemWithStatement() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "rekhAjay@0907";
        int id = 13;
        int age = 20;
        String name = "kd";
        String email = "something@gmail.com";

        System.out.println("Connection Established");

        Connection con = DriverManager.getConnection(url, username, password);
        Statement statement = con.createStatement();
        // problem with the statement
        String sql = "INSERT INTO student (id, name, age, email) values (" + id + ",  '" + name + "'," + age + ",  '" + email + "')";

        boolean execute = statement.execute(sql);

        System.out.println(execute);
        con.close();
        System.out.println("Connection Close");
    }

    private static void delFromTheTable() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "rekhAjay@0907";

        System.out.println("Connection Established");

        Connection con = DriverManager.getConnection(url, username, password);
        Statement statement = con.createStatement();
        String sql = "DELETE FROM student WHERE id=5";

        boolean execute = statement.execute(sql);

        System.out.println(execute);
        con.close();
        System.out.println("Connection Close");
    }

    private static void updateTheTable() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "rekhAjay@0907";

        System.out.println("Connection Established");

        Connection con = DriverManager.getConnection(url, username, password);
        Statement statement = con.createStatement();
//        String sql = "INSERT INTO student (id, name, age, email) values (12, 'ankita', 21, 'ankita@gmail.com')";
        String sql = "UPDATE student set name='karnnn' WHERE id=12";
        boolean execute = statement.execute(sql);

        System.out.println(execute);
        con.close();
        System.out.println("Connection Close");
    }

    private static void readFromTable() throws SQLException {
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
    }

}
