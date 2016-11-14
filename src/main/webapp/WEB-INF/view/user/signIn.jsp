<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/view/common/header.jsp"/>
<script type="text/javascript">
	$().ready(function(){
		
		$("#signInBtn").click(function(){
			if($("#userId").val() == ""){
				alert("아이디를 입력하세요");
				return;
			}
			if($("#hashedPassword").val() == ""){
				alert("비밀번호를 입력하세요");
				return;
			}
			$("#signInForm").attr({
				"method": "post",
				"action": "<c:url value="/doSignIn"/>"
			}).submit();
		});
		
	});
</script>
<body>
	<form id="signInForm">
		<label for="userId">아이디 : </label>
		<input type="text" id="userId" name="userId"><br/>
		
		<label for="hashedPassword">비밀번호 :</label>
		<input type="password" id="hashedPassword" name="hashedPassword"><br/>
		
		<input type="button" id="signInBtn" value="로그인">
	</form>
</body>
</html>