<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>로그인</h1>
		<form action="login.do" method="post">
			<div class="form-group">
				<label for="id">ID:</label>
				<input type="text" class="form-control" id="id" name="id">
			</div>
			
			<div class="form-group">
				<label for="pwd">Pwd:</label>
				<input type="password" class="form-control" id="pwd" name="pwd">
			</div>
			<button type="submit" class="btn btn-primary">로그인</button>
			<input type="button" onclick="location.href='signuppage.do'" class="btn btn-outline-primary" value="회원가입">
		</form>
	</div>
</body>
</html>