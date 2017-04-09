package com.niit.ecommerce.exception;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.niit.ecommerce.controller.PageController;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	private static Logger log = Logger.getLogger(PageController.class);
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException()
	{
		
		log.debug("beginning of handlerNoHandlerFoundException method");
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "The page is not constructed!");
		
		mv.addObject("errorDescription", "The page you are looking for is not available!");
		
		mv.addObject("title","404 Error Page");
		
		log.debug("end of handlerNoHandlerFoundException method");
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException()
	{
		
		log.debug("beginning of handlerProductNotFoundException method");
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Product not available!");
		
		mv.addObject("errorDescription", "The product you are looking for is not available!");
		
		mv.addObject("title","Product unavailable");
		
		log.debug("end of handlerProductNotFoundException method");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex)
	{
		
		log.debug("beginning of handlerException method");
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Contact your administrator!");
		
		mv.addObject("errorDescription", ex.toString());
		
		mv.addObject("title","Error!");
		
		log.debug("end of handlerException method");
		return mv;
	}
	
}
