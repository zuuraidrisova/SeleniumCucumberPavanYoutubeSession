package com.jdbcAPI;

import org.junit.Test;

import java.sql.*;
import java.util.Stack;

public class MySQL_DatabaseTesting {

    @Test
    public void testDatabase_usingMysqlDriver() throws SQLException {


        // added mysql pom dependency for mysql driver
        // we provided connection string , username and password
        // and used the utility to make connection

        String connectionStr = "jdbc:mysql://18.233.97.71:3306/library1";
        String username = "library1_client" ;
        String password = "WVF4NdGXCKHeE6VQ" ;

        Connection connection = DriverManager.getConnection(connectionStr, username, password);

        Statement statement = connection.createStatement();

        String query = "select * from books";

        ResultSet resultSet = statement.executeQuery(query);

        while(resultSet.next()){

            System.out.println("result = " + resultSet.getString(2));
        }


        connection.close();
        statement.close();
        resultSet.close();
    }


}
