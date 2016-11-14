<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/view/common/header.jsp"/>
<script type="text/javascript">
	$().ready(function(){
		$("#writeBtn").click(function(){
			if($("#price").val()==0){
				alert("가격을입력하세요");
				return;
			}
			if($("#subject").val()==""){
				alert("제목을입력하세요");
				return;
			}
			if($("#content").val()==""){
				alert("내용을입력하세요");
				return;
			}
			
			$("#writeForm").attr({
				"method": "post",
				"action": "<c:url value="/article/doWrite"/>"
			}).submit();
			
		});
		
	});
</script>
<body>
	<form:form commandName="articleVO" enctype="multipart/form-data" id="writeForm" name="writeForm">
		<select id="categoryId" name="categoryId">
			<option value="1">전자가전</option>
			<option value="2">도서</option>
			<option value="3">의류</option>
			<option value="4">식품</option>
			<option value="5">가구</option>
		</select>
		
		<input type="file" id="file" name="file"><br/>
		
		<label for="price">가격 :</label>
		<input type="number" id="price" name="price" style="width:300px"><br/>
		
		
		<label for="subject">제목 : </label>
		<input type="text" id="subject" name="subject" style="width:300px"><br/>
		<form:errors path="subject" /><br/>
		
		<label for="content">내용 : </label>
		<textarea rows="300" cols="300" id="content" name="content" style="width:300px; height: 300px;"></textarea><br/>
		<form:errors path="content"/><br/>
		<input type="button" id="writeBtn" value="등록">
	</form:form>
</body>
</html>