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
<link href="css/vip-purchase-detail-style.css" rel="stylesheet">
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


				<li class="dropdown">
				  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">会员相关 <span class="caret"></span></a>
				  <ul class="dropdown-menu" role="menu">
					<li><a href="vipQualify.action">会员资格</a></li>
					<li><a href="vipInfo.action">会员卡信息</a></li>
                    <li><a href="orderInfo.action">订单查询</a></li>
				  </ul>
				</li>
				<li class="active"><a href="purchaseTicket.action"> &nbsp &nbsp 观影购票 &nbsp &nbsp  <span class="sr-only">(current)</span></a></li>
				<li><a href="vipEvent.action"> &nbsp &nbsp 参加活动 &nbsp &nbsp </a></li>
				<li><a href="vipRecommend.action"> &nbsp &nbsp 影片推荐 &nbsp &nbsp </a></li>
				<li><a href="memLogout.action">&nbsp &nbsp 注销 </a></li>						
				

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<h3 align="center" style="margin-top:100px">欢迎您, ${user.username} !这里是购买详细页面</h3>


	<table class=" table planWrapper center-block">
		<tr>
			<td style="width:100px">${filmPlan.id}</td>
			<td style="width:210px">${filmPlan.filmName}</td>
			<td style="width:300px">${filmPlan.getStringTime()}</td>
			<td style="width:100px">${filmPlan.getRoomName()}</td>
			<td style="width:120px">${filmPlan.price}</td>
		</tr>
	</table>
	<h4 align="center" style="margin-top:60px">请选择座位</h4>
	
	
<div class="modal-body select-seat">
			<p>&emsp;银幕</p>
				<p>1&emsp;<a id="seats11" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats11')" data-row="1" data-column="1" title="1排1座" seatchecked="false"></a>
					<a id="seats12" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats12')" data-row="1" data-column="2" title="1排2座" seatchecked="false"></a>
					<a id="seats13" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats13')" data-row="1" data-column="3" title="1排3座" seatchecked="false"></a>
					<a id="seats14" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats14')" data-row="1" data-column="4" title="1排4座" seatchecked="false"></a>
					<a id="seats15" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats15')" data-row="1" data-column="5" title="1排5座" seatchecked="false"></a>
					<a id="seats16" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats16')" data-row="1" data-column="6" title="1排6座" seatchecked="false"></a>
					<a id="seats17" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats17')" data-row="1" data-column="7" title="1排7座" seatchecked="false"></a>
					<a id="seats18" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats18')" data-row="1" data-column="8" title="1排8座" seatchecked="false"></a>
					<a id="seats19" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats19')" data-row="1" data-column="9" title="1排9座" seatchecked="false"></a>
					<a id="seats10" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats10')" data-row="1" data-column="10" title="1排10座" seatchecked="false"></a>
				</p>
					<p>2&emsp;<a id="seats21" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats21')" data-row="2" data-column="1" title="2排1座" seatchecked="false"></a>
					<a id="seats22" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats22')" data-row="2" data-column="2" title="2排2座" seatchecked="false"></a>
					<a id="seats23" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats23')" data-row="2" data-column="3" title="2排3座" seatchecked="false"></a>
					<a id="seats24" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats24')" data-row="2" data-column="4" title="2排4座" seatchecked="false"></a>
					<a id="seats25" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats25')" data-row="2" data-column="5" title="2排5座" seatchecked="false"></a>
					<a id="seats26" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats26')" data-row="2" data-column="6" title="2排6座" seatchecked="false"></a>
					<a id="seats27" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats27')" data-row="2" data-column="7" title="2排7座" seatchecked="false"></a>
					<a id="seats28" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats28')" data-row="2" data-column="8" title="2排8座" seatchecked="false"></a>
					<a id="seats29" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats29')" data-row="2" data-column="9" title="2排9座" seatchecked="false"></a>
					<a id="seats20" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats20')" data-row="2" data-column="10" title="2排10座" seatchecked="false"></a>
				</p>
				<p>3&emsp;<a id="seats31" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats31')" data-row="3" data-column="1" title="3排1座" seatchecked="false"></a>
					<a id="seats32" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats32')" data-row="3" data-column="2" title="3排2座" seatchecked="false"></a>
					<a id="seats33" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats33')" data-row="3" data-column="3" title="3排3座" seatchecked="false"></a>
					<a id="seats34" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats34')" data-row="3" data-column="4" title="3排4座" seatchecked="false"></a>
					<a id="seats35" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats35')" data-row="3" data-column="5" title="3排5座" seatchecked="false"></a>
					<a id="seats36" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats36')" data-row="3" data-column="6" title="3排6座" seatchecked="false"></a>
					<a id="seats37" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats37')" data-row="3" data-column="7" title="3排7座" seatchecked="false"></a>
					<a id="seats38" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats38')" data-row="3" data-column="8" title="3排8座" seatchecked="false"></a>
					<a id="seats39" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats39')" data-row="3" data-column="9" title="3排9座" seatchecked="false"></a>
					<a id="seats30" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats30')" data-row="3" data-column="10" title="3排10座" seatchecked="false"></a>
				</p>
				<p>4&emsp;<a id="seats41" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats41')" data-row="4" data-column="1" title="4排1座" seatchecked="false"></a>
					<a id="seats42" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats42')" data-row="4" data-column="2" title="4排2座" seatchecked="false"></a>
					<a id="seats43" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats43')" data-row="4" data-column="3" title="4排3座" seatchecked="false"></a>
					<a id="seats44" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats44')" data-row="4" data-column="4" title="4排4座" seatchecked="false"></a>
					<a id="seats45" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats45')" data-row="4" data-column="5" title="4排5座" seatchecked="false"></a>
					<a id="seats46" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats46')" data-row="4" data-column="6" title="4排6座" seatchecked="false"></a>
					<a id="seats47" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats47')" data-row="4" data-column="7" title="4排7座" seatchecked="false"></a>
					<a id="seats48" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats48')" data-row="4" data-column="8" title="4排8座" seatchecked="false"></a>
					<a id="seats49" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats49')" data-row="4" data-column="9" title="4排9座" seatchecked="false"></a>
					<a id="seats40" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats40')" data-row="4" data-column="10" title="4排10座" seatchecked="false"></a>
				</p>
				<p>5&emsp;<a id="seats51" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats51')" data-row="5" data-column="1" title="5排1座" seatchecked="false"></a>
					<a id="seats52" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats52')" data-row="5" data-column="2" title="5排2座" seatchecked="false"></a>
					<a id="seats53" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats53')" data-row="5" data-column="3" title="5排3座" seatchecked="false"></a>
					<a id="seats54" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats54')" data-row="5" data-column="4" title="5排4座" seatchecked="false"></a>
					<a id="seats55" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats55')" data-row="5" data-column="5" title="5排5座" seatchecked="false"></a>
					<a id="seats56" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats56')" data-row="5" data-column="6" title="5排6座" seatchecked="false"></a>
					<a id="seats57" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats57')" data-row="5" data-column="7" title="5排7座" seatchecked="false"></a>
					<a id="seats58" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats58')" data-row="5" data-column="8" title="5排8座" seatchecked="false"></a>
					<a id="seats59" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats59')" data-row="5" data-column="9" title="5排9座" seatchecked="false"></a>
					<a id="seats50" href="javascript:;" hidefocus="true" class="seat active" onclick="seatclick('seats50')" data-row="5" data-column="10" title="5排10座" seatchecked="false"></a>
				</p>
			</div>


