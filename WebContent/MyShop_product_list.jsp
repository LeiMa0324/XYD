<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.seu.xyd.servlet.UIUtil"%>
<%@page import="com.seu.xyd.servlet.XYDWebParam"%>
<%@page import="com.seu.xyd.logic.ShopLogic"%>
<%@page import="com.seu.xyd.data.Goods"%>

<!DOCTYPE html>


<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	type="text/css" rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/css/bootstrap-responsive.css"
	type="text/css" rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/css/jquery-ui-1.10.4.custom.min.css"
	type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/xyd.css"
	type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/header.css"
	type="text/css" rel="stylesheet" />
	
<link href="${pageContext.request.contextPath}/css//MyShop_employer.css"
	type="text/css" rel="stylesheet" />

<link href="${pageContext.request.contextPath}/css/cj/MyShop_product_list.css"
	type="text/css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>

<script
	src="${pageContext.request.contextPath}/js/jquery-ui-jqLoding.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/cj/MyShop_product_list.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/xyd.js"
	type="text/javascript"></script>
	
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cj/tasp.css" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/cj/orderconfirm.css" rel="stylesheet" type="text/css"/>
<title>维护商品</title>
<style>
.table td
{
border-top:0px;

}

</style>
</head>
<body>
<input type="hidden" id="pagenum" value="1">
	<jsp:include page="header.jsp" />

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span1"></div>
			<div class="span2">
				<ul class="nav nav-list well">
					<li class="nav-header" id="MyShop">我的店铺</li>
					<li><a class="mybadge"
						href="${pageContext.request.contextPath}/MyShop.jsp">我的订单</a> <span
						class="badge">1</span></li>
					<li><a href="#">数据统计</a></li>
					<li><a class="myactive" href="#">维护商品</a></li>
					<li><a href="#">店铺信息</a></li>
					<li><a  href="#">员工管理</a></li>
					<li><a  href="#">物品管理</a></li>
				</ul>
			</div>
			<div class="span8">
				<h3 id="MyOrder">
					<span class="ng-binding">维护商品</span> <img alt="186x55"
						id="searchbox_img" src="css/images/MyShop_searchboxboy.jpg" />
				</h3>

				<div class="row-fluid">
				 <button class="btn" style="float: right" type="button" onclick="addGoodPressed()">添加商品</button>
				  <button class="btn" style="float: right" type="button" onclick="(deleteButtonPressed())">删除选中</button>

				</div>
				<table class="table">
					<tbody>
						<tr id="trfirst">
				
						</tr>

						<tr id="trSecond">

						</tr>
					</tbody>
				</table>
				<div class="pagination pagination-right">
					<ul id="pageID">
					
					</ul>
				</div>
			</div>
			<div class="span1"></div>
		</div>
	</div>

	<jsp:include page="foot.jsp" />
</body>
</html>