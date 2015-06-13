<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>성적입력</title>
</head>
<body>

		<form action="${pageContext.request.contextPath }/SungjeckController/Sungjeck.do" method="post">	
		<table>
		<tr>
			<td>학생이름</td>
			<td>평점</td>
		</tr>
			<tr>
				<td>${userName }<input type="hidden" name="gangjwaID" value = "${gangjwaID }"><input type="hidden" name="userID" value = "${userID }"></td>
				<td>
					<select name="grade">
						<option value="A+">A+</option>
						<option value="A0">A0</option>
						<option value="A-">A-</option>
						<option value="B+">B+</option>
						<option value="B0">B0</option>
						<option value="B-">B-</option>
						<option value="C+">C+</option>
						<option value="C0">C0</option>
						<option value="C-">C-</option>
						<option value="F">F</option>
					</select>
				
				</td>
				<td><input type="submit" value="기입하기"> <input type="reset" value="다시입력"></td>
			</tr>
		</table>
		
		</form>
<br/>	
<a href="${pageContext.request.contextPath }/LoginController/logout">로그아웃</a><!--${pageContext.request.contextPath }를 써야 url이 초기화 된다.  -->
</body>
</html>