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
				<li  ><a href="changeratio.action"> &nbsp &nbsp 会员策略 &nbsp &nbsp  <span class="sr-only">(current)</span></a></li>
								<li class="dropdown  active">
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
	
	<h2 align="center"> 影院情况统计  </h2>
	

	
	<div id="container" style="min-width: 200px; max-width:800px;height: 300px; margin: 0 auto"> </div>
	
	<div id="container1" style="min-width: 200px;  max-width:800px;height: 300px; margin: 0 auto"> </div>
	
	<div id="container2" style="min-width: 200px;  max-width:800px;height: 300px; margin: 0 auto"> </div>
	
	<div id="container3" style="min-width: 200px;  max-width:800px;height: 300px; margin: 0 auto"> </div>
	
	<div id="container4" style="min-width: 200px;  max-width:800px;height: 300px; margin: 0 auto"> </div>
	
	</body>	
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	
	<script src="js/highcharts.js"></script>
<script>
$(function () {
	
	 $('#container').highcharts({
	        chart: {
	            type: 'column',
	            backgroundColor:'#333333'
	        },
	        title: {
	            text: '日总人数',
	            style:{color:'#ffffff'}
	        },
	        subtitle: {
	            text: ''
	        },
	        xAxis: {
	            categories: [
	                '${dayList.get(6)}',
	                '${dayList.get(5)}',
	                '${dayList.get(4)}',
	                '${dayList.get(3)}',
	                '${dayList.get(2)}',
	                '${dayList.get(1)}',
	                '${dayList.get(0)}'
	            ],
	            style:{color:'ffffff'}
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '人数(人)'
	            }
	        },
	        tooltip: {
	            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	                '<td style="padding:0"><b>{point.y:.1f} 人</b></td></tr>',
	            footerFormat: '</table>',
	            shared: true,
	            useHTML: true
	        },
	        plotOptions: {
	            column: {
	                pointPadding: 0.2,
	                borderWidth: 0
	            }
	        },
	        series: [{
	            name: '参与人数',
	            data: [${daySum[6]}, ${daySum[5]}, ${daySum[4]}, ${daySum[3]}, ${daySum[2]}, ${daySum[1]}, ${daySum[0]}]

	        }]
	    });
	
    
    
    
	 $('#container1').highcharts({
	        chart: {
	            type: 'column',
	            backgroundColor:'#333333'
	        },
	        title: {
	            text: '月总人数',
	            style:{color:'#ffffff'}
	        },
	        subtitle: {
	            text: ''
	        },
	        xAxis: {
	            categories: [
	               
	                '${monthList.get(5)}',
	                '${monthList.get(4)}',
	                '${monthList.get(3)}',
	                '${monthList.get(2)}',
	                '${monthList.get(1)}',
	                '${monthList.get(0)}'
	            ],
	            style:{color:'ffffff'}
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '人数(人)'
	            }
	        },
	        tooltip: {
	            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	                '<td style="padding:0"><b>{point.y:.1f} 人</b></td></tr>',
	            footerFormat: '</table>',
	            shared: true,
	            useHTML: true
	        },
	        plotOptions: {
	            column: {
	                pointPadding: 0.2,
	                borderWidth: 0
	            }
	        },
	        series: [{
	            name: '参与人数',
	            data: [ ${monthSum[5]}, ${monthSum[4]}, ${monthSum[3]}, ${monthSum[2]}, ${monthSum[1]}, ${monthSum[0]}]

	        }]
	    });
	
    
    
	    $('#container2').highcharts({
	        chart: {
	            type: 'column',
	            backgroundColor:'#333333'
	        },
	        title: {
	            text: '各厅上座率',
	            style:{color:'#ffffff'}
	            
	            
	        },
	        subtitle: {
	            text: ''
	        },
	        xAxis: {
	            categories: [
	     	                '${dayList.get(6)}',
	    	                '${dayList.get(5)}',
	    	                '${dayList.get(4)}',
	    	                '${dayList.get(3)}',
	    	                '${dayList.get(2)}',
	    	                '${dayList.get(1)}',
	    	                '${dayList.get(0)}'
	            ]
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '上座率 %'
	            }
	        },
	        tooltip: {
	            headerFormat: '<span style="font-size:10px">{point.key}</span>',
	            pointFormat: '' +
	                '',
	            footerFormat: '<table><tbody><tr><td style="color:{series.color};padding:0">{series.name}: </td><td style="padding:0"><b>{point.y:.1f} %</b></td></tr></tbody></table>',
	            shared: true,
	            useHTML: true
	        },
	        plotOptions: {
	            column: {
	                pointPadding: 0.2,
	                borderWidth: 0
	            }
	        },
	        series: [{
	            name: '${roomList.get(0).name}',
	            data: [${roomSum[0][6]},${roomSum[0][5]},${roomSum[0][4]},${roomSum[0][3]},${roomSum[0][2]},${roomSum[0][1]},${roomSum[0][0]}]

	        }, {
	            name: '${roomList.get(1).name}',
	            data: [${roomSum[1][6]},${roomSum[1][5]},${roomSum[1][4]},${roomSum[1][3]},${roomSum[1][2]},${roomSum[1][1]},${roomSum[1][0]}]

	        }, {
	            name: '${roomList.get(2).name}',
	            data: [${roomSum[2][6]},${roomSum[2][5]},${roomSum[2][4]},${roomSum[2][3]},${roomSum[2][2]},${roomSum[2][1]},${roomSum[2][0]}]

	        }, {
	            name: '${roomList.get(3).name}',
	            data: [${roomSum[3][6]},${roomSum[3][5]},${roomSum[3][4]},${roomSum[3][3]},${roomSum[3][2]},${roomSum[3][1]},${roomSum[3][0]}]

	        }]
	    });
    
	    $('#container3').highcharts({
	        chart: {
	            type: 'column',
	            backgroundColor:'#333333'
	        },
	        title: {
	            text: '各影片上座率',
	            style:{color:'#ffffff'}
	            
	            
	        },
	        subtitle: {
	            text: ''
	        },
	        xAxis: {
	            categories: [
	     	                '${dayList.get(6)}',
	    	                '${dayList.get(5)}',
	    	                '${dayList.get(4)}',
	    	                '${dayList.get(3)}',
	    	                '${dayList.get(2)}',
	    	                '${dayList.get(1)}',
	    	                '${dayList.get(0)}'
	            ]
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '上座率 %'
	            }
	        },
	        tooltip: {
	            headerFormat: '<span style="font-size:10px">{point.key}</span>',
	            pointFormat: '' +
	                '',
	            footerFormat: '<table><tbody><tr><td style="color:{series.color};padding:0">{series.name}: </td><td style="padding:0"><b>{point.y:.1f} %</b></td></tr></tbody></table>',
	            shared: true,
	            useHTML: true
	        },
	        plotOptions: {
	            column: {
	                pointPadding: 0.2,
	                borderWidth: 0
	            }
	        },
	        series: [{
	            name: '${filmList.get(0).name}',
	            data: [${filmSum[0][6]},${filmSum[0][5]},${filmSum[0][4]},${filmSum[0][3]},${filmSum[0][2]},${filmSum[0][1]},${filmSum[0][0]}]

	        }, {
	            name: '${filmList.get(1).name}',
	            data: [${filmSum[1][6]},${filmSum[1][5]},${filmSum[1][4]},${filmSum[1][3]},${filmSum[1][2]},${filmSum[1][1]},${filmSum[1][0]}]

	        }, {
	            name: '${filmList.get(2).name}',
	            data: [${filmSum[2][6]},${filmSum[2][5]},${filmSum[2][4]},${filmSum[2][3]},${filmSum[2][2]},${filmSum[2][1]},${filmSum[2][0]}]

	        }, {
	            name: '${filmList.get(3).name}',
	            data: [${filmSum[3][6]},${filmSum[3][5]},${filmSum[3][4]},${filmSum[3][3]},${filmSum[3][2]},${filmSum[3][1]},${filmSum[3][0]}]

	        }]
	    });
    
    $('#container4').highcharts({
        chart: {
            
          	backgroundColor: '#333333',
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '现金/卡购票情况',
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
                ['现金',   ${	purchaseWaySum[0]} ],
                ['卡',   ${purchaseWaySum[1]} ],

            ]
        }]
    });
    
    
    $('#container9').highcharts({
        chart: {
            type: 'column',
            backgroundColor:'#333333'
        },
        title: {
            text: '参与活动统计',
            style:{color:'ffffff'}
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: [
                '活动1',
                '活动2',
                '活动3'
            ],
            style:{color:'ffffff'}
        },
        yAxis: {
            min: 0,
            title: {
                text: '参与人数(人)'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} 人</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: '参与人数',
            data: [${eventSum[0]}, ${eventSum[1]}, ${eventSum[2]}]

        }]
    });
    
    
    $('#container5').highcharts({
        chart: {
            
          	backgroundColor: '#333333',
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '卡有效/无效情况',
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
                ['有效',   ${activateSum[0]} ],
                ['无效',   ${activateSum[1]}]

            ]
        }]
    });
    
    
    
    
    
});				
	</script>

</html>