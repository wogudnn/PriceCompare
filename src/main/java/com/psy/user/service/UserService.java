package com.psy.user.service;

import javax.servlet.http.HttpSession;

import com.psy.pricearticle.vo.ArticleVO;
import com.psy.user.vo.UserVO;

public interface UserService {

	public boolean txSignUp(UserVO user);

	public boolean txSignIn(UserVO user, HttpSession session);

	public ArticleVO getArticleById(String userId);

}
