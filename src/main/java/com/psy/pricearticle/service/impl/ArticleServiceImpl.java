package com.psy.pricearticle.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.psy.common.constants.Session;
import com.psy.pricearticle.biz.ArticleBiz;
import com.psy.pricearticle.service.ArticleService;
import com.psy.pricearticle.vo.ArticleListVO;
import com.psy.pricearticle.vo.ArticleSearchVO;
import com.psy.pricearticle.vo.ArticleVO;
import com.psy.user.vo.UserVO;

public class ArticleServiceImpl implements ArticleService {

	private ArticleBiz articleBiz;
	
	public void setArticleBiz(ArticleBiz articleBiz) {
		this.articleBiz = articleBiz;
	}
	
	@Override
	public ArticleListVO getAllArticle(ArticleSearchVO searchVO) {
		return articleBiz.getAllArticle(searchVO);
	}
	
	@Override
	public boolean addNewArticle(ArticleVO article, HttpSession session) {
		
		MultipartFile uploadFile = article.getFile();
		if(!uploadFile.isEmpty()){
			File dir = new File("d:"+File.separator+"uploadFile3");
			if(!dir.exists()){
				dir.mkdirs();
			}
			String uploadPath = dir.getAbsolutePath();
			String encryptFileName = UUID.randomUUID().toString();
			String realFileName = uploadFile.getOriginalFilename();
			
			File file = new File(uploadPath + File.separator + encryptFileName);
			
			try {
				uploadFile.transferTo(file);
			} catch (IllegalStateException e) {
				throw new RuntimeException(e.getMessage(), e); 
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
			article.setDisplayFileName(realFileName);
			article.setRealFileName(encryptFileName);
		}
		UserVO user = (UserVO) session.getAttribute(Session.USER);
		String userId = user.getUserId();
		article.setUserId(userId);
		
		String content = article.getContent();
		content.replaceAll("<br/>", "\n");
		article.setContent(content);
		
		return articleBiz.addNewArticle(article);
	}
	
	@Override
	public ArticleVO getArticleById(String articleId) {
		return articleBiz.getArticleById(articleId);
	}
	
	@Override
	public boolean txDeleteArticle(String articleId, HttpSession session) {
		UserVO user = (UserVO) session.getAttribute(Session.USER);
		String userId = user.getUserId();
		ArticleVO article = articleBiz.getArticleById(articleId);
		if(userId.equals(article.getUserId())){
			return articleBiz.txDeleteArticle(articleId);
		}
		return false;
	}
	
	@Override
	public ArticleVO getArticleForModify(String articleId) {
		return articleBiz.getArticleForModify(articleId);
	}
	
	@Override
	public boolean txModifyArticle(ArticleVO article, HttpSession session) {
		
		UserVO user = (UserVO) session.getAttribute(Session.USER);
		String userId = user.getUserId();
		ArticleVO articleVO = articleBiz.getArticleById(article.getArticleId());
		if(userId.equals(articleVO.getUserId())){
			MultipartFile uploadFile = article.getFile();
			if(!uploadFile.isEmpty()){
				File dir = new File("e:"+File.separator+"uploadFile");
				if(!dir.exists()){
					dir.mkdirs();
				}
				String uploadPath = dir.getAbsolutePath();
				String encryptFileName = UUID.randomUUID().toString();
				String realFileName = uploadFile.getOriginalFilename();
				
				File file = new File(uploadPath + File.separator + encryptFileName);
				
				try {
					uploadFile.transferTo(file);
				} catch (IllegalStateException e) {
					throw new RuntimeException(e.getMessage(), e); 
				} catch (IOException e) {
					throw new RuntimeException(e.getMessage(), e);
				}
				article.setDisplayFileName(realFileName);
				article.setRealFileName(encryptFileName);
			}
			
			String content = article.getContent();
			content.replaceAll("\n", "<br/>")
			.replaceAll("\r","");
			article.setContent(content);
			return articleBiz.txModifyArticle(article);
		}
		return false;
	}
	
	@Override
	public ArticleVO getFileName(String articleId) {
		return articleBiz.getArticleById(articleId);
	}
	
}
