package com.psy.user.service.impl;

import javax.servlet.http.HttpSession;

import com.psy.common.constants.Session;
import com.psy.pricearticle.vo.ArticleVO;
import com.psy.user.biz.UserBiz;
import com.psy.user.service.UserService;
import com.psy.user.vo.UserVO;

public class UserServiceImpl implements UserService {

	private UserBiz userBiz;
	
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	
	@Override
	public boolean txSignUp(UserVO user) {
		return userBiz.txSignUp(user);
	}
	
	@Override
	public boolean txSignIn(UserVO user, HttpSession session) {
		UserVO userVO = userBiz.getUserInfo(user);
		if(userVO != null){
			session.setAttribute(Session.USER, userVO);
			return true;
		}
		
		return false;
	}
	
	@Override
	public ArticleVO getArticleById(String userId) {
		return null;
	}
	
}
