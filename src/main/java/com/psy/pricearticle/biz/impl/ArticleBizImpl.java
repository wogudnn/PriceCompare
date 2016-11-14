package com.psy.pricearticle.biz.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.psy.common.util.pager.Pager;
import com.psy.common.util.pager.PagerFactory;
import com.psy.pricearticle.biz.ArticleBiz;
import com.psy.pricearticle.dao.ArticleDao;
import com.psy.pricearticle.vo.ArticleListVO;
import com.psy.pricearticle.vo.ArticleSearchVO;
import com.psy.pricearticle.vo.ArticleVO;

public class ArticleBizImpl implements ArticleBiz {

	private ArticleDao articleDao;
	
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
	@Override
	public ArticleListVO getAllArticle(ArticleSearchVO searchVO) {
		
		int totalCount = articleDao.getCount(searchVO);
		Pager pager = PagerFactory.getPager(true);
		pager.setPageNumber(searchVO.getPageNO());
		pager.setTotalArticleCount(totalCount);
		searchVO.setEndNumber(pager.getEndArticleNumber());
		searchVO.setStartNumber(pager.getStartArticleNumber());
		
		ArticleListVO articleList = new ArticleListVO();
		List<ArticleVO> articles = articleDao.getAllArticle(searchVO);
		articleList.setArticleList(articles);
		articleList.setPager(pager);
		
		return articleList;
	}
	
	@Override
	public boolean addNewArticle(ArticleVO article) {
		return articleDao.addNewArticle(article)>0;
	}
	
	@Override
	public ArticleVO getArticleById(String articleId) {
		return articleDao.getArticleById(articleId);
	}
	
	@Override
	public boolean txDeleteArticle(String articleId) {
		return articleDao.txDeleteArticle(articleId)>0;
	}
	
	@Override
	public ArticleVO getArticleForModify(String articleId) {
		return articleDao.getArticleById(articleId);
	}
	
	@Override
	public boolean txModifyArticle(ArticleVO article) {
		return articleDao.txModifyArticle(article)>0;
	}
	
}
