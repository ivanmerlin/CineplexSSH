<%@ page contentType="text/html;charset=utf-8"%> 

<!DOCTYPE html>
<html>
	<meta http-equiv="Content-Type" content=
	.........."text/html; charset=utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<head>
	<link href="css/index-style.css" rel="stylesheet">
	<style>
		 body{
		 background-color:#333;color:#fff;
		 }
		  @import "css/style.css";
	 </style>
	</head>
	<body>
	<h1  align="center" style="margin-top:200px"> 欢迎来到Cineplex多厅电影院</h1>



	<h2 align="center" style="margin-top:30px">你是？</h2>
	<div class="box">
			<div class="link link-member">
				<form id="_form" method="post" action="memberLogin.action">
					<span class="icon"> </span>
					<input type="hidden" name="type" value="member" /> 
					<a href="#" class="button" data="会员"  onclick="document.getElementById('_form').submit();">会员</a>
				</form>

			</div>		
			<div class="link link-service">
				<form id="_form2" method="post" action="serviceLogin.action">
					<span class="icon"> </span>
					<input type="hidden" name="type" value="service" /> 
					<a href="#" class="button" data="服务"  onclick="document.getElementById('_form2').submit();">服务人员</a>
				</form>
			</div>	
	</div>



    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	</body>
</html>