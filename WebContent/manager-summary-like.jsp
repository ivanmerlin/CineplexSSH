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
	

				
				<li ><a href="checkFilmPlan.action"> &nbsp &nbsp 审批放映计划 &nbsp &nbsp  <span class="sr-only">(current)</span></a></li>
								<li class="dropdown">
				  <a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-expanded="false">&nbsp &nbsp 月统计情况  &nbsp &nbsp  <span class="caret"></span></a>
				  <ul class="dropdown-menu" role="menu">
					<li><a href="managerSumVip.action">会员统计</a></li>
					<li><a href="managerSumRoom.action">影院统计</a></li>
                    <li><a href="managerSumLike.action">会员喜好统计</a></li>
				  </ul>
				</li>	
				<li   ><a href="datadownload.action"> &nbsp &nbsp 下载导出数据 &nbsp &nbsp  <span class="sr-only">(current)</span></a></li>
						
				
				
			  </ul>
			</div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
	
	<h2 align="center"> 会员喜好统计  </h2>
	

	
	<div id="container" style="min-width: 200px; height: 300px; margin: 0 auto"> </div>
	

	
	
	
	</body>	
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	
	<script src="js/highcharts.js"></script>
<script>
$(function () {
    $('#container').highcharts({
        chart: {
            
          	backgroundColor: '#333333',
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '会员选择影片百分比图',
            style:{color: '#ffffff'}
        },
        tooltip: {
    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
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
            name: 'Browser share',
            data: [
                ['${filmList.get(0).name}',   ${likeSum[0]} ],
                ['${filmList.get(1).name}',      ${likeSum[1]}],
                
                ['${filmList.get(2).name}',  ${likeSum[2]}],
                ['${filmList.get(3).name}',     ${likeSum[3]}],
  
            ]
        }]
    });
    
    
   
    
    
    
    
});				
	</script>

</html>