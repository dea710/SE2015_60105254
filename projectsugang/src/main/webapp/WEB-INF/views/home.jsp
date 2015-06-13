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
<h3>
	로그인 (<a href="FirstController/first">처음 실행하시는 분은 이곳으로...</a>)
</h3>
	<form action="LoginController/login.do" method="post">	
		<table>
			<tr>
				<td>
					사용자 아이디 <input type="text" name="userID">
				</td>
			</tr>
			<tr>
				<td>
					비밀번호  <input type="password" name="userPassword">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="로그인">
				</td>
			</tr>
		</table>
	</form>
	<br>
	
		<a href="JoinController/join">회원가입</a>
</body>
</html>
