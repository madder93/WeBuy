<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品管理</title>
<link href="../bootstrap/css/bootstrap.min.css" style="text/css" rel="stylesheet" />
<link href="../bootstrap/css/bootstrap-table.css" style="text/css" rel="stylesheet" />
<link href="../css/manageProducts.css" style="text/css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/bootstrap-table.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/manageProducts.js"></script>
</head>
<body>
	<div id="wrapper">
		<div id="toolBtns">
			<div id="tool">
				<span class="btn">新增</span>
				<span class="btn">删除</span>
			</div>
			<div id="search">
			
			</div>
		</div>
		<div id="productShow">
			<table id="productsList" data-toggle="table" data-url="/WeBuy/product/getAllProductsByPage.do" data-pagination="true">
				<thead>
					<tr>
						<th data-field="id" data-checkbox="true"></th>
						<th data-field="name" data-width="300">商品名称</th>
						<th data-field="price" data-align="center" data-width="80" data-formatter="formatePrice">商品价格</th>
						<th data-field="typeName" data-align="center" data-width="80">商品分类</th>
						<th data-field="keyword" data-width="300">商品关键字</th>
						<th data-field="status" data-align="center" data-width="80" data-formatter="formateStatus">是否失效</th>
						<th data-field="urls" data-align="center" data-width="150" data-formatter="formateUrls">商品链接</th>
						<th data-field="oper" data-align="center" data-width="80" data-formatter="formateOper">操作</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</body>
</html>