package com.psy.pricearticle.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.psy.pricearticle.dao.ArticleDao;
import com.psy.pricearticle.vo.ArticleSearchVO;
import com.psy.pricearticle.vo.ArticleVO;

public class ArticleDaoImpl extends SqlSessionDaoSupport implements ArticleDao {

	@Override
	public List<ArticleVO> getAllArticle(ArticleSearchVO searchVO) {
		return getSqlSession().selectList("articleDao.getAllArticle",searchVO);
	}
	
	@Override
	public int addNewArticle(ArticleVO article) {
		return getSqlSession().insert("articleDao.addNewArticle",article);
	}
	
	@Override
	public ArticleVO getArticleById(String articleId) {
		return getSqlSession().selectOne("articleDao.getArticleById", articleId);
	}
	
	@Override
	public int txDeleteArticle(String articleId) {
		return getSqlSession().delete("articleDao.txDeleteArticle",articleId);
	}
	
	@Override
	public int txModifyArticle(ArticleVO article) {
		return getSqlSession().update("articleDao.txModifyArticle", article);
	}
	
	@Override
	public int getCount(ArticleSearchVO searchVO) {
		return getSqlSession().selectOne("articleDao.getCount", searchVO);
	}
}
