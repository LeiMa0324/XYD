<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<link href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/jquery-ui-1.10.4.custom.min.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/xyd.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/header.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/MyShop.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/cj/ShopInfoChange.css" type="text/css" rel="stylesheet">

<script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/xyd.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/ajaxfileupload.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-jqLoding.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/cj/ShopInfoChange.js" type="text/javascript"></script>


<title>商户信息修改</title>

</head>
<body>
	<jsp:include page="header.jsp" />

		<div class="container-fluid">
	<div class="row-fluid">
		<div class="span1">
		</div>
		<div class="span2">
			<ul class="nav nav-list well">
				<li class="nav-header" id="MyShop">
					我的店铺
				</li>
				<li >
					<a class="mybadge myactive" href="#">我的订单</a>
					 <span class="badge" id="badge_num">0</span>
				</li>
				<li>
					<a href="#">数据统计</a>
				</li>
				<li>
					<a href="#">维护商品</a>
				</li>
				<li>
					<a href="#">店铺信息</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/MyShop_employer.jsp">员工管理</a>
				</li>
				<li>
					<a href="#">物品管理</a>
				</li>
			</ul>
		</div>
		<div class="span1">
		</div>
			<div class="span7">
				<h3 id="MyOrder">
					<span class="ng-binding">店铺信息</span> <img alt="186x55"
						id="searchbox_img" src="css/images/MyShop_searchboxboy.png" />
				</h3>
				<div>
				<table>
				<tr>
				<td rowspan="4">
				<img src="PicDownloadServlet?file_name=123456.gif" class="img-polaroid" id="testimg"  height="350" width="350" />
				</td>
				<td style="text-align:right"><span style="color:#C00">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp*</span>账号：<input id="account" placeholder="" disabled="disabled" type="text"></td>
				</tr>
				
				<tr>
				<td style="text-align:right"><span style="color:#C00">*</span>店名：<input id="name" placeholder="请填写店名" type="text"></td>
				</tr>
		
				<tr>
				<td style="text-align:right"><span style="color:#C00">*</span>电话：<input id="phone" placeholder="请输入联系电话" type="text"></td>
				</tr>
				<tr></tr>
				<tr>
						<td ><a class="btn_addPic"><span><em>+</em>添加图片</span>
					  						<input type="file" tabindex="3" title="支持jpg、jpeg、gif、png格式，文件小于5M" size="3" class="filePrew" name="picPath"  id="picPath" onchange="(checkPic())">
					  					</a></td>
					  					
				</tr>
				
			
				</table>
				</div>
				<div class="span7">
				<div class ="row">
				<div class="span2"></div>
				<div class="span5">
	<br><br>
<textarea  name="yj" class="cjcontentInput" placeholder ="请填写商家信息"  id="desc" ></textarea>
</div>
				</div>
				</div>

<button style="margin-left:60% ; margin-top:30px" class="btn" type="button" onclick="(btnOK_click())">确认修改</button>
</div>
</div>
<jsp:include page="foot.jsp" />
</div>
</body>
					
</html>