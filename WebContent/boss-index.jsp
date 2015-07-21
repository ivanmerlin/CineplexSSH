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
	

				
				<li class="active" ><a href="typestatistics.action"> &nbsp &nbsp 决策支持 &nbsp &nbsp  <span class="sr-only">(current)</span></a></li>
				<li  ><a href="changeratio.action"> &nbsp &nbsp 会员策略 &nbsp &nbsp  <span class="sr-only">(current)</span></a></li>
				
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
	
	<h3 align="center"> 欢迎您！下面是各类型电影销量统计！  </h3>
   	<div class="center-block box">
   		<div id="container" style="min-width: 200px; height: 300px; margin: 0 auto"> </div>
   	</div>
	
	<div class="tipBox center-block">
		Tip:
		<div class="tip">
			根据近期销量显示，动作片更受欢迎。
		</div>		
	</div>

	<div class="opinionBox center-block" >指导意见
		Tip:
		<div class="opinion">
			 <input id="opinion1" type="text" name="opinion" class="form-control">
			 <button class="btn  center-block btn-info" onclick="postopinion()">提交</button>
		</div>		
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
    	function postopinion(id){
    		$.post("postopinion.action",{'opinion':$("#opinion1").val()},function response(data){
    			alert("成功");
    			location.reload();
    		});
    		
    	}
    	$(function () {
    	    $('#container').highcharts({
    	        chart: {
    	            
    	          	backgroundColor: '#333333',
    	            plotBorderWidth: null,
    	            plotShadow: false
    	        },
    	        title: {
    	            text: '影片销量百分比图',
    	            style:{color: '#ffffff'}
    	        },
    	        tooltip: {
    	    	    pointFormat: '{series.name}: <b>{point.y}元</b>'
    	        },
    	        plotOptions: {
    	            pie: {
    	                allowPointSelect: true,
    	                cursor: 'pointer',
    	                dataLabels: {
    	                    enabled: true,
    	                    color: '#FFFFFF',
    	                    connectorColor: '#FFFFFF',
    	                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
    	                }
    	            }
    	        },
    	        series: [{
    	            type: 'pie',
    	            name: '票房',
    	            data: [
    	                ${typeName}
    	            ]
    	        }]
    	    });

    	});		
    </script>
	</body>
</html>