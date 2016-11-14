package com.psy.pricearticle.service;

import javax.servlet.http.HttpSession;

import com.psy.pricearticle.vo.ArticleListVO;
import com.psy.pricearticle.vo.ArticleSearchVO;
import com.psy.pricearticle.vo.ArticleVO;

public interface ArticleService {

	public ArticleListVO getAllArticle(ArticleSearchVO searchVO);

	public boolean addNewArticle(ArticleVO article, HttpSession session);

	public ArticleVO getArticleById(String articleId);

	public boolean txDeleteArticle(String articleId, HttpSession session);

	public ArticleVO getArticleForModify(String articleId);

	public boolean txModifyArticle(ArticleVO artcie, HttpSession session);

	public ArticleVO getFileName(String articleId);


	
}
