package com.psy.user.biz.impl;

import com.psy.common.util.SHA256Util;
import com.psy.user.biz.UserBiz;
import com.psy.user.dao.UserDao;
import com.psy.user.vo.UserVO;

public class UserBizImpl implements UserBiz {

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	@Override
	public boolean txSignUp(UserVO user) {
		
		String salt = SHA256Util.generateSalt();
		String password = user.getHashedPassword();
		password = SHA256Util.getEncrypt(password, salt);
		user.setHashedPassword(password);
		user.setSalt(salt);
		
		return userDao.txSignUp(user)>0;
	}
	
	@Override
	public UserVO getUserInfo(UserVO user) {
		String salt = userDao.getSaltById(user.getUserId());
		String password = user.getHashedPassword();
		password = SHA256Util.getEncrypt(password, salt);
		user.setHashedPassword(password);
		user.setSalt(salt);
		
		return userDao.getUserInfo(user);
	}
	
}
