<%@ page contentType="text/html;charset=utf-8"%> 
<!DOCTYPE html>
<html>
<head>
	<title>abc</title>
</head>
<body>
	下面是显示的内容：
	<br>
	<% session.getAttribute("mystring"); %>
	<br>**************<br/>
	${sessionScope.mystring }
	${another}
</body>
</html>