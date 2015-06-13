<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>수강신청 화면</h1>

<table>
	<tr>
	<td> 강좌번호 </td>
	<td> 강좌이름 </td>
	<td> 담당교수님 </td>
	<td> 시간 </td>
	<td> 연도 </td>
	<td> 학년 </td>
	<td> 학점 </td>
	<td> 최대인원 </td>
	<td> 신청 </td>
	</tr>
					<c:forEach var="list" items="${list }">
						<tr>
							<td><c:out value="${list.gangjwaID }" /></td>
							<td><c:out value="${list.gangjwaname }" /></td>
							<td><c:out value="${list.username }" /></td>
							<td><c:out value="${list.time }" /></td>
							<td><c:out value="${list.openyear }" /></td>
							<td><c:out value="${list.ngrade }" /></td>
							<td><c:out value="${list.hackjum }" /></td>
							<td><c:out value="${list.inwon }" /></td>
							<td>
								<form action="${pageContext.request.contextPath }/SugangController/Sugang.do" method="post">
									<input type="hidden" name="userID" value="${userID }"	>
									<input type="hidden" name="gangjwaID" value="${list.gangjwaID }">
									<input type="submit" value="신청하기">
								</form>
							</td>
						</tr>
					</c:forEach>
</table>
<br/>

<a href="${pageContext.request.contextPath }/LoginController/logout">로그아웃</a><!--${pageContext.request.contextPath }를 써야 url이 초기화 된다.  -->
</body>
</html>