package com.psy.pricearticle.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.psy.user.vo.UserVO;

public class ArticleVO {
	private String articleId;
	
	@NotNull(message="제목을입력하세요")
	@NotEmpty(message="제목을입력하세요")
	private String subject;
	@NotNull(message="내용을입력하세요")
	@NotEmpty(message="내용을입력하세요")
	private String content;
	
	private String realFileName;
	
	private String displayFileName;
	
	private String createdDate;
	
	private String userId;
	
	private String categoryId;
	
	private int price;
	
	private MultipartFile file;
	
	private UserVO user;
	
	private CategoryVO categoryVO;
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public CategoryVO getCategoryVO() {
		return categoryVO;
	}
	public void setCategoryVO(CategoryVO categoryVO) {
		this.categoryVO = categoryVO;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRealFileName() {
		if(realFileName==null){
			return"";
		}
		return realFileName;
	}
	public void setRealFileName(String realFileName) {
		this.realFileName = realFileName;
	}
	public String getDisplayFileName() {
		if(displayFileName==null){
			return"";
		}
		return displayFileName;
	}
	public void setDisplayFileName(String displayFileName) {
		this.displayFileName = displayFileName;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public UserVO getUser() {
		return user;
	}
	public void setUser(UserVO user) {
		this.user = user;
	}
	
	
	
}
