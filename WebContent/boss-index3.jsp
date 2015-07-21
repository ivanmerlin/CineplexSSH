<%@ page contentType="text/html;charset=utf-8"%> 
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<head>
	<link href="css/check-plan-style.css" rel="stylesheet">
	<style>
		 body{
		 background-color:#333;color:#fff;
		 }

	 </style>
	</head>
	<body>
		<nav class="navbar navbar-default navbar-inverse">
		  <div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
			  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			  </button>
			  <a class="navbar-brand" href="/CineplexSSH">Cineplex电影院欢迎您！&nbsp &nbsp &nbsp </a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			  <ul class="nav navbar-nav">
	

				
				<li><a href="typestatistics.action"> &nbsp &nbsp 决策支持 &nbsp &nbsp  <span class="sr-only">(current)</span></a></li>
				<li  class="active"  ><a href="changeratio.action"> &nbsp &nbsp 会员策略 &nbsp &nbsp  <span class="sr-only">(current)</span></a></li>
				
				<li class="dropdown">
				  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">&nbsp &nbsp 月统计情况  &nbsp &nbsp  <span class="caret"></span></a>
				  <ul class="dropdown-menu" role="menu">
					<li><a href="bossSumVip.action">会员统计</a></li>
					<li><a href="bossSumRoom.action">影院统计</a></li>
                    <li><a href="bossSumLike.action">会员喜好统计</a></li>
				  </ul>
				</li>	
				
				
			  </ul>
			</div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
	<h5 align="center" >修改成功!</h5>
	<h3 align="center"> 欢迎您！下面是各类型电影销量统计！  </h3>
   	<div class="center-block box">
   	<form action="changeratio2.action" id="form1">
   		<table class="table  table-bordered table-hover">
   			<tr>
   				<th>卡类型</th>
	   			<th>折扣比例</th>
	   			
   			</tr>
	   		
	   			<tr>
	   				<td>银卡</td>
	   				<td><input name="ratio1" value="${ratio[0]}" style="color:#000000;"/></td>
	   			</tr>
	   			<tr>
	   				<td>金卡</td>
	   				<td><input name="ratio2" value="${ratio[1]}" style="color:#000000;"/></td>
	   			</tr>
	   			<tr>
	   				<td>钻石卡</td>
	   				<td><input name="ratio3" value="${ratio[2]}" style="color:#000000;"/></td>
	   			</tr>
	   			<tr>
	   				<td>至尊VIP卡</td>
	   				<td><input name="ratio4" value="${ratio[3]}" style="color:#000000;"/></td>
	   			</tr>

	   		</table>
	   		</form>
	   		<button class="btn btn-info" onclick="document.getElementById('form1').submit();">确认</button>
   	</div>


	
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/highcharts.js"></script>
    <script type="text/javascript">
    	
    	function update(id){
    		$.post("checkFilmPlan.action",{'id':id},function response(data){
    			location.reload();
    		});
    		
    	}
    	
    </script>
	</body>
</html>