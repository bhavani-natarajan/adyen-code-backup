package com.shopping.cart.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class CartFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		final HttpServletRequest inRequest = (HttpServletRequest) request;
		final HttpServletResponse inResponse = (HttpServletResponse) response;
		inResponse.setHeader("Access-Control-Allow-Origin", "*");
		inResponse.setHeader("Access-Control-Allow-Headers", "*");
		chain.doFilter(inRequest, inResponse);
		
	}
	

}
