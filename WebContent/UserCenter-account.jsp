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
<link href="${pageContext.request.contextPath}/css/jquery-labelauty.css" type="text/css" rel="stylesheet" />

<script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/xyd.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-jqLoding.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/user_balance.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-labelauty.js" type="text/javascript"></script>




<title>个人中心-账户充值</title>

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
					<h3 id="MyCharge">
						<span  class="ng-binding">我的账户</span>
					     <img alt="186x55" id="searchbox_img" src="css/images/MyShop_searchboxboy.jpg" />
					</h3>
				</div>
				<div class="span12">
						<span style="font-size:20px">账户余额:  ￥</span>
						<span id="accountmoney_span_con" style="font-size:19px;font-color:blue"></span>
						<hr/>
				</div>

			</div>
			<div class="row-fluid">
				<div class="span12">					
					<h3>
						充值：
					</h3>

					<div class="row-fluid">
						<div class="span1"></div>
						<div class="span10">
							<ul class="dowebok">
								<li><input class="chargeinput" type="radio" name="money_radio" data-labelauty="充值 100元" value="100"></li>
								<li><input class="chargeinput" type="radio" name="money_radio" data-labelauty="充值 200元" value="200"></li>
								<li><input class="chargeinput" type="radio" name="money_radio" data-labelauty="充值 500元" value="500"></li>
							</ul>
							<ul class="dowebok">
								<li><input class="chargeinput" type="radio" name="money_radio" data-labelauty="充值1000元" value="1000"></li>
								<li><input class="chargeinput" type="radio" name="money_radio" data-labelauty="充值1500元" value="1500"></li>
								<li><input class="chargeinput" type="radio" name="money_radio" data-labelauty="充值2500元" value="2000"></li>
							</ul>
						</div>
						<div class="span1"></div>
					</div>
					<br>
					<hr/>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<div class="span12">
							<h3>
								充值方式：
							</h3>
							<br>
							<br>													
						</div>
						<div class="row-fluid">
							<div class="span2">
							</div>
							<div class="span10">
								 <p style="font-size:23px;"><input type="radio" name="yifubao" />  易付宝支付</p>							 
							</div>
						</div>
					</div>
					<br>
					<hr/>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span5">
				</div>
				<div class="span2">
					 <button id="confirmCharge" class="btn" type="button" >确认充值</button>
				</div>
				<div class="span5">
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