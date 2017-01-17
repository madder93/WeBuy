function focusInput(type){
	var id = "";
	if(type == 1){
		id = "loginName";
	}else{
		id = "loginPass";
	}
	if(id != ""){
		$("#" + id).css("background-position","0px -45px"); 
	}
}

function blurInput(type){
	var id = "";
	if(type == 1){
		id = "loginName";
	}else{
		id = "loginPass";
	}
	if(id != ""){
		$("#" + id).css("background-position","0px 0px"); 
	}
}

function loginIn(){
	var name = $("#loginForm input[name='loginName']").val();
	var pass = $("#loginForm input[name='loginPass']").val();
	//后台返回string，dataType要用text
	$.ajax({
		url:ctx + '/manager/login.do',
		data:{username:name,password:pass},
		type:'post',
		dataType:'text',
		success:function(data){
			if(data == "success"){
				$("#err").html("登录成功！");
				window.location.href = ctx + "/resources/page/manage.jsp";
			}else if(data == "nameFail"){
				$("#err").html("登录失败！用户名不存在！");
			}else if(data == "passFail"){
				$("#err").html("登录失败！密码错误！");
			}else{
				$("#err").html("登录失败！");
			}
		}
	});
}