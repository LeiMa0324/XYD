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
<link href="${pageContext.request.contextPath}/css/header.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/shopcart.css" type="text/css" rel="stylesheet" />

<script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/xyd.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-jqLoding.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/shopcart.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.cookie.js" type="text/javascript"></script>


<title>个人中心</title>

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
			<h3 id="MyShopCart">
			<span  class="ng-binding">我的购物车</span>
			     <img alt="186x55" id="searchbox_img" src="css/images/MyShop_searchboxboy.jpg" />			     
			</h3>
			<hr>
			<div id="shop_list_container" >
			
			<!-- <div class="row-fluid">
				<div class="catbox">
				  <table id="cartTable">
				    <thead>
				      <tr>
				        <th>
				        	<label><input class="check-all check" type="checkbox"/>&nbsp;&nbsp;全选</label>
				        </th>
				        <th>haha干洗店</th>
				        <th>单价</th>
				        <th>数量</th>
				        <th>小计</th>
				        <th>操作</th>
				      </tr>
				    </thead>
				    <tbody>
				      <tr>
				        <td class="checkbox"><input class="check-one check" type="checkbox"/></td>
				        <td class="goods"><img src="img/xiku.jpg" alt=""/><span>西裤</span></td>
				        <td class="price">12</td>
				        <td class="count">
				        	<span class="reduce"></span>
				        	<input class="count-input" type="text" value="1"/>
				         	<span class="add">+</span></td>
				        <td class="subtotal">12</td>
				        <td class="operation"><span class="delete">删除</span></td>
				      </tr>
				      <tr>
				        <td class="checkbox"><input class="check-one check" type="checkbox"/></td>
				        <td class="goods"><img src="img/xiuxianku.jpg" alt=""/><span>休闲裤</span></td>
				        <td class="price">12</td>
				        <td class="count">
				       		 <span class="reduce"></span>
				         	 <input class="count-input" type="text" value="1"/>
				         	 <span class="add">+</span></td>
				        <td class="subtotal">12</td>
				        <td class="operation"><span class="delete">删除</span></td>
				      </tr>

				    </tbody>
				  </table>
				  <div class="foot" id="foot">
				    <label class="fl select-all"><input type="checkbox" class="check-all check"/>&nbsp;&nbsp;全选</label>
				    <a class="fl delete" id="deleteAll" href="javascript:;">删除</a>
				    <div class="fr closing" onclick="getTotal();">结 算</div>
				    <input type="hidden" id="cartTotalPrice" />
				    <div class="fr total">合计：￥<span id="priceTotal">0.00</span></div>
				    <div class="fr selected" id="selected">已选商品<span id="selectedTotal">0</span>件<span class="arrow up">︽</span><span class="arrow down">︾</span></div>
				    <div class="selected-view">
				      <div id="selectedViewList" class="clearfix">
				        <div><img src="images/1.jpg"><span>取消选择</span></div>
				      </div>
				      <span class="arrow">◆<span>◆</span></span> </div>
				  </div>
				</div>
			
			</div> -->
			</div>
		</div>
		<div class="span1">
		</div>
	</div>
</div>

<jsp:include page="foot.jsp" />

</body>
</html>