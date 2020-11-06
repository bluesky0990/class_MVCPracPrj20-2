<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>  
<%@ page import = "com.nellem.dato.*, java.util.List, java.sql.Date" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<title>게시판</title>
</head>
<body>
<div class="container">
	<h2>게시글 목록</h2>
	<br/>
	<button onclick="location.href='logout.do'" class="btn btn-outline-primary">로그아웃</button>
	<br>
	<table class="table table-striped table-hover">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
	<c:forEach var="dto" items = "${dtos}">
		<tr>
			<td><a href="view.do?no=${dto.no}">${dto.no}</a></td>
			<td>${dto.title}</td>
			<td>${dto.writer}</td>
			<td><fmt:formatDate value="${dto.date}"/></td>
		</tr>
	</c:forEach>
	</table>
	
	<c:set var="page" value="${(param.p == null)?1:param.p}"/>
	<c:set var ="startNum" value="${page-(page-1)%5}"/>
	
	<ul class="-list- center">
		<c:forEach var="i" begin="0" end="4">
			<li><a class="-text- orage bold" href="?p=${startNum+i}&t=&q="> ${startNum+i} </a></li>
		</c:forEach>
	</ul>
	<input type="button" value ="게시판 등록" onclick ="location.href='insertForm.do'">
</div>
</body>
</html>
