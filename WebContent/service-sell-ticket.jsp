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
<link href="css/vip-purchase-style.css" rel="stylesheet">
<style>
body {
	background-color: #333;
	color: #fff;
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
					<li><a href="makeFilmPlan.action"> &nbsp &nbsp 制定放映计划
							&nbsp &nbsp <span class="sr-only">(current)</span>
					</a></li>

					<li><a href="makeEventPage.action"> &nbsp &nbsp 制定活动 &nbsp
							&nbsp </a></li>

					<li class="active"><a href="sellTicket.action">售票</a> </li>
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




	<div class="center-block dateBox">
		<c:forEach items="${dayList}" var="s">
			<div class="dateWrapper">
				<button
					<c:if test="${chosenTime==s}"> class="dateButton-active" </c:if>
					<c:if test="${chosenTime!=s}"> class="dateButton" </c:if>
					type="button" onclick="updateDate('${s}')">${s}</button>
			</div>
		</c:forEach>
	</div>

	<div class="center-block filmBox">
		<c:forEach items="${filmList}" var="s">
			<div class="filmWrapper">
				<button
					<c:if test="${chosenFilm==s.name}"> class="filmButton-active" </c:if>
					<c:if test="${chosenFilm!=s.name}"> class="filmButton" </c:if>
					type="button" onclick="updateFilm('${s.name}')">${s.name}</button>
			</div>
		</c:forEach>
		<div class="filmWrapper">
			<button
				<c:if test="${chosenFilm=='全部'}"> class="filmButton-active" </c:if>
				<c:if test="${chosenFilm!='全部'}"> class="filmButton" </c:if>
				type="button" onclick="updateFilm('全部')">全部</button>
		</div>
	</div>

	<table class=" center-block table tableMy" >
				<th style="width:100px">放映计划</th>
				<th style="width:190px"> 电影名称</th>
				<th style="width:270px"> 开始时间</th>
				<th style="width:150px"> 放映厅</th>
				<th style="width:120px"> 价格</th>
				<th style="width:120px"> 选择</th>
		<c:forEach items="${planList}" var="s">
			<tr>
				<td>${s.id}</td>
				<td>${s.filmName}</td>
				<td>${s.getStringTime()}</td>
				<td>${s.getRoomName()}</td>
				<td>${s.price}</td>
				<td>
					<button class="purchaseBtn" type="button" style="color:#fff" 
						onclick="purchase('${s.id}')">选择</button>
				</td>
				</tr>
		</c:forEach>
	</table>

	


</body>
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	function cardBuy() {
		document.ticketForm.action = "sellTicketCard.action";
		document.ticketForm.submit();
	}
	function cashBuy() {
		document.ticketForm.action = "sellTicketCash.action";
		document.ticketForm.submit();

	}
	function updateDate(time) {

		$.post("sellTicket.action", {
			'chosenTime' : time
		}, function response(data) {
			location.reload();
		});

	}

	function updateFilm(name) {

		$.post("sellTicket.action", {
			'chosenFilm' : name
		}, function response(data) {
			location.reload();
		});

	}

	function purchase(id) {
		$.post("sellTicket.action", {
			'selectPlanId' : id
		}, function response(data) {
			location.replace("service-purchase-detail.jsp");
		});
	}
</script>
</html>