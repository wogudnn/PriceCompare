package com.psy.common.exception.handler;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.psy")
public class RuntimeExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ModelAndView viewRuntimeExceptionPage(RuntimeException e){
		ModelAndView view = new ModelAndView();
		view.setViewName("error/runtime");
		if(e instanceof NullPointerException){
			view.addObject("message", "필수입력값이 없습니다.");
		}
		else if(e instanceof DataAccessException){
			view.addObject("message", "입력값에 문제가 있습니다.");
		}
		else if(e instanceof NumberFormatException){
			view.addObject("message", "숫자입력값에 문제가 있습니다.");
		}
		else{
			view.addObject("message", e.getMessage());
		}
		
		return view;
	}
	
}
