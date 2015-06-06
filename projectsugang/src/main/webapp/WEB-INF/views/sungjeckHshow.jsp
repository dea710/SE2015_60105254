<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>성적조회</title>
</head>
<body>
<table>
	<tr>
		<td callspan="4"> <h1>성적 리스트</h1> </td>
	</tr>
	
	<tr>
		<td> 강좌번호 </td>
		<td> 강좌이름 </td>
		<td> 점수 </td>
		<td> 등급 </td>
	</tr>
					<c:forEach var="list" items="${list }">
						<tr>
							<td><c:out value="${list.gangjwaID }" /></td>
							<td><c:out value="${list.gangjwaName }" /></td>
							<td><c:out value="${list.score }" /></td>
							<td><c:out value="${list.grade }" /></td>
							
						</tr>
					</c:forEach>
</table>
<br/>	
<a href="${pageContext.request.contextPath }/LoginController/logout">로그아웃</a><!--${pageContext.request.contextPath }를 써야 url이 초기화 된다.  -->
</body>
</html>