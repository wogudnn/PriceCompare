package com.psy.user.web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.psy.common.constants.Session;
import com.psy.pricearticle.vo.ArticleVO;
import com.psy.user.service.UserService;
import com.psy.user.vo.UserVO;

@Controller
public class UserController {

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/signUp")
	public String viewLogInPage(){
		return "user/signUp";
	}
	
	@RequestMapping("/doSignUp")
	public ModelAndView doSignUpUser(@Valid UserVO user, Errors errors){
		ModelAndView view = new ModelAndView();
		
		
		if(errors.hasErrors()){
			view.setViewName("user/signUp");
		}
		else{
			boolean isSuccess = userService.txSignUp(user);
			view.setViewName("redirect:/signIn");
		}
		
		return view;
	}
	
	@RequestMapping("/signIn")
	public String viewSignIn(){
		return "user/signIn";
	}
	
	@RequestMapping("/doSignIn")
	public ModelAndView doSignInUser(UserVO user, HttpSession session){
		ModelAndView view = new ModelAndView();
		
		
		boolean isSuccess = userService.txSignIn(user,session);
		
		if(isSuccess){
			view.setViewName("redirect:/article/list");
		}
		else{
			view.setViewName("redirect:/signIn");
		}
		
		return view;
	}
	@RequestMapping("/logOut")
	public String doLogOut(HttpSession session){
		session.invalidate();
		return "user/signIn";
	}
	
	
}
