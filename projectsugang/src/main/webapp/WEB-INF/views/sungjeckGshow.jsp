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
<table>
	<tr>
		<td callspan="5"> <h1>현재 강좌에 수강하는 학생 리스트 </h1></td>
	</tr>
	
	<tr>
		<td> 번호 </td>
		<td> 학생이름 </td>
		<td> 점수</td>
		<td> 등급</td>
	</tr>
					<c:forEach var="list" items="${list }">
						<tr>
							<td><c:out value="${list.num }" /></td>
							<td><c:out value="${list.name }" /></td>
							<td><c:out value="${list.grade }" /></td>
							<td>
								<form action="${pageContext.request.contextPath }/SungjeckController/Sungjeck.input" method="post">
									<input type="hidden" name="userID" value="${list.userID }">
									<input type="hidden" name="gangjwaID" value="${gangjwaID }">
									<input type="hidden" name="userName" value="${list.name }">
									<input type="submit" value="입력">
								</form>
							</td>
						</tr>
					</c:forEach>
</table>
<br/>
<a href="${pageContext.request.contextPath }/LoginController/logout">로그아웃</a><!--${pageContext.request.contextPath }를 써야 url이 초기화 된다.  -->
</body>
</html>