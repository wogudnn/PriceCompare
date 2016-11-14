package com.psy.user.biz;

import com.psy.user.vo.UserVO;

public interface UserBiz {

	public boolean txSignUp(UserVO user);

	public UserVO getUserInfo(UserVO user);

}
