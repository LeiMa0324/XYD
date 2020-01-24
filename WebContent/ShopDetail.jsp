<!DOCTYPE html>
<%@page import="com.seu.xyd.servlet.UIUtil"%>
<%@page import="com.seu.xyd.servlet.XYDWebParam"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	int shopId = UIUtil.getParamInInt(request, XYDWebParam.ID);
%>


		
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
<link href="${pageContext.request.contextPath}/css/shop_detail.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/nav.css" type="text/css" rel="stylesheet" />

<script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/xyd.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/shop_detail.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-jqLoding.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.fly.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/nav.js" type="text/javascript"></script>

<title>洗衣店管理系统</title>

</head>
<body>
	<jsp:include page="header.jsp" />
	
	<div class="J-global-toolbar">
	<div class="toolbar-wrap J-wrap">
		<div class="toolbar">
			<div class="toolbar-panels J-panel">
				<div style="visibility: hidden;" class="J-content toolbar-panel tbar-panel-cart toolbar-animate-out">
					<h3 class="tbar-panel-header J-panel-header">
						<a href="" class="title"><i></i><em class="title">购物车</em></a>
						<span class="close-panel J-close"></span>
					</h3>
					<div class="tbar-panel-main">
						<div class="tbar-panel-content J-panel-content">
							<div id="J-cart-tips" class="tbar-tipbox hide">
								<div class="tip-inner">
									<span class="tip-text">还没有登录，登录后商品将被保存</span>
									<a href="#none" class="tip-btn J-login">登录</a>
								</div>
							</div>
							<div id="J-cart-render">
								<div class="tbar-cart-list" id="jtc-item-goods-container" >
									<!-- <div class="tbar-cart-item" >
										<div class="jtc-item-promo">
											<em class="promo-tag promo-mz">满赠<i class="arrow"></i></em>
											<div class="promo-text">已购满600元，您可领赠品</div>
										</div>
										<div class="jtc-item-goods">
											<span class="p-img"><a href="#" target="_blank"><img src="http://img14.360buyimg.com/n5/g10/M00/00/14/rBEQWFEAilIIAAAAAACGm9ueTbUAAAH7gB8kskAAIaz106.jpg" alt="美的（Midea） BCD-206TM(E) 206升静音/省电/三门冰箱（闪白银）" height="50" width="50" /></a></span>
											<div class="p-name">
												<a href="#">美的（Midea） BCD-206TM(E)206升静音/省电/三门冰箱（闪白银）</a>
											</div>
											<div class="p-price"><strong>¥1398.00</strong>×1 </div>
											<a href="#none" class="p-del J-del">删除</a>
										</div>
									</div> -->
									
									
								</div>
							</div>
						</div>
					</div>
					<div class="tbar-panel-footer J-panel-footer">
					<div>
					<div id="more_goods_num_container">
						<h4 class="title">还有<span style="color:#C81623" id="more_goods_num">0</span>件商品</h4>
					</div>
					</div>
						<div class="tbar-checkout">
							<div class="jtc-number"> <strong class="J-count" id="total_sum_of_goods_amount">0</strong>件商品 </div>
							<div class="jtc-sum"> 共计：¥<strong class="J-total" id="total_sum_of_goods_money">0.00</strong> </div>
							<a class="jtc-btn J-btn" href="UserCenter-shopcart.jsp" target="_blank">去购物车结算</a>
						</div>
					</div>
				</div>

				<!-- <div style="visibility: hidden;" data-name="follow" class="J-content toolbar-panel tbar-panel-follow">
					<h3 class="tbar-panel-header J-panel-header">
						<a href="#" target="_blank" class="title"> <i></i> <em class="title">用户中心</em> </a>
						<span class="close-panel J-close"></span>
					</h3>
					<div class="tbar-panel-main">
						<div class="tbar-panel-content J-panel-content">
							<div class="tbar-tipbox2">
								<div class="tip-inner"> <i class="i-loading"></i> </div>
							</div>
						</div>
					</div>
					<div class="tbar-panel-footer J-panel-footer"></div>
				</div>
				
				<div style="visibility: hidden;" class="J-content toolbar-panel tbar-panel-history toolbar-animate-in">
					<h3 class="tbar-panel-header J-panel-header">
						<a href="#" target="_blank" class="title"> <i></i> <em class="title">我的订单</em> </a>
						<span class="close-panel J-close"></span>
					</h3>
					<div class="tbar-panel-main">
						<div class="tbar-panel-content J-panel-content">
							<div class="jt-history-wrap">
								<ul>
									<li class="jth-item">
										<a href="#" class="img-wrap"> <img src="http://img10.360buyimg.com/n0/s100x100_g9/M03/0C/18/rBEHalCKCk8IAAAAAAD5nbR5xOAAACfgQENi_wAAPm1269.jpg" height="100" width="100" /> </a>
										<a class="add-cart-button" href="#" target="_blank">加入购物车</a>
										<a href="#" target="_blank" class="price">￥498.00</a>
									</li>
									<li class="jth-item">
										<a href="#" class="img-wrap"> <img src="http://img10.360buyimg.com/n0/s100x100_g9/M03/0C/18/rBEHalCKCk8IAAAAAAD5nbR5xOAAACfgQENi_wAAPm1269.jpg" height="100" width="100" /></a>
										<a class="add-cart-button" href="#" target="_blank">加入购物车</a>
										<a href="#" target="_blank" class="price">￥498.00</a>
									</li>
								</ul>
								<a href="#" class="history-bottom-more" target="_blank">查看更多足迹商品 &gt;&gt;</a>
							</div>
						</div>
					</div>
					<div class="tbar-panel-footer J-panel-footer"></div>
				</div> -->
			</div>
			
			<div class="toolbar-header"></div>
			
			<div class="toolbar-tabs J-tab">
				<div class="toolbar-tab tbar-tab-cart">
					<i class="tab-ico"></i>
					<em class="tab-text ">购物车</em>
					<span class="tab-sub J-count " id="J-count" >0</span>
				</div>
				<div class=" toolbar-tab tbar-tab-follow">
					<i class="tab-ico"></i>
					<em class="tab-text">用户中心</em>
					<span class="tab-sub J-count hide">0</span> 
				</div>
				<div class=" toolbar-tab tbar-tab-history ">
					<i class="tab-ico"></i>
					<em class="tab-text">我的订单</em>
					<span class="tab-sub J-count hide">0</span>
				</div>
			</div>
			
			<div class="toolbar-footer">
				<div class="toolbar-tab tbar-tab-top"> <a href="#"> <i class="tab-ico  "></i> <em class="footer-tab-text">顶部</em> </a> </div>
				<div class=" toolbar-tab tbar-tab-feedback"> <a href="#" target="_blank"> <i class="tab-ico"></i> <em class="footer-tab-text ">反馈</em> </a> </div>
			</div>
			
			<div class="toolbar-mini"></div>
			
		</div>
		
		<div id="J-toolbar-load-hook"></div>
		
	</div>
