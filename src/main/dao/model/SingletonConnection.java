package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.time.Clock;

public class SingletonConnection {
    private String url="jdbc:mysql://localhost:3306/jee_db";
    private String produit="root";
    private String password="";

    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,produit,password);
            System.out.println("Success");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error");
            throw new RuntimeException(e);
        }
       return connection;
    }
}
