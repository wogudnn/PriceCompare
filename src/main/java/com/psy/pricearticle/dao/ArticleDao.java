package com.psy.pricearticle.dao;

import java.util.List;

import com.psy.pricearticle.vo.ArticleSearchVO;
import com.psy.pricearticle.vo.ArticleVO;

public interface ArticleDao {

	public List<ArticleVO> getAllArticle(ArticleSearchVO searchVO);

	public int addNewArticle(ArticleVO article);

	public ArticleVO getArticleById(String articleId);

	public int txDeleteArticle(String articleId);

	public int txModifyArticle(ArticleVO article);

	public int getCount(ArticleSearchVO searchVO);


	

}