<button class="center-block button" onclick="post_seat()">确定</button>

</body>
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	$.post("get_unavailable_seat.action",{}, seatcallback, "json");
});
function seatcallback(data) {
	 $.each(data.seatresult, function(i, item) {
		 $("a[data-row='"+item.row+"'][data-column='"+item.col+"']").attr({"class":"seat seatdisable","onclick":"","seatchecked":"none"});
		 $("a[data-row='"+item.row+"'][data-column='"+item.col+"']").css("background-position","-52px 0");
    });
}
function seatclick(id){
	if($("#"+id).attr("seatchecked")=="false"){
	$("#"+id).css("background-position","-77px 0");
	$("#"+id).attr("seatchecked","checked");
	}else if($("#"+id).attr("seatchecked")=="none"){
		
	}else{
		$("#"+id).css("background-position","-27px 0");
		$("#"+id).attr("seatchecked","false");
	}
}
function post_seat(){
	var $aa=$("a[seatchecked='checked']");
	if($aa.length>0)
	{
		$.post("select_seat.action",{'row':$aa.eq(0).attr('data-row'),'col':$aa.eq(0).attr("data-column"),'index':0}, selectcallback, "json");
	}
	
}
function selectcallback(data){
	var $aa=$("a[seatchecked='checked']");
	if($aa.length>data.index+1)
	{
		$.post("select_seat.action",{'row':$aa.eq(data.index+1).attr('data-row'),'col':$aa.eq(data.index+1).attr("data-column"),'index':data.index+1}, selectcallback, "json");
	}else{
		location.replace("purchaseDetail.action?num="+$aa.length);
	}
}
</script>

</html>