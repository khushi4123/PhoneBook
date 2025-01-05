package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Contact;

public class contactdao {
	private static Connection conn;

	public static Connection getConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:4306/phonebook","root",""); 

		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return conn;
	}
	
	public int saveContact(Contact cont)
	{
		Connection conn = getConn();
		int i = 0;
		
		try {
			PreparedStatement ps = conn.prepareStatement("insert into cantact (cont_name,cont_email,cont_phone,cont_about,user_id) values (?,?,?,?,?)");
			ps.setString(1, cont.getContname());
			ps.setString(2, cont.getContemail());
			ps.setString(3, cont.getContphone());
			ps.setString(4, cont.getAbout());
			ps.setInt(5, cont.getUserId());
			
			  i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	
	public List<Contact> getAllContact(int uid)
	{
		Connection conn = getConn();
		List<Contact> list = new ArrayList<Contact>();
		Contact cont = null;
		try {
			String query = "select * from cantact where user_id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, uid);
			
			ResultSet result = ps.executeQuery();
			
			while(result.next())
			{
				cont = new Contact();
				cont.setContid(result.getInt(1));
				cont.setContname(result.getString(2));
				cont.setContemail(result.getString(3));
				cont.setContphone(result.getString(4));
				cont.setAbout(result.getString(5));
				
				list.add(cont);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	public Contact getContactById(int cid)
	{	
		Connection conn = getConn();
		Contact cont = new Contact();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from cantact where cant_id =? ");
			ps.setInt(1, cid);
			
			ResultSet set = ps.executeQuery();
			
			while(set.next())
			{
				cont.setContid(set.getInt(1));;
				cont.setContname(set.getString(2));
				cont.setContemail(set.getString(3));
				cont.setContphone(set.getString(4));
				cont.setAbout(set.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cont;
		
	}
	
	
	
	public int updateContact(Contact cont)
	{
		Connection conn = getConn();
		int  i = 0;
		try {
			String sql = "update cantact set cont_name=?,cont_email=?,cont_phone=?,cont_about=? where  cant_id= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cont.getContname());
			ps.setString(2, cont.getContemail());
			ps.setString(3, cont.getContphone());
			ps.setString(4, cont.getAbout());
			ps.setInt(5, cont.getContid());
			
			
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
		
	}
	
	
	public int deleteContact(int id)
	{
		Connection conn = getConn();
		int i = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("delete from cantact where cant_id=?");
			ps.setInt(1, id);
			
			 i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return i;
		
	}
}
