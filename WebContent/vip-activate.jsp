<%@ page contentType="text/html;charset=utf-8"%> 
<!DOCTYPE html>
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<head>
	<link href="css/vip-activate-style.css" rel="stylesheet">
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
	

				<li class="dropdown active">
				  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">会员相关 <span class="caret"></span></a>
				  <ul class="dropdown-menu" role="menu">
				<li><a href="vipQualify.action">会员资格</a></li>
					<li><a href="vipInfo.action">会员卡信息</a></li>
                    <li><a href="orderInfo.action">订单查询</a></li>
				  </ul>
				</li>
				<li ><a href="purchaseTicket.action"> &nbsp &nbsp 观影购票 &nbsp &nbsp  <span class="sr-only">(current)</span></a></li>
				<li><a href="vipEvent.action"> &nbsp &nbsp 参加活动 &nbsp &nbsp </a></li>
				<li><a href="vipRecommend.action"> &nbsp &nbsp 影片推荐 &nbsp &nbsp </a></li>
				<li><a href="memLogout.action">&nbsp &nbsp 注销 </a></li>			
					
				
				
			  </ul>
			</div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
	
	
		<h2 align="center" class="reminder">请激活您的会员卡！</h2>
		<h3 align="center">输入银行卡号一次充值200以上完成激活</h3>
	<div class ="bankInfo"  >

		<form id="bankInfoForm" method="post" class="fc" action="memberQualify.action">
			<input type="username" name="bankId" id="bankId" class="form-control fc-input" placeholder="Enter Bank Id">
			<input type="hidden" name="type" value="signup" /> 
		<a href="#" class="button" data="signup" onclick="document.getElementById('bankInfoForm').submit();">提交</a>
		</form>


	</div>
	
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	</body>
</html>