package com.revature.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(asyncSupported = true, urlPatterns = { "/*" })
public class CorsFilter implements Filter {

    public CorsFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		System.out.println("Incoming " + httpRequest.getMethod() + " request at " + httpRequest.getRequestURI());
		
		
		httpResponse.addHeader("Access-Control-Allow-Origin", "*");
		httpResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, HEAD, OPTIONS");
		httpResponse.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
		httpResponse.addHeader("Access-Control-Allow-Credentials", "true");
		
		if (httpRequest.getMethod().equals("OPTIONS"))
			httpResponse.setStatus(202);
		
		// What filters on the request to the Servlet
		chain.doFilter(httpRequest, httpResponse);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}