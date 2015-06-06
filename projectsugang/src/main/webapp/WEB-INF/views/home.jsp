<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>학사관리시스템</h1>
<br/>
<br/>
<h3>
	로그인 
</h3>


	<form action="LoginController/login.do" method="post">	
		사용자 아이디 <input type="text" name="userID"> <br/>
		비밀번호  <input type="password" name="userPassword"><br/>
		<input type="submit" value="로그인">.
	</form>
		<a href="JoinController/join">회원가입</a>
</body>
</html>
