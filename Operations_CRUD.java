package com_pojo;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Operations_CRUD {

	public int insert_teachers(Get_Set_Data g) throws ClassNotFoundException, SQLException
	{
		try
		{
		Connection con=Db_Connection.getConn();
		String sql="insert into teachers values(?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, g.getTid());
		ps.setString(2,g.getTname());
		return ps.executeUpdate();
		}
		catch(Exception exp)
		{
			Exception e=exp;
			System.out.println(e);
			return 0;
		}
	}
	
	public int insert_subjects(Get_Set_Data g) throws ClassNotFoundException, SQLException
	{
		try
		{
		Connection con=Db_Connection.getConn();
		String sql="insert into subjects values(?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,g.getSubject());
		return ps.executeUpdate();
		}
		catch(Exception exp)
		{
			String e=exp.getMessage().toString();
			String v1="Duplicate entry '"+g.getSubject()+"' for key 'subjects.PRIMARY'";
			if(e.equals(v1))
			{
			System.out.println(g.getSubject()+" is already in the database.");
			return 21;
			}
			else {
				System.out.println(e);
			return 0;
			}
		}
	}
	
	public int insert_classes(Get_Set_Data g) throws ClassNotFoundException, SQLException
	{
		try
		{
		Connection con=Db_Connection.getConn();
		String sql="insert into classes values(?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,g.getCname());
		return ps.executeUpdate();
		}
		catch(Exception exp)
		{
			String e=exp.getMessage().toString();
			String v1="Duplicate entry '"+g.getCname()+"' for key 'subjects.PRIMARY'";
			if(e.equals(v1))
			{
			System.out.println(g.getCname()+" is already in the database.");
			return 21;
			}
			else {
				System.out.println(e);
			return 0;
			}
		}
	}
	
	public int insert_classSubject(Get_Set_Data g) throws ClassNotFoundException, SQLException
	{
		try
		{
		Connection con=Db_Connection.getConn();
		String sql="insert into class_subject values('"+g.getCname()+"','"+g.getS1()+"','"+g.getS2()+"','"+g.getS3()+"','"+g.getS4()+"','"+g.getS5()+"')";
		PreparedStatement ps=con.prepareStatement(sql);
		System.out.println(sql);
		return ps.executeUpdate();
		}
		catch(Exception exp)
		{
			String e=exp.getMessage().toString();
			String v1="Duplicate entry '"+g.getCname()+"' for key 'subjects.PRIMARY'";
			if(e.equals(v1))
			{
			System.out.println(g.getCname()+" is already in the database.");
			return 21;
			}
			else {
				System.out.println(e);
			return 0;
			}
		}
	}
	
	
	public int login(Get_Set_Data g)
	{
		try {
		if(g.getUsername().equals("Admin") && g.getPassword().equals("admin"))
		return 1;
		else
			return 0;
		}
		catch(Exception exp)
		{
			Exception e=exp;
			System.out.println(e);
			return 0;
		}
		
	}
		
	public List<Get_Set_Data> displayC() throws ClassNotFoundException, SQLException{
		try {
			Connection con=Db_Connection.getConn();
		List<Get_Set_Data> list=new ArrayList<Get_Set_Data>();
		String sql="select * from classes";
		PreparedStatement ps1=con.prepareStatement(sql);
		ResultSet rs=ps1.executeQuery();
		while(rs.next()) {
			Get_Set_Data pojo=new Get_Set_Data();
			pojo.setCid(rs.getInt(1));
			pojo.setCname(rs.getString(2));
			list.add(pojo);
		}
		return list;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
//	public List<Get_Set_Data> display_subjects() throws ClassNotFoundException, SQLException
//	{
//		Connection con=Db_Connection.getConn();
//		List<Get_Set_Data> list=new ArrayList<Get_Set_Data>();
//		
//		
//		return null;
//	}
}