</div>
	
	<input type="hidden" id="shop_id_bidden" value="<%=shopId %>">
	<div class="container-fluid">
	<div class="row-fluid">
		<div class="span1">
		</div>
		<div class="span10">
			<div class="wrapper">
				<div id="shop_info_container">
					
					<div id="shop_img_container">
						<img class="goods_img" src="img/shop_logo.jpg">
					</div>
					<div id="shop_detail_container">
						<h2 style="color: gray;" id="shop_name"></h2>
						<div style="margin-top: 15px;">
						<span style="color: gray;" id="shop_desc"></span>
						</div>
						<div style="margin-top: 10px;">
							<span style="color: gray;">地址：</span><span style="color: gray;" id="shop_addr"></span>
						</div>
						<div style="margin-top: 10px;">
							<span style="color: gray;">电话：</span><span style="color: gray;" id="shop_phone"></span>
						</div>
					</div>
				</div>
				<div id="goods_list_container">
					<div id="loading_container">
						<img id="loading_img" alt="" src="img/loading1.gif" />
						<span style="color: gray;">正在载入店铺商品</span>
					</div>
					
					<!-- <div  class="goods_container">
						<div class="goods_container_head">
							<div class="goods_img_container">
								<img class="goods_img" src="img/goods_simple.jpg">
							</div>
						</div>
						<div class="goods_container_foot">
							<div style="margin-top: 5px;" >
								<span style="color: black;">干洗衬衣</span>
							</div>
							<div style="margin-top: 0px;" >
								<span style="color: gray;">$1.5</span>
							</div>
							<div style="margin-top: 10px;" class="add_to_card">
							</div>
						</div>
					</div> -->
					
					
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