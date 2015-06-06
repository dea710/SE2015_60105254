<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Join</title>
</head>
<body>
<h1>
	회원가입  
</h1>

	<form action="${pageContext.request.contextPath }/JoinController/join.do" method="post">	
		아이디 <input type="text" name="userID"> <br/>
		비밀번호  <input type="password" name="Password"><br/>
		이름 <input type="text" name="name"> <br/>
		직책<input type = "radio" name="grade" value="g">교수 <input type = "radio" name="grade" value="h" checked> 학생
		<input type="submit" value="가입하기"> <input type="reset" value="다시입력">
	</form>
<br/>
	<a href="${pageContext.request.contextPath }/JoinController/login">로그인화면으로 돌아가기</a>
</body>
</html>
