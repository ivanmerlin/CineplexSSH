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
					<li class="active"><a href="makeFilmPlan.action"> &nbsp
							&nbsp 制定放映计划 &nbsp &nbsp <span class="sr-only">(current)</span>
					</a></li>

					<li><a href="makeEventPage.action"> &nbsp &nbsp 制定活动 &nbsp
							&nbsp </a></li>

					<li><a href="sellTicket.action">售票</a> </li>
				<li><a href="searchVipInfo.action"> &nbsp &nbsp 会员信息 &nbsp
							&nbsp </a></li>
					<li ><a href="editPlan.action"> &nbsp &nbsp 修改放映计划 &nbsp &nbsp </a></li>	
				<li ><a href="endFilm.action"> &nbsp &nbsp 电影下线 &nbsp &nbsp </a></li>				
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<h3 align="center">制定放映计划</h3>
	<form id="filmPlanForm" method="post" action="makeFilmPlan.action">
		<div class="infobox center-block">

			<div class="form-group center-block">
				<label for="inputId">请选择电影</label> <select class="form-control"
					name="filmName">
					<c:forEach items="${filmList}" var="li">
						<option>${li.name}</option>
					</c:forEach>
				</select>
			</div>

			<div class="form-group center-block">
				<label for="inputId">请输入电影价格</label> <input type="username"
					name="filmPrice" class="form-control" id="id"
					placeholder="Enter the movie price">
			</div>

			<div class="form-group center-block">
				<label for="inputId">请选择放映厅</label> <select class="form-control"
					name="roomName">
					<c:forEach items="${roomList}" var="li">
						<option>${li.name}</option>
					</c:forEach>
				</select>
			</div>

			<div class="center-block choosetime" >
				<div class="center-block input-group date form_datetime filmTime col-md-5"
					data-date-format="" data-link-field="dtp_input1" style="width:250px; height:35px" >
					<input style="width:160px; height:35px" class="form-control center-block" size="16"
						type="text" name="chosenTime" value=""  readonly>
						<span class="input-group-addon" style="width: 35px;height:35px">
						<span class="glyphicon glyphicon-remove" ></span>
						</span> 
						<span class="input-group-addon" style="width: 35px;height:35px">
							<span class="glyphicon glyphicon-th"></span>
						</span>
				</div>
				<input style="width: 30px;height:35px" type="hidden" id="dtp_input1" value="" name="plan_time" /><br />
			</div>

			<div class="form-submit">
				<a href="#" class="button center-block"
					onclick="document.getElementById('filmPlanForm').submit();">提交</a>
			</div>
		</div>
	</form>


	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="./js/bootstrap-datetimepicker.js"
		charset="UTF-8"></script>
	<script>
		$('.form_datetime').datetimepicker({
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			forceParse : 0,
			showMeridian : 1
		});
	</script>
</body>
</html>