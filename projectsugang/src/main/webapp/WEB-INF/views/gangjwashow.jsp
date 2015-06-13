<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Gangjwa</title>
</head>
<body>

<table>
	<tr>
		<td callspan="8"> <h1>현재 개설한 강좌 리스트 </h1></td>
	</tr>
	
	<tr>
		<td> 강좌번호 </td>
		<td> 강좌이름 </td>
		<td> 시간 </td>
		<td> 연도 </td>
		<td> 학년 </td>
		<td> 학점 </td>
		<td> 최대인원 </td>
		<td> 수강학생조회</td>
	</tr>
					<c:forEach var="list" items="${list }">
						<tr>
							<td><c:out value="${list.gangjwaID }" /></td>
							<td><c:out value="${list.gangjwaname }" /></td>
							<td><c:out value="${list.time }" /></td>
							<td><c:out value="${list.openyear }" /></td>
							<td><c:out value="${list.ngrade }" /></td>
							<td><c:out value="${list.hackjum }" /></td>
							<td><c:out value="${list.inwon }" /></td>
							<td>
								<form action="${pageContext.request.contextPath }/GangjwaController/Gangjwa.inwon" method="post">
									<input type="hidden" name="gangjwaID" value="${list.gangjwaID }">
									<input type="submit" value="조회">
								</form>
							</td>
						</tr>
					</c:forEach>
</table>
<br/>
	<a href="${pageContext.request.contextPath }/JoinController/login">로그인화면으로</a>
</body>
</html>
