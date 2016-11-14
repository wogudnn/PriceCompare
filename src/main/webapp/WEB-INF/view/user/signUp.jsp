<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/view/common/header.jsp"/>
<script type="text/javascript">
	$().ready(function(){
		
		$("#signUpBtn").click(function(){
			
			if($("#userId").val() == ""){
				alert("아이디를 입력하세요");
				return;
			}
			if($("#hashedPassword").val() == ""){
				alert("비밀번호를 입력하세요");
				return;
			}
			if($("#userName").val() == ""){
				alert("이름을 입력하세요");
				return;
			}
			if($("#phoneNumber").val() == ""){
				alert("전화번호를 입력하세요");
				return;
			}
			
			$("#signUpForm").attr({
				"method": "post",
				"action": "<c:url value="/doSignUp"/>"
			}).submit();
		});
		
	});
</script>
<body>
	<form:form commandName="userVO" id="signUpForm" >
		<label for="userId">아이디 : </label>
		<input type="text" id="userId" name="userId"><br/>
		<form:errors path="userId"/><br/>
		
		<label for="hashedPassword">비밀번호 :</label>
		<input type="password" id="hashedPassword" name="hashedPassword"><br/>
		<form:errors path="hashedPassword" /><br/>
		
		<label for="userName">이름 :</label>
		<input type="text" id="userName" name="userName" ><br/>
		<form:errors path="userName" /><br/>
		
		<label for="phoneNumber">전화번호 :</label>
		<input type="text" id="phoneNumber" name="phoneNumber" ><br/>
		<form:errors path="phoneNumber" /><br/>
		
		<input type="button" id="signUpBtn" value="등록">
	</form:form>

</body>
</html>