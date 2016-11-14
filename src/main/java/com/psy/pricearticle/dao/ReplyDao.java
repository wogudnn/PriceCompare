package com.psy.pricearticle.dao;

import java.util.List;

import com.psy.pricearticle.vo.ReplyVO;

public interface ReplyDao {

	public int addNewReply(ReplyVO reply);

	public List<ReplyVO> getAllReply(String articleId);

}
