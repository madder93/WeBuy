<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/index.css" style="text/css" rel="stylesheet"/>
<link rel = "Shortcut Icon" href="resources/image/shopping.ico">
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/common.js"></script>
<title>欢迎光临</title>
<script type="text/javascript">
	$(function(){
		setTimeout(function(){window.location.href = ctx + "/resources/page/home.jsp";}, 5000);
	});
	
	function gotoHome(){
		$("#index").fadeOut("slow", function(){
			window.location.href = ctx + "/resources/page/home.jsp";
		});
	}
</script>
</head>
<body>
	<div id="index" onclick="gotoHome()">
		
	</div>
</body>
</html>