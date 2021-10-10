package com.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.dao.DBAccess;

public class AddMember implements Servlet{
	
	ServletConfig config = null;
	ServletContext sc = null;
	DBAccess dbaccess = null;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		this.config = null;
		this.sc = null;
		System.out.println("Destryoing the servlet object for add member");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.config;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return this.config.getInitParameter("info");
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		this.config = arg0;
		
		this.sc = this.config.getServletContext();
		
		//Initialize the db object
		this.dbaccess = new DBAccess();
		try {
			dbaccess.makeConnection(this.sc.getInitParameter("mysqldrivername"),this.sc.getInitParameter("dbUrl"),this.sc.getInitParameter("username"),this.sc.getInitParameter("password"));
		}
		catch(SQLException e) {
			System.out.println("SQL error occured");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Class not found exception occured");
		}
		catch(Exception e) {
			System.out.println("Exception occured");
		}
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = arg1.getWriter();
		
		HttpServletResponse resp = (HttpServletResponse) arg1;
		
		Member mem = new Member(arg0.getParameter("name"),Integer.parseInt(arg0.getParameter("age")),getDateFromStr(arg0.getParameter("doj")),getDateFromStr(arg0.getParameter("doe")),Double.parseDouble(arg0.getParameter("height")),Double.parseDouble(arg0.getParameter("weight")));
		try{
			this.dbaccess.insertValue(mem);
			resp.sendRedirect("viewmembers");
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			pw.write("SQL exception occured");
		}
		catch(Exception e) {
			pw.write("Exception occured");
		}
		
	}
	
	public static Date getDateFromStr(String str) {
		Date date = Date.valueOf(str);
		return date;
	}
}
