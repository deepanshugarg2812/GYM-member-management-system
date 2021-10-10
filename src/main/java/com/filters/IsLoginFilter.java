package com.filters;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.DBAccess;

public class IsLoginFilter implements Filter{
	FilterConfig fs = null;
	DBAccess dbaccess = null;
	ServletContext sc = null;
	
	@Override
	public void init(FilterConfig fs) throws ServletException{
		this.fs = fs;
		this.sc = this.fs.getServletContext();
		
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
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		
		Cookie[] cookies = req.getCookies();
		if(cookies.length > 0) {
			for(int i=0;i<cookies.length;i++) {
				if(cookies[i].getName().equals("user") && cookies[i].getValue().equals("valid")) {
					arg2.doFilter(arg0, arg1);
					return;
				}
			}
			resp.sendRedirect("index.jsp");
		}
		else {
			resp.sendRedirect("index.jsp");
		}
	}
	
	public void destroy() {
		System.out.println("Filter object destroyed");
	}

}
