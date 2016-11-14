package com.psy.pricearticle.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.psy.pricearticle.dao.ReplyDao;
import com.psy.pricearticle.vo.ReplyVO;

public class ReplyDaoImpl extends SqlSessionDaoSupport implements ReplyDao {

	
	@Override
	public int addNewReply(ReplyVO reply) {
		return getSqlSession().insert("replyDao.addNewReply", reply);
	}
	
	@Override
	public List<ReplyVO> getAllReply(String articleId) {
		return getSqlSession().selectList("replyDao.getAllReply", articleId);
	}
}
