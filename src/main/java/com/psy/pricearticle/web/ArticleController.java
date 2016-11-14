package com.psy.pricearticle.web;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.psy.common.util.DownloadUtil;
import com.psy.common.util.pager.ClassicPageExplorer;
import com.psy.common.util.pager.PageExplorer;
import com.psy.pricearticle.service.ArticleService;
import com.psy.pricearticle.vo.ArticleListVO;
import com.psy.pricearticle.vo.ArticleSearchVO;
import com.psy.pricearticle.vo.ArticleVO;

@Controller
public class ArticleController {

	private ArticleService articleService;
	
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	@RequestMapping("/article/list")
	public ModelAndView viewListPage(ArticleSearchVO searchVO){
		ModelAndView view = new ModelAndView();
		
		ArticleListVO articleList = articleService.getAllArticle(searchVO);
		PageExplorer pageExplorer = new ClassicPageExplorer(articleList.getPager());
		String pager = pageExplorer.getPagingList("pageNO", "[@]", "<<", ">>", "searchForm");
		view.setViewName("article/list");
		view.addObject("articleList", articleList);
		view.addObject("paging", pager);
		view.addObject("searchVO", searchVO);
		
		return view;
	}
	
	@RequestMapping("/article/write")
	public String viewWritePage(){
		return "article/write";
	}
	
	@RequestMapping("/article/doWrite")
	public ModelAndView doWriteAction(@Valid ArticleVO article,Errors error, HttpSession session){
		ModelAndView view = new ModelAndView();
		
		if(error.hasErrors()){
			view.setViewName("article/write");
		}
		else{
			boolean isSuccess = articleService.addNewArticle(article, session);
			view.setViewName("redirect:/article/list");
		}
		return view;
	}
	
	@RequestMapping("/article/detail/{articleId}")
	public ModelAndView viewDetailArticlePage(@PathVariable String articleId){
		ModelAndView view = new ModelAndView();
		
		ArticleVO article = articleService.getArticleById(articleId);
		view.setViewName("article/detail");
		view.addObject("article", article);
		
		return view;
	}
	
	@RequestMapping("/article/delete/{articleId}")
	public ModelAndView deleteArticle(@PathVariable String articleId, HttpSession session){
		ModelAndView view = new ModelAndView();
		
		boolean isSuccess = articleService.txDeleteArticle(articleId, session);
		view.setViewName("redirect:/article/list");
		return view;
	}
	
	@RequestMapping("/article/modify/{articleId}")
	public ModelAndView viewModifyPage(@PathVariable String articleId){
		ModelAndView view = new ModelAndView();
		
		ArticleVO article = articleService.getArticleForModify(articleId);
		view.setViewName("article/modify");
		view.addObject("article", article);
		
		return view;
	}
	
	@RequestMapping("/article/doModify")
	public ModelAndView doModifyArticle(ArticleVO artcie, HttpSession session){
		ModelAndView view = new ModelAndView();
		
		boolean isSuccess = articleService.txModifyArticle(artcie, session);
		view.setViewName("redirect:/article/detail/"+artcie.getArticleId());
		return view;
	}
	
	@RequestMapping("/article/download/{articleId}")
	public void downloadFile(@PathVariable String articleId, HttpServletRequest request, HttpServletResponse response){
		
		
		ArticleVO article = articleService.getFileName(articleId);
		DownloadUtil downloadUtil = DownloadUtil.getInstance("d:"+File.separator+"uploadFile3");
		try {
			downloadUtil.download(request, response, article.getRealFileName(), article.getDisplayFileName());
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
		};
		
	}
	
}
