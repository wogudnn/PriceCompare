package com.psy.user.dao;

import com.psy.user.vo.UserVO;

public interface UserDao {

	public int txSignUp(UserVO user);

	public UserVO getUserInfo(UserVO user);

	public String getSaltById(String userId);

}
