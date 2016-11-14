package com.psy.pricearticle.biz;

import javax.servlet.http.HttpSession;

import com.psy.pricearticle.vo.ArticleListVO;
import com.psy.pricearticle.vo.ArticleSearchVO;
import com.psy.pricearticle.vo.ArticleVO;

public interface ArticleBiz {

	public ArticleListVO getAllArticle(ArticleSearchVO searchVO);

	public boolean addNewArticle(ArticleVO article);

	public ArticleVO getArticleById(String articleId);

	public boolean txDeleteArticle(String articleId);

	public ArticleVO getArticleForModify(String articleId);

	public boolean txModifyArticle(ArticleVO article);


	
}
