package com.psy.pricearticle.vo;

import java.util.List;

import com.psy.common.util.pager.Pager;


public class ArticleListVO {

	private List<ArticleVO> articleList;
	
	private Pager pager;
	
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public List<ArticleVO> getArticleList() {
		return articleList;
	}
	public void setArticleList(List<ArticleVO> articleList) {
		this.articleList = articleList;
	}
	
	
}
