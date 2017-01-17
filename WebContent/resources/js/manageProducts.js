function formatePrice(value, row){
	return value==null?0.00:value.toFixed(2);
}

function formateStatus(value, row){
	if(value == 0){
		return "失效";
	}else{
		return "有效";
	}
}

function formateUrls(value, row){
	return "<span class='urlSpan'>短链接</span>" + 
		"&nbsp;&nbsp;&nbsp;&nbsp;" +
		"<span class='urlSpan'>淘口令</span>";
}

function formateOper(value, row){
	return "<span>修改</span>" + 
	"&nbsp;&nbsp;" +
	"<span>删除</span>";
}