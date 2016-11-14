package com.psy.pricearticle.vo;

import com.psy.user.vo.UserVO;

public class ReplyVO {
	
	private String replyId;
	private String articleId;
	private String userId;
	private String replyContent;
	private String createdDate;
	private String parentReplyId;
	private int level;
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	private UserVO user;
	
	private ArticleVO article;
	
	private ReplyVO parentReply;

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getParentReplyId() {
		return parentReplyId;
	}

	public void setParentReplyId(String parentReplyId) {
		this.parentReplyId = parentReplyId;
	}

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public ArticleVO getArticle() {
		return article;
	}

	public void setArticle(ArticleVO article) {
		this.article = article;
	}

	public ReplyVO getParentReply() {
		return parentReply;
	}

	public void setParentReply(ReplyVO parentReply) {
		this.parentReply = parentReply;
	}
	
	
	
}
