package com.psy.pricearticle.service;

import java.util.List;

import com.psy.pricearticle.vo.ReplyVO;

public interface ReplyService {

	public boolean addNewReply(ReplyVO reply);

	public List<ReplyVO> getAllReply(String articleId);

}
