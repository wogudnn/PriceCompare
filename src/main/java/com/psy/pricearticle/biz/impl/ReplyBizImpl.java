package com.psy.pricearticle.biz.impl;

import java.util.List;

import com.psy.pricearticle.biz.ReplyBiz;
import com.psy.pricearticle.dao.ReplyDao;
import com.psy.pricearticle.vo.ReplyVO;

public class ReplyBizImpl implements ReplyBiz {

	private ReplyDao replyDao;
	
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}
	
	@Override
	public boolean addNewReply(ReplyVO reply) {
		return replyDao.addNewReply(reply)>0;
	}
	
	@Override
	public List<ReplyVO> getAllReply(String articleId) {
		return replyDao.getAllReply(articleId);
	}
	
}
