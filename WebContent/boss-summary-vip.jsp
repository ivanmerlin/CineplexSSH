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
	
<li ><a href="typestatistics.action"> &nbsp &nbsp 决策支持 &nbsp &nbsp  <span class="sr-only">(current)</span></a></li>
				<li  ><a href="changeratio.action"> &nbsp &nbsp 会员策略 &nbsp &nbsp  <span class="sr-only">(current)</span></a></li>
									<li class="dropdown active">
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
	
	<h2 align="center"> 会员情况统计  </h2>
	

	
	<div id="container" style="min-width: 200px; height: 300px; margin: 0 auto"> </div>
	

	
	<div id="container1" style="min-width: 200px; height: 300px; margin: 0 auto"> </div>


	
	<div id="container2" style="min-width: 200px; height: 300px; margin: 0 auto"> </div>
	

	
	<div id="container3" style="min-width: 200px; height: 300px; margin: 0 auto"> </div>
	
		
	<div id="container4" style="min-width: 200px; max-width:600px;height: 300px; margin: 0 auto"> </div>
	
	<div id="container5" style="min-width: 200px; max-width:600px;height: 300px; margin: 0 auto"> </div>
	
	
	
	
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
            text: '会员年龄百分比图',
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
                ['20岁以下',   ${ageSum[0]} ],
                ['20~30',      ${ageSum[1]}],
                
                ['30`40',  ${ageSum[2]}],
                ['40~50',     ${ageSum[3]}],
                ['50以上', ${ageSum[4]}]
            ]
        }]
    });
    
    
    $('#container1').highcharts({
        chart: {
            
          	backgroundColor: '#333333',
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '会员性别百分比图',
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
                ['男',   ${genderSum[0]} ],
                ['女',   ${genderSum[1]} ]

            ]
        }]
    });
    
    
    
    $('#container2').highcharts({
        chart: {
            
          	backgroundColor: '#333333',
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '会员城市百分比图',
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
                ['北京',   ${citySum[0]} ],
                ['上海',   ${citySum[1]} ],
                ['南京',   ${citySum[2]} ]
            ]
        }]
    });
    
    
    
    $('#container3').highcharts({
        chart: {
            
          	backgroundColor: '#333333',
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '会员消费统计图',
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
                ['超能陆战队',   ${	costSum[0]} ],
                ['指环王',   ${costSum[1]} ],
                ['木星上行',   ${costSum[2]} ],
                ['王牌特工',   ${costSum[3]} ]
            ]
        }]
    });
    
    
    $('#container4').highcharts({
        chart: {
            type: 'column',
            backgroundColor:'#333333'
        },
        title: {
            text: '参与活动统计',
            style:{color: '#ffffff'}	
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