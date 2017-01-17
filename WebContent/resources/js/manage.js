$(function(){
	getMenu();
});

function getMenu(){
	$("#menu").html("");
	$.ajax({
		url:ctx + '/category/getAllCategory.do',
		data:{type:2},
		type:'post',
		dataType:'json',
		success:function(data){
			if(data){
				var category = "";
				for(var i = 0; i < data.length; i++){
					var url = data[i].url==null?"":data[i].url;
					category += "<li onclick='changeIframe(\"" + url + "\")'>" + data[i].name + "</li>";
				}
				if(data.length == 0){
					category += "<li onclick='manageHome.jsp'>首页</li>";
					category += "<li onclick='manageMenu.jsp'>菜单管理</li>";
				}
				$("#menu").append(category);
			}
		}
	});
}

function changeIframe(url){
	$("#centerIframe").attr("src", url);
}