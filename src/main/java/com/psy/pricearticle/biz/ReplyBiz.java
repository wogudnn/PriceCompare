package com.psy.pricearticle.biz;

import java.util.List;

import com.psy.pricearticle.vo.ReplyVO;

public interface ReplyBiz {

	public boolean addNewReply(ReplyVO reply);

	public List<ReplyVO> getAllReply(String articleId);

	
}
