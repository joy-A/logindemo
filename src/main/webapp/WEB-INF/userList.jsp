<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1px" width="80%" align="center">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
		</tr>
		<c:forEach items="${userList}" var="u">
			<tr>
				<td>${u.aid}</td>
				<td>${u.username}</td>
				<td>${u.passwd}</td>
				<td>${u.type}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
