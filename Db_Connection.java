package com_pojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db_Connection {

	public static final String dBurl="jdbc:mysql://localhost:3306/learnersacademy";
	public static final String username="root";
	public static final String psw="Hello@8155";
	public static Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(dBurl,username,psw);
		return con;
	}
	
}
