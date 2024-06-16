<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Image Display</title>
</head>
<body>
    <h1>Image Display</h1>

    <c:if test="${not empty error}">
        <p>${error}</p>
    </c:if>
    
    <c:if test="${not empty imageData}">
        <img src="data:;base64,${imageData}" alt="${imageName}">
        <br><br>
        <a href="/image/${imageId}/download?download=true">Download Image</a>
    </c:if>
    
    <a href="users">Users</a>
   <form action="images" method="post" enctype="multipart/form-data">
   <input type="file" name="file">
   <button type="submit">submit</a>
   
   </form>
</body>
</html>
