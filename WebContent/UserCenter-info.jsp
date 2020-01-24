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
<link href="${pageContext.request.contextPath}/css/MyShop.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/UserCenter-account.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/header.css" type="text/css" rel="stylesheet" />

<script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/xyd.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-jqLoding.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/modify-userinfo.js" type="text/javascript"></script>


<title>个人中心-个人信息</title>

</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="container-fluid">
	<div class="row-fluid">
		<div class="span1">
		</div>
		<div class="span2">
			<ul class="nav nav-list well">
				<li class="nav-header" id="UserCenter">
					用户中心
				</li>
				<li >
					<a class="mybadge myactive" href="UserCenter-order.jsp">我的订单</a>
				</li>
				<li>
					<a href="UserCenter-account.jsp">会员充值</a>
				</li>
				<li>
					<a href="UserCenter-chargehistory.jsp">充值记录</a>
				</li>
				<li>
					<a href="UserCenter-info.jsp">个人信息</a>
				</li>
				<li>
					<a href="UserCenter-changepwd.jsp">修改密码</a>
				</li>
				<li>
					<a href="UserCenter-address.jsp">收货地址</a>
				</li>
				<li>
					<a href="UserCenter-shopcart.jsp">我的购物车</a>
				</li>
			</ul>
		</div>
		<div class="span8">
			<div class="row-fluid">
				<h3 id="MyInfo">
				<span  class="ng-binding">个人信息</span>
				     <img alt="186x55" id="searchbox_img" src="css/images/MyShop_searchboxboy.jpg" />
				</h3>
				<br>
				<hr>
				<div class="row-fluid">
				<div class="form-horizontal">
					
					<div class="span12" >


						<div class="control-group">
							<label class="control-label" for="inputEmail" contenteditable="false">邮箱</label>						
							<div class="controls">
								<input id="email_conf" value="" type="text" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="inputTel" contenteditable="false">手机号</label>
							<div class="controls">
								<input id="phone_conf" value="" type="text" />
							</div>
						</div>
						<br>	
						<div class="control-group">
                   			 <div class="controls">
							<button id="modifyinfo_btn" class="btn " >确认修改</button>
							</div>
						</div>

					</div>		
								
				</div>	
				</div>
			</div>
		</div>
		<div class="span1">
		</div>
	</div>
</div>

<jsp:include page="foot.jsp" />

</body>
</html>