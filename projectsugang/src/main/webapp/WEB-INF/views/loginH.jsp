<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Hackseang</title>
</head>
<body>
<h1>
	안녕하십니까 ${userSession.getName() }학생님 
</h1>
<table>
<tr>
<td>
	<form action="${pageContext.request.contextPath }/SugangController/Sugang.show" method="post">
		<input type="hidden" name="userID" value='${userSession.getID() }' >
		<input type="submit" value="신청수강조회">
	</form>
</td>
<td>
	<form action="${pageContext.request.contextPath }/SugangController/Sugang.go" method="post">
		<input type="hidden" name="userID" value='${userSession.getID() }' >
		<input type="submit" value="수강신청">
	</form>
</td>
<td>
	<form action="${pageContext.request.contextPath }/SungjeckController/Sungjeck.hshow" method="post">
		<input type="hidden" name="userID" value='${userSession.getID() }' >
		<input type="submit" value="성적확인">
	</form>
</td>
</tr>
</table>
<br/>
	<a href="${pageContext.request.contextPath }/JoinController/login">로그인화면으로</a>

</body>
</html>
