<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Gyosu</title>
</head>
<body>
<h1>
	안녕하십니까 ${userSession.getName() }관리자님  
</h1>
	<a href="${pageContext.request.contextPath }/JoinController/login">로그인화면으로</a>
</body>
</html>
