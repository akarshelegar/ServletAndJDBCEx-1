package com.techpalle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationServices {
	
	private static Connection cn = null;
	private static PreparedStatement ps = null;
	
	private static final String dburl = "jdbc:mysql://localhost:3306/j2ee";
	private static final String dbusername = "root";
	private static final String dbpassword = "7259";
	
	public static int doRegister(String name, String email, String qual, String pwd)
	{
		int row = 0;
		try {
			//load driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//establish the connection
			cn = DriverManager.getConnection(dburl, dbusername, dbpassword);
			
			//prepare statement
			ps = cn.prepareStatement("insert into student(name, email, qualification, password) values(?, ?, ?, ?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, qual);
			ps.setString(4, pwd);
			
			//execute query
		
			row = ps.executeUpdate();
			
		}
		catch(ClassNotFoundException a)
		{
			a.printStackTrace();
		}
		catch(SQLException b)
		{
			b.printStackTrace();
		}
		
		finally {
			if(ps!=null)
			{
			try {
				ps.close();
			} catch (SQLException e1) {
	
				e1.printStackTrace();
			}
			}
			if(cn!=null)
			{
				try {
					ps.close();
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
			}
			
		}
		return row;

	}


}
