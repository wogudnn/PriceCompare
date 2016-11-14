<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/view/common/header.jsp"/>
<body>
<script type="text/javascript">
	$().ready(function(){
		$("#deleteBtn").click(function(){
			if(confirm("삭제하시겠습니까?")){
				location.href="<c:url value="/article/delete/${article.articleId}"/>"
			}
		});
		
		$("#modifyBtn").click(function(){
			if(confirm("수정하시겠습니까?")){
				location.href="<c:url value="/article/modify/${article.articleId}"/>"
			}
		});
		
		$("#replyForm").on("click","#replyBtn", function(){
			
			$.post("<c:url value="/article/addReply"/>",$("#replyForm").serialize(),function(data){
				
			});
			
		});
	});
</script>
	<div id="wrapper">
		<div>제목 : ${article.subject}</div>
		<div>분류 : ${article.categoryVO.categoryName}</div>
		<div>이름 : ${article.user.userName}</div>
		<div>가격 : <fmt:formatNumber value="${article.price}" groupingUsed="true"/>원</div>
		<div>작성일 : ${article.createdDate}</div>
		<div><a href="<c:url value="/article/download/${article.articleId} " />">${article.displayFileName}</a></div>
		<div>내용 : ${article.content}</div>
	</div>
	<c:if test="${sessionScope._USER_.userId eq article.userId}">
	<input type="button" value="삭제" id="deleteBtn"><input type="button" value="수정" id="modifyBtn">
	</c:if>
	<%-- <form id="replyForm" name="replyForm" method="post" action="">
		<input type="hidden" id="parentReplyId" name="parentReplyId" value="0">
		<input type="hidden" id="articleId" name="articleId" value="${article.articleId}"readonly="readonly">
		<input type="hidden" id="userId" name="userId" value="${sessionScope._USER_.userId}" readonly="readonly">
		<label for="replyContent">댓글 :</label>
		<textarea rows="200" cols="200" id="replyContent" name="replyContent"></textarea>
		<input type="button" id="replyBtn" value="등록">
	</form>
	
	<div id="replies">
	
	</div>
	<div id="replyFormat" style="display: none;">
		<table>
			<tr class="reply">
				<td>
					<span class="userName"></span>
				</td>
				<td>
					<span class="date"></span><br/>
					<span class="replyContent"></span>
				</td>
			</tr>
		</table>
	</div> --%>
</body>
</html>