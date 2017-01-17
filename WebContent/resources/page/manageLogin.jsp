<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/manageLogin.css" style="text/css" rel="stylesheet"/>
<link rel = "Shortcut Icon" href="../image/shopping.ico">
<script type="text/javascript" src="../js/jquery.min.js" language="javascript"></script>
<script type="text/javascript" src="../js/common.js" language="javascript"></script>
<script type="text/javascript" src="../js/manageLogin.js" language="javascript"></script>
<title>管理员登录</title>
</head>
<body>
	<div id="login">
		<form id="loginForm" action="">
			<div class="namePass" id="loginName">
				<input type="text" name="loginName" onfocus="focusInput(1)" onblur="blurInput(1)"/>
			</div>
			<div class="namePass" id="loginPass">
				<input type="password" name="loginPass" onfocus="focusInput(2)" onblur="blurInput(2)"/>
			</div>
		</form>
		<div id="btn" onclick="loginIn()">登录</div>
		<div id="err"></div>
	</div>
</body>
</html>