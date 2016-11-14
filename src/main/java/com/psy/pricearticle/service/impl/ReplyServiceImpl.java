package com.psy.pricearticle.service.impl;

import java.util.List;

import com.psy.pricearticle.biz.ReplyBiz;
import com.psy.pricearticle.service.ReplyService;
import com.psy.pricearticle.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService {

	private ReplyBiz replyBiz;
	
	public void setReplyBiz(ReplyBiz replyBiz) {
		this.replyBiz = replyBiz;
	}
	
	@Override
	public boolean addNewReply(ReplyVO reply) {
		return replyBiz.addNewReply(reply);
	}
	
	@Override
	public List<ReplyVO> getAllReply(String articleId) {
		return replyBiz.getAllReply(articleId);
	}
}
