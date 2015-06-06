<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>sugang</title>
</head>
<body>
<table>
	<tr>
		<td callspan="4"> <h1>현재 수강 리스트</h1> </td>
	</tr>
	
	<tr>
		<td> 강좌번호 </td>
		<td> 강좌이름 </td>
		<td> 시간 </td>
		<td> 반 </td>
	</tr>
					<c:forEach var="list" items="${list }">
						<tr>
							<td><c:out value="${list.gangjwaID }" /></td>
							<td><c:out value="${list.name }" /></td>
							<td><c:out value="${list.time }" /></td>
							<td><c:out value="${list.classs }" /></td>
							
						</tr>
					</c:forEach>
</table>
<br/>
	<a href="${pageContext.request.contextPath }/JoinController/login">로그인화면으로</a>

</body>
</html>
