<%@ page contentType="text/html;charset=utf-8"%> 

<!DOCTYPE html>
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<head>
	<link href="css/signup-style.css" rel="stylesheet">
	<style>
		 body{
		 background-color:#333;color:#fff;
		 }

	 </style>
	</head>
	<body>
	<h1  align="center" style="margin-top:200px"> 欢迎来到Cineplex多厅电影院</h1>

	<h2 align="center" style="margin-top:30px">欢迎加入我们！</h2>
	
	<div class="info">
		<form id="signupForm" method="post" action="register.action">
		  <div class="form-group">
			<label for="inputId">请输入用户名 *不可与其他会员重复 也不可使用纯数字</label>
			<input type="username" class="form-control" name="username" id="username" placeholder="Enter Id Number">
		  </div>
		  <div class="form-group">
			<label for="inputPassword">请输入密码 *注意大小写</label>
			<input type="password" class="form-control" name="password" id="password" placeholder="Password">
		  </div>
		  <div class="form-group">
			<label for="inputPasswordConfirm">请再次输入密码 *确保输入一致</label>
			<input type="password" class="form-control" name="passwordconfirm" id="passwordconfirm" placeholder="PasswordConfirm">
		  </div>
		  <div class="form-group">
			<label for="inputEmail">邮箱*</label>
			<input type="email" class="form-control" name="email" id="email" placeholder="Enter Email Address">
		  </div>
		  <div class="form-group">
			<label for="inputPhone">手机*</label>
			<input type="text" class="form-control" name="phone" id="phone" placeholder="Enter Cell Phone Number">
		  </div>
		  
		  

		  <a href="#" class="button login" data="submit" onclick="document.getElementById('signupForm').submit();">确认一致 点击注册</a>
		</form>
	</div>



    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	</body>
</html>