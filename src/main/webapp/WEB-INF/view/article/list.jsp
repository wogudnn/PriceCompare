<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/view/common/header.jsp"/>
<body>
<script type="text/javascript">
	$().ready(function(){
		$("#writeBtn").click(function(){
			location.href="<c:url value="/article/write"/>"
		});
	});
</script>
	<form id="searchForm" name="searchForm">
		${paging}
		<select id="categoryId" name="categoryId">
			<option value="0"${searchVO.categoryId eq '0' ? 'selected' : ""}>분류선택</option>
			<option value="1"${searchVO.categoryId eq '1' ? 'selected' : ""}>전자가전</option>
			<option value="2"${searchVO.categoryId eq '2' ? 'selected' : ""}>도서</option>
			<option value="3"${searchVO.categoryId eq '3' ? 'selected' : ""}>의류</option>
			<option value="4"${searchVO.categoryId eq '4' ? 'selected' : ""}>식품</option>
			<option value="5"${searchVO.categoryId eq '5' ? 'selected' : ""}>가구</option>
		</select><br/>
		가격범위 : <input type="text" id="priceMin" name="priceMin" style="width: 50px" value="${searchVO.priceMin}"  > ~
		<input type="text" id="priceMax" name="priceMax" style="width: 50px" value="${searchVO.priceMax}">
		<input type="radio" class="orderBy" name="orderBy" value="1"${searchVO.orderBy eq '1' ? 'checked' : ""}>가격내림차순
		<input type="radio" class="orderBy" name="orderBy" value="2"${searchVO.orderBy eq '2' ? 'checked' : ""}>가격오름차순 
		<select id="searchType" name="searchType" >
			<option value="1">제목</option>
			<option value="2">작성자</option>
		</select>
		<input type="text" id="searchKeyword" name="searchKeyword" style="width: 100px">
		<input type="button" id="searchBtn" value="검색" onclick="movePage(0)">
	</form>
	<table>
		<tr>
			<td>번호</td>
			<td>분류</td>
			<td>제목</td>
			<td>가격</td>
			<td>작성자</td>
			<td>작성일</td>
		</tr>
		<c:choose>
		<c:when test="${not empty articleList.articleList}">
			<c:forEach items="${articleList.articleList}" var="article">
		<tr>
			<td>${article.articleId}</td>
			<td>${article.categoryVO.categoryName}</td>
			<td><a href="<c:url value="/article/detail/${article.articleId}"/>">${article.subject}</a>
				<c:if test="${not empty article.displayFileName}">
					<img style="width: 15px; height: 15px" src="<c:url value="/img/file.png"/>">
				</c:if> </td>
			<td><fmt:formatNumber value="${article.price}" groupingUsed="true"/>원</td>
			<td>|${article.user.userName}</td>
			<td>${article.createdDate}</td>
		</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<span>등록된 상품이 없습니다.</span>
		</c:otherwise>
	</c:choose>
	</table>
	<input type="button" id="writeBtn" value="글쓰기">
</body>
</html>