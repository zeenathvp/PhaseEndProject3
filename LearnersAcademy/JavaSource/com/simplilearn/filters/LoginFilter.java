package com.simplilearn.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginFilter implements Filter {


    public LoginFilter() {
    }


	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		HttpSession session = req.getSession(false);
		System.out.println("uri issssssssssssssssssssssssssssssss"+uri);
		
		if(uri.endsWith("Login.jsp") || uri.endsWith("logoutServlet")){
			chain.doFilter(request, response);
		}else if(session == null){
			res.sendRedirect("Login.jsp");
		}else{
			System.out.println("iiiii aaaaaaaaaaaaaaaam");
			chain.doFilter(request, response);
		}
		
		
//		if(session== null  && !(uri.endsWith("Login.jsp") || uri.endsWith("logoutServlet"))){
//			res.sendRedirect("Login.jsp");
//		}else{
//			chain.doFilter(request, response);
//		}
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
