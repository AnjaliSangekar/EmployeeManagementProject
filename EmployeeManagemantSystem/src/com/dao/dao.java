package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.BO.BOClass;

public class dao {

	
	public static Connection getConnection()
	{
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/code","root","Codenera@123"); 
			
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return con;
		
	}
	
	
	public static int addEmployee(BOClass ob1)
	{
		int status = 0;
		
		try
		{
			Connection con = dao.getConnection();
			
			String sql = "insert into employeeinfo(name, email, phone, dob, salary, role, doj, address) values(?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, ob1.getName());
			ps.setString(2, ob1.getEmail());
			ps.setString(3, ob1.getPhone());
			ps.setString(4, ob1.getDob());
			ps.setString(5, ob1.getSalary());
			ps.setString(6, ob1.getDesignation());
			ps.setString(7, ob1.getDoj());
			ps.setString(8, ob1.getAddress());
			
			
			status = ps.executeUpdate();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return status;
		
	}
	
	
	public static List getAllEmployee()
	{
		
		ArrayList<BOClass> list = new ArrayList<BOClass>();
		
		try 
		{
			Connection con = dao.getConnection();
			
			String sql = "select * from employeeInfo";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				
				BOClass sb = new BOClass();
				
				sb.setId(rs.getInt(1));
				sb.setName(rs.getString(2));
				sb.setEmail(rs.getString(3));
				sb.setPhone(rs.getString(4));
				sb.setDob(rs.getString(5));
				sb.setSalary(rs.getString(6));
				sb.setDesignation(rs.getString(7));
				sb.setDoj(rs.getString(8));
				sb.setAddress(rs.getString(9));
				
				list.add(sb);
				
				
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	public static boolean loginvalid(String email, String phone)
	{
		boolean status = false;
		
		try
		{
			
			Connection con = dao.getConnection();
			
			String sql = "select * from employeeInfo where email=? and phone=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, email);
			ps.setString(2, phone);
			
			ResultSet rs = ps.executeQuery();
			
			status = rs.next();
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
		
	}

	
	// for update data select by id
	
	public static BOClass getEmployeeDataById(int id)
	{
		
		BOClass sb = new BOClass();
		
		try 
		{
			Connection con = dao.getConnection();
			
			String sql = "select * from employeeInfo where id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				
				//BOClass sb = new BOClass();
				
								
				sb.setId(rs.getInt(1));
				sb.setName(rs.getString(2));
				sb.setEmail(rs.getString(3));
				sb.setPhone(rs.getString(4));
				sb.setDob(rs.getString(5));
				sb.setSalary(rs.getString(6));
				sb.setDesignation(rs.getString(7));
				sb.setDoj(rs.getString(8));
				sb.setAddress(rs.getString(9));
				
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return sb;
		
	}
	
	
	public static int getupdateEmployee(BOClass sb)
	{
		int status = 0;
		
		try 
		{
			Connection con = dao.getConnection();
			
			String sql = "update employeeInfo set name=?, email=?, phone=?, dob=?, salary=?, role=?, doj=?, address=? where id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, sb.getName());
			ps.setString(2, sb.getEmail());
			ps.setString(3, sb.getPhone());
			ps.setString(4, sb.getDob());
			ps.setString(5, sb.getSalary());
			ps.setString(6, sb.getDesignation());
			ps.setString(7, sb.getDoj());
			ps.setString(8, sb.getAddress());
			ps.setInt(9, sb.getId());
			
			status = ps.executeUpdate();
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return status;
		
	}
	
	
	public static int getdeleteEmployee(int id)
	{
		int status = 0;
		
		try 
		{
			Connection con = dao.getConnection();
			
			String sql = "delete from employeeInfo where id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			status = ps.executeUpdate();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		return status;
			
	}
	
}
