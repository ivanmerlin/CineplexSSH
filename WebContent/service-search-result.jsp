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
<link href="css/vip-info-style.css" rel="stylesheet">
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
					<li><a href="makeFilmPlan.action"> &nbsp
							&nbsp 制定放映计划 &nbsp &nbsp <span class="sr-only">(current)</span>
					</a></li>

					<li><a href="makeEventPage.action"> &nbsp &nbsp 制定活动 &nbsp
							&nbsp </a></li>

					<li><a href="sellTicket.action">售票</a> </li>
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

	<h3 align="center">查看会员信息</h3>
	<div class=" Box center-block">
		<table class="table tableMy2 center-block">
			<tr style="width:200px"><td>会员ID:</td>	<td style="text-align:center;width:400px">${user.id}</td></tr>
			<tr style="width:200px"><td>用户名:</td>	<td style="text-align:center;width:400px">${user.username}<td></tr>
			<tr style="width:200px"><td>邮箱:</td>	<td style="text-align:center;width:400px">${user.email}</td></tr>
			<tr style="width:200px"><td>手机:</td>	<td style="text-align:center;width:400px">${user.phone}</td></tr>
			<tr style="width:200px"><td>会员状态:</td>	<td style="text-align:center;width:400px"><c:if test="${user.activate==1}">激活</c:if><c:if test="${user.activate!=1}">未激活</c:if></td></tr>
			<tr style="width:200px"><td>余额:</td>	<td style="text-align:center;width:400px">${user.balance}</td></tr>
			<tr style="width:200px"><td>会员卡级别:</td>	<td style="text-align:center;width:400px">${user.grade}</td></tr>
			<tr style="width:200px"><td>积分:</td>	<td style="text-align:center;width:400px">${user.credit}</td></tr>
			<tr style="width:200px"><td>生日:</td>	<td style="text-align:center;width:400px">${user.getBirthdateStr()}</td></tr>
			<tr style="width:200px"><td>性别:</td>	<td style="text-align:center;width:400px">${user.gender}</td></tr>
			<tr style="width:200px"><td>城市:</td>	<td style="text-align:center;width:400px">${user.city}</td></tr>
			
		</table>
	</div>
	
	<h4 align="center" style="margin-top:30px">充值记录</h4>
      <div class="infobox2 center-block">
    	<table class="table tableMy">
        	<c:forEach items="${rechargeRecord}" var="q">
        		<tr>
        			<td>${q.num}</td>
        			<td>${q.time}</td>
        		</tr>        	
        	</c:forEach>
        </table>
	</div>
	<h4 align="center" style="margin-top:30px">消费记录</h4>
       <div class="infobox2 center-block">
    	<table class="table tableMy">
        	<c:forEach items="${rechargeRecord}" var="q">
        		<tr>
        			<td>${q.num}</td>
        			<td>${q.time}</td>
        		</tr>        	
        	</c:forEach>
        </table>
    
    
    </div>

	

	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>