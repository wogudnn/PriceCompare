<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.js"/>"></script>
	<c:if test="${not empty sessionScope._USER_}">
	<a href="<c:url value="/logOut"/>">로그아웃</a>
	</c:if>
	<a href="<c:url value="/article/list"/>">목록으로</a>
	<c:if test="${empty sessionScope._USER_}">
	<a href="<c:url value="/signUp"/>">회원가입</a>
	<a href="<c:url value="/signIn"/>">로그인</a>
	</c:if>
	<hr/>
</head>

	