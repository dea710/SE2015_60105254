<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>first</title>
</head>
<body>
<h1>
	안녕하십니까 학사관리시스템을 이용하기 위해서는 데이터베이스 설정이 필요합니다.<br/>  
</h1>
	<a href="${pageContext.request.contextPath }/FirstController/createDB">필요 데이터베이스 생성</a><br/>
	<a href="${pageContext.request.contextPath }/JoinController/login">로그인화면으로</a>
</body>
</html>
