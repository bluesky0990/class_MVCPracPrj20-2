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
	<form action="boardUpdatedo.do">
		<input type="hidden" value="${dto.no}" name="no">
		<input type="hidden" value="${dto.writer}" name="writer">
		제목: <input type="text" value="${dto.title}" name="title">
		내용: <input type="text" value="${dto.content}" name="content">
		작성일: ${dto.date}
		<input type="submit" value="수정하기">
		<input type="button" value ="삭제하기" onclick ="location.href='viewDelete.do?no=${dto.no}'">
		<input type="button" value ="홈으로" onclick ="location.href='boardList.do'">
	</form>
</div>
</body>
</html>
