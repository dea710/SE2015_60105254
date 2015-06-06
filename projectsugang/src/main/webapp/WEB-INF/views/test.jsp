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

<h1>test</h1>
${result }<br/>
${result2 }<br/>
id는 ${user.getID() }<br/> <!-- 객체일경우 함수를 쓴다. -->
암호는 ${user.getPassword() }<br/>
id는 ${user2.getID() }<br/> <!-- 객체일경우 함수를 쓴다. -->
암호는 ${user2.getPassword() }<br/>

					<c:forEach var="list" items="${list }">
						<tr>
							<td><c:out value="${list.ID }" /></td>
							<td><c:out value="${list.password }" /></td>
							<td><c:out value="${list.name }" /></td>
						</tr>
					</c:forEach>
					
<a href="${pageContext.request.contextPath }/LoginController/logout">로그아웃</a><!--${pageContext.request.contextPath }를 써야 url이 초기화 된다.  -->
</body>
</html>