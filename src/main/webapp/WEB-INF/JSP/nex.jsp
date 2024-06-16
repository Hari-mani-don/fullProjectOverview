<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
<h1>Users List: </h1>
	<c:forEach var="item" items ="${list}">
		<li>${item.userId}</li>
		<l	i>${item.userName}</li>
		<li>${item.password}</li>
		<li>${item.email}</li>
	</c:forEach>
	</ul>
</body>
</html>