package com.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.dao.DBAccess;

public class ViewMembersAll implements Servlet{

	ServletConfig config = null;
	ServletContext sc = null;
	DBAccess dbaccess = null;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		this.config = null;
		this.sc = null;
		System.out.println("Destryoing the servlet object for view members");
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
		
		HttpServletRequest hrs = (HttpServletRequest) arg0;
		
		try {
			List<Member> mem = this.dbaccess.viewAllMembers();
			if(mem==null) {
				pw.write("No member with this ID");
			}
			else {
				arg0.setAttribute("members",mem);
				RequestDispatcher rd = hrs.getRequestDispatcher("viewmembers.jsp");
				rd.forward(arg0, arg1);
			}
		}
		catch(SQLException e) {
			pw.write("SQL error encountered");
		}
		catch(Exception e) {
			System.out.println(e);
			pw.write("Exception occured");
		}
	}
	
	
	
}
