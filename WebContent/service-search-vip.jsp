<%@ page contentType="text/html;charset=utf-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<head>
<link href="css/service-makeplan-style.css" rel="stylesheet">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet"
	media="screen">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<style>
body {
	background-color: #333;
	color: #fff;
}

.datetimepicker {
	color: #333;
}
</style>
</head>
<body>
	<nav class="navbar navbar-default navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/CineplexSSH">Cineplex电影院欢迎您！&nbsp
					&nbsp &nbsp </a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">


					<li><a href="publishFilm.action"> &nbsp &nbsp 电影上线 &nbsp
							&nbsp </a></li>
					<li ><a href="makeFilmPlan.action"> &nbsp
							&nbsp 制定放映计划 &nbsp &nbsp <span class="sr-only">(current)</span>
					</a></li>

					<li><a href="makeEventPage.action"> &nbsp &nbsp 制定活动 &nbsp
							&nbsp </a></li>

					<li ><a href="sellTicket.action">售票</a> </li>
					<li class="active"><a href="searchVipInfo.action"> &nbsp &nbsp 会员信息 &nbsp
							&nbsp </a></li>
					<li ><a href="editPlan.action"> &nbsp &nbsp 修改放映计划 &nbsp &nbsp </a></li>	
				<li ><a href="endFilm.action"> &nbsp &nbsp 电影下线 &nbsp &nbsp </a></li>				
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<h3 align="center" style="margin-top:100px">查看会员信息</h3>
	
	<h4 align="center" style="margin-top:50px">	请输入会员卡号/ID</h4>
	<div class="box center-block">
		<form method="post" action="searchVipComplete.action">
			<input type="text" class=" form-control  center-block" name="userid"/>
			
			<button type="submit" class="button  center-block" >搜索</button>
		</form>
	</div>
	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>