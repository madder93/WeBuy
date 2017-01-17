$(function(){
	$("#wrapper").fadeIn("slow", function(){
		getCategory();
		getDatasFirst(0);
	});

	$(window).scroll(function(){
		var scrollTop = $(document).scrollTop().toFixed(1); //获取匹配元素相对滚动条顶部的偏移
		var pageHeight = $(document).height();    //获取整个页面的高度
		var windowHeight = $(window).height();    //获取当前也就是浏览器所能看到的页面的那部分的高度。这个大小在你缩放浏览器窗口大小时会改变，与document是不一样的
		var type = $("#searchTypeVaue").val();
		if(scrollTop >= (pageHeight - windowHeight)){
			var showDataNum = $("#searchDataNum").val();
			var totalNum = $("#totalDataNum").val();
			if(parseInt(showDataNum) < parseInt(totalNum)){
				getDatas(type);
			}
		}
	});
});

function gotoProduct(url){
	window.open(url);
}

function getDatasFirst(type){
	$("#center").html("");
	$("#searchDataNum").val(0);
	$("#searchTypeVaue").val(type);
	$("#totalDataNum").val(0);
	countProducts(type);
	getDatas(type);
}

function getDatas(type){
	var showDataNum = $("#searchDataNum").val();
	$.ajax({
		url:ctx+'/product/getAllProducts.do',
		data:{type:type, showDataNum:showDataNum},
		type:'post',
		dataType:'json',
		success:function(data){
			if(data){
				var products = "";
				for(var i = 0; i < data.length; i++){
					products += '<div class="product">';
					products += '	<div class="productImg" onclick="gotoProduct(\'' + data[i].url + '\')">';
					products += '		<img src=""/>';
					products += '	</div>';
					products += '	<div class="productName">';
					products += '		<a href="javascript:gotoProduct(\'' + data[i].url + '\')">';
					products += '			' + data[i].name + '';
					if(data[i].keyword != null && data[i].keyword != undefined && data[i].keyword != ""){
					products += '			<span class="keyword">(' + data[i].keyword + ')</span>';
					}
					products += '		</a>';
					products += '	</div>';
					products += '	<div class="productPrice">';
					products += '		<b>￥' + data[i].price.toFixed(2) + '</b>';
					products += '	</div>';
					products += '</div>';
				}
				if(data.length == 0){
					//products += "暂无此类商品";
				}
				$("#center").append(products);
				$("#searchDataNum").val(parseInt(showDataNum) + parseInt(data.length));
			}
		}
	});
}

function getCategory(){
	$("#searchType").html("");
	$.ajax({
		url:ctx + '/category/getAllCategory.do',
		data:{type:1},
		type:'post',
		dataType:'json',
		success:function(data){
			if(data){
				var category = "<li onclick='getDatasFirst(0)'>全部</li>";
				for(var i = 0; i < data.length; i++){
					category += "<li onclick='getDatasFirst(" + data[i].id + ")'>" + data[i].name + "</li>";
				}
				if(data.length == 0){
					category += "暂无分类";
				}
				$("#searchType").append(category);
			}
		}
	});
}


function countProducts(type){
	$.ajax({
		url:ctx + '/product/countProducts.do',
		data:{type:type},
		type:'post',
		dataType:'json',
		success:function(data){
			if(data){
				$("#totalDataNum").val(data);
			}
		}
	});
}