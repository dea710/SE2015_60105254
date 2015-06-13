<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>Gangjwa</title>
</head>
<body>
<h1>
	강좌개설
</h1>
<h1>강좌개설 화면</h1>
	<form action="${pageContext.request.contextPath }/GangjwaController/Gangjwa.do" method="post">	
		강좌번호 <input type="text" name="gangjwaID"> <br/>
		강좌이름 <input type="text" name="name"> <br/>
		강좌시간(입력예제 00:00~00:50) <input type="text" name="time"> <br/>
		연도 <input type="text" name="openyear"> <br/>
		학년 <input type="text" name="ngrade"> <br/>
		학점 <input type="text" name="hackjum"> <br/>
		수강인원 <input type="text" name="inwon"> <br/>
		<input type="hidden" name="userID" value='${ID}' >
		
		<input type="submit" value="강좌개설하기"> <input type="reset" value="다시입력">
	</form>
	<br/>
	<a href="${pageContext.request.contextPath }/JoinController/login">로그인화면으로 돌아가기</a>
</body>
</html>
