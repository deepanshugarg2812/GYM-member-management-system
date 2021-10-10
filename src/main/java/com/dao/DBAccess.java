package com.dao;

import java.sql.*;
import com.main.Member;
import java.util.*;

public class DBAccess {
	
	Connection conn = null;
	
	//method to load driver and make the connection object
	public void makeConnection(String drivername,String dbUrl,String username,String password) throws SQLException, ClassNotFoundException{
		if(this.conn!=null) {
			return;
		}
		
		//Load the driver dynamically
		Class.forName(drivername);
		this.conn = DriverManager.getConnection(dbUrl,username,password);
		System.out.println(this.conn.isValid(0));
	}
	
	public void insertValue(Member mem) throws SQLException {
		String add_member = "INSERT INTO members (name,age,height,weight,doj,doe) VALUES (?,?,?,?,?,?);";
		
		PreparedStatement ps = this.conn.prepareStatement(add_member);
		ps.setString(1,mem.getName());
		ps.setInt(2, mem.getAge());
		ps.setDouble(3, mem.getHeight());
		ps.setDouble(4, mem.getWeight());
		ps.setDate(5, mem.getDoj());
		ps.setDate(6, mem.getDoe());
		
		ps.executeUpdate();
	}
	
	public Member getMember(int id) throws SQLException {
		String get_member = "SELECT * from members where id = ?";
		
		PreparedStatement ps = this.conn.prepareStatement(get_member);
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			return new Member(rs.getString(2),rs.getInt(3),rs.getDate(6),rs.getDate(7),rs.getDouble(4),rs.getDouble(5));
		}
		return null;
	}
	
	public List<Member> viewAllMembers() throws SQLException{
		List<Member> list = new ArrayList<>();
		
		String get_members = "SELECT * from members;";
		Statement ps = this.conn.createStatement();
		ResultSet rs = ps.executeQuery(get_members);
		while(rs.next()) {
			list.add(new Member(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDate(6),rs.getDate(7),rs.getDouble(4),rs.getDouble(5)));
		}
		return list;
	}
	
	public void deleteMember(int id) throws SQLException {
		String get_member = "DELETE from members where id = ?";
		
		PreparedStatement ps = this.conn.prepareStatement(get_member);
		
		ps.setInt(1, id);
		
		ps.executeUpdate();
	}
	
	public boolean isValidUser(String username,String password) throws SQLException {
		String valid_user = "SELECT * FROM auth where username=? and password=?";
		
		PreparedStatement ps = this.conn.prepareStatement(valid_user);
		ps.setString(1,username);
		ps.setString(2, password);
		
		boolean isValid = ps.executeQuery().next();
		return isValid;
	}
}
