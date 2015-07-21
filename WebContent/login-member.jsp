<%@ page contentType="text/html;charset=utf-8"%> 

<!DOCTYPE html>
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<head>
	<link href="css/login-style.css" rel="stylesheet">
	<style>
		 body{
		 background-color:#333;color:#fff;
		 }

	 </style>
	</head>
	<body>
	<h1  align="center" style="margin-top:200px"> 欢迎来到Cineplex多厅电影院</h1>

	<h2 align="center" style="margin-top:30px">请登录/注册</h2>
	
	<div class="info">
		<form id="loginForm" method="post" action="memberLogin.action">
		  <div class="form-group">
			<label for="inputId">请输入七位会员号或自定义用户名</label>
			<input type="username" name="username" class="form-control" id="id" placeholder="Enter Member Id Number">
		  </div>
		  <div class="form-group">
			<label for="inputPassword">密码</label>
			<input type="password" name="password"class="form-control" id="password" placeholder="Password">
		  </div>

		  <a href="#" class="button login" data="submit" onclick="document.getElementById('loginForm').submit();">登陆</a>
		</form>
	</div>
	<div class="signup">
	<h5 align="center" class="reminder">没有我们的会员号？</h4>
	<form id="signupForm" method="post" action="register.action">
		<input type="hidden" name="type" value="signup" /> 
		<a href="#" class="button" data="signup" onclick="document.getElementById('signupForm').submit();">注册</a>
	</form>
	</div>



    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	</body>
</html>