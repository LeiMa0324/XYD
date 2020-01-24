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
<link href="${pageContext.request.contextPath}/css/user-address.css" type="text/css" rel="stylesheet" />

<script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/xyd.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-jqLoding.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/user-address.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/TestAddress.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/TestChooseAddress.js" type="text/javascript"></script>


<title>个人中心-收货地址</title>

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
					<div class="span12">
						<h3 id="MyAddress">
							<span  class="ng-binding">收货地址</span>
							<button type="button" id="add_new_addr_btn" class="btn btn-default ">新建地址</button>							
						    <img alt="186x55" id="searchbox_img" src="css/images/MyShop_searchboxboy.jpg" />
						</h3>
					</div>
				</div>
				<div class="row-fluid">
					<table class="table">
						<thead id="tableheader">
							<tr>
								<th>
									收货人
								</th>
								<th>
									所在地区
								</th>
								<th>
									详细地址
								</th>
								<th>
									电话
								</th>
								<th>
									操作
								</th>
								<th>
									设为默认
								</th>
							</tr>
						</thead>
						<tbody id="tablebody">
														
						</tbody>
					</table>
				
				</div>
								
			</div>
			<div class="span1">
			</div>
		</div>
	</div>
	
<jsp:include page="foot.jsp" />

</body>
</html>