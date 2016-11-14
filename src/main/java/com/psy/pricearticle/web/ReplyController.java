package com.psy.pricearticle.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.psy.pricearticle.service.ReplyService;
import com.psy.pricearticle.vo.ReplyVO;

@Controller
public class ReplyController {

	private ReplyService replyService;
	
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	
	@RequestMapping("/article/addReply")
	@ResponseBody
	public List<ReplyVO> addNewReply(ReplyVO reply){
		boolean isSuccess = replyService.addNewReply(reply);
		return getAllReplyAction(reply.getArticleId());
	}
	@RequestMapping("/article/addReply/{articleId}")
	@ResponseBody
	public List<ReplyVO> getAllReplyAction(@PathVariable String articleId){
		List<ReplyVO> replies = replyService.getAllReply(articleId);
		return replies;
	}
	
}
