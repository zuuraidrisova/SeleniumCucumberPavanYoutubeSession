package com.jdbcAPI;

import org.junit.Test;

import java.sql.*;

public class OracleJDBC_DatabaseTesting {

    @Test
    public void testDatabase_usingOracleDriver() throws SQLException {

        //Connection --> Statement --> ResultSet

        //DriverManager is used to get the connection
        String connectionURL = "jdbc:oracle:thin:@35.153.51.63:1521:xe";
        String username = "hr";
        String password = "hr";

        //we created connection using getConnection() method from DriverManager
        //and pass arguments as url, username and password
        Connection connection = DriverManager.getConnection(connectionURL, username, password);

        //we created statement to be able to pass sql query
        Statement statement = connection.createStatement();

        String query = "select * from employees";

        //we stored sql query we executed into Resultset variable
        //so we are able to work with whole result
        ResultSet result = statement.executeQuery(query);

        while(result.next()){

            System.out.println("result = " + result.getString(2));

        }

        connection.close();
        statement.close();
        result.close();


    }
}
