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
	<h1>회원가입</h1>
		<form action="signup.do" method="post">
			<div class="form-group">
				<label for="id">ID</label>
				<div class="input-group mb-3">
					<input type="text" class="form-control" name="id">
					<div class="input-group-append">
						<input type="button" name="id_chk" value="중복확인" class="btn btn-outline-primary">
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<label for="pwd">Pwd</label>
				<input type="password" class="form-control" name="pwd">
			</div>
			
			<div class="form-group">
				<label for="name">Name</label>
				<input type="text" class="form-control" name="name">
			</div>
			
			<div class="form-group">
				<label for="email">Email</label>
				<input type="email" class="form-control" name="email">
			</div>
			<button type="submit" class="btn btn-primary">회원가입</button>
			<button type="reset" class="btn btn-outline-primary">다시입력</button>
			<input type="button" value="돌아가기" onclick="location.href='index.do'" class="btn btn-outline-primary">
		</form>
	</div>
</body>
</html>