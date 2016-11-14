<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/common/header.jsp"/>
<body>
	<form enctype="multipart/form-data" method="post" action="<c:url value="/article/doModify"/>">
		<input type="hidden" id="articleId" name="articleId" value="${article.articleId}" readonly="readonly">
		<select id="categoryId" name="categoryId">
			<option value="1"${article.categoryId eq '1' ? 'selected' : "" }>전자가전</option>
			<option value="2"${article.categoryId eq '2' ? 'selected' : "" }>도서</option>
			<option value="3"${article.categoryId eq '3' ? 'selected' : "" }>의류</option>
			<option value="4"${article.categoryId eq '4' ? 'selected' : "" }>식품</option>
			<option value="5"${article.categoryId eq '5' ? 'selected' : "" }>가구</option>
		</select><br/>
		파일 : ${article.displayFileName}
		<input type="file" id="file" name="file" ><br/>
		
		<label for="price">가격 :</label>
		<input type="text" id="price" name="price" style="width:300px" value="${article.price}"><br/>
		
		<label for="subject">제목 : </label>
		<input type="text" id="subject" name="subject" style="width:300px" value="${article.subject}"><br/>
		
		<label for="content">내용 : </label>
		<textarea rows="300" cols="300" id="content" name="content" style="width:300px; height: 300px;">${article.content}</textarea>
		
		<input type="submit" id="modyfiBtn" value="수정">
	</form>
</body>
</html>