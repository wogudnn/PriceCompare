package com.psy.user.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.psy.user.dao.UserDao;
import com.psy.user.vo.UserVO;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	
	@Override
	public int txSignUp(UserVO user) {
		return getSqlSession().insert("userDao.txSignUp", user);
	}
	
	@Override
	public String getSaltById(String userId) {
		return getSqlSession().selectOne("userDao.getSaltById",userId);
	}
	
	@Override
	public UserVO getUserInfo(UserVO user) {
		return getSqlSession().selectOne("userDao.getUserInfo",user);
	}
	
}
