<%@page import="com.seu.xyd.data.Goods"%>
<%@page import="com.seu.xyd.servlet.UIUtil"%>
<%@page import="com.seu.xyd.servlet.XYDWebParam"%>
<%@page import="com.seu.xyd.logic.ShopLogic"%>
<%@page import="com.seu.xyd.data.Goods"%>
<%@page import="com.seu.xyd.data.GoodsImg"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%
    long id = UIUtil.getParamInLong(request, XYDWebParam.ID);
     final ShopLogic sL = ShopLogic.getInstance();
     Goods goods = sL.getGoodsByGoodsId(id);
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
<link href="${pageContext.request.contextPath}/css/goods_detail.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/nav.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/jquery.spinner.css" type="text/css" rel="stylesheet" />

<script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/xyd.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/goods_detail.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-jqLoding.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.fly.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/nav.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.spinner.js" type="text/javascript"></script>

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
	
	<div class="container-fluid">
	<div class="row-fluid">
		<div class="span1">
		</div>
		<div class="span10">
			<div class="wrapper">
				<div id="goods_info_container">
					
					<div id="goods_img_container">
						<img class="goods_img" src="img/goods_simple.jpg">
					</div>
					<div id="goods_detail_container">
						<h2 style="color: gray;" id="shop_name">衬衫干洗</h2>
						<div style="margin-top: 15px;">
						<span style="color: gray;" id="shop_desc"></span>
						</div>
						<div style="margin-top: 20px;">
							<span style="color: gray;">价格：</span><span style="color: gray;" id="shop_addr">￥<%=goods.getPrice() %></span>
						</div>
						<div style="margin-top: 20px;">
							<span style="color: gray;">数量：</span><span style="display: inline-block;"><input type="text" class="spinnerExample" id="buy_amount" value="1"/></span>
						</div>
						<div style="margin-top: 50px;">
							<button class="btn" type="button" id="buy_now_btn" data-id="<%=goods.getId()%>" >立即购买</button>
							<button class="btn" type="button" id="add_to_card_btn" data-id="<%=goods.getId()%>">加入购物车</button>
						</div>
						
					</div>
				</div>
				<h2 style="color: rgb(0, 181, 238);margin-top: 20px;font-size: 28px;" >详情描述</h2>
				<div id="goods_desc_list_container">
				<%
				for(GoodsImg goodsImg : goods.getGoodsImgs()){
					%>
					<div class="goods_desc_container">
						<div class="goods_desc_img_container">
							<img class="goods_desc_img" src="img/shop_logo.jpg">
						</div>
						<div class="goods_desc_info_container">
							<span>休闲裤多见牛仔面料、亚麻面料、棉布。休闲裤穿一天之后容易褶皱变形，臀部容易起皱变脏，时间长不洗会发现臀部脏的发亮，严重有损个人形象。需要注意的是，休闲裤的洗涤不当会变形，褪色的。</span>
						</div>
					</div>
					<%
				}
				%>				
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