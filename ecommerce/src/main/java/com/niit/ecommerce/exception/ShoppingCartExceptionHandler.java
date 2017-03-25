package com.niit.ecommerce.exception;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.hibernate.hql.internal.ast.QuerySyntaxException;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.niit.ecommerce.controller.PageController;

@ControllerAdvice
public class ShoppingCartExceptionHandler {
	
	private static Logger log = Logger.getLogger(PageController.class);
	
	@ExceptionHandler(SQLException.class)
	public ModelAndView handleSQLException(Exception e) {
		
		log.debug("beginnig of sql excpn");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("errorMessage","It seems one of the table or fields do not exist"+e.getMessage());
		
		
		log.debug("end of sql excpn");
		return mv;
	}
	
	@ExceptionHandler(CannotCreateTransactionException.class)
	public ModelAndView dbservernotstarted(Exception e) {
		
		log.debug("beginnig of dbservernotstarted excpn");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("errorMessage","It seems database server not started: "+e.getMessage());
		
		
		log.debug("end of dbservernotstarted excpn");
		return mv;
	}
	
	@ExceptionHandler(QuerySyntaxException.class)
	public ModelAndView handleQuerySyntaxExcpn(Exception e) {
		
		log.debug("beginnig of handleQuerySyntaxExcpn excpn");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("errorMessage","It seems one of the queries is improper: "+e.getMessage());
		
		
		log.debug("end of handleQuerySyntaxExcpn excpn");
		return mv;
	}

	@ExceptionHandler(IOException.class)
	public ModelAndView handleIOException(Exception e) {
		
		log.debug("beginnig of handleIOException excpn");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("errorMessage","It seems there is an IOException: "+e.getMessage());
		
		
		log.debug("end of handleIOException excpn");
		return mv;
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNoHandlerExcpn(HttpServletRequest request, Exception e)
	{
		log.debug("beginnig of handleNoHandlerExcpn excpn");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("errorMessage","No handler found: "+e.getMessage());
		
		
		log.debug("end of handleNoHandlerExcpn excpn");
		return mv;
		
	}
	
}
