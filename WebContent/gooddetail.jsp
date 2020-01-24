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
<script src="${pageContext.request.contextPath}/js/index.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-jqLoding.js" type="text/javascript"></script>


<title>商品详情</title>

</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="container-fluid">
	<div class="row-fluid">
		<div class="span2">
		</div>
		<div class="span8">
			<h3 id="GoodDetail">
			
				<a href="shopdetail.jsp" style="color:black">
    				<span  class="ng-binding" onclick="copyText()" >＜＜返回</span> </a>
			     <img alt="186x55" id="searchbox_img" src="css/images/MyShop_searchboxboy.jpg" />
			</h3>
			<div class="row-fluid">
				<hr>
				<div class="row-fluid">
					<div class="span2" >
					</div>
					<div class="span3" >
						<img src="img/duanmianfu.jpg" alt=""/>
					</div>
					<div class="span1" >
					</div>
					<div class="span4" >
						<br>
						<p>干洗类目：  西裤</p>
						<br>
                    	<p>单价：      ￥14.40</p>
                    	<br>
						<p>干洗数目：  1 </p>
						<br>
						<p>配送方式：  悬挂/折叠</p>
						<br>
						<br>
						<div class="row-fluid">
							<div class="span6" >
								<button type="button" class="btn" id="">直接购买</button>
							</div>
							<div class="span6" >
								<button type="button" class="btn" formaction="remarkSeller.jsp">加入购物车</button>
							</div>	
						</div>
					</div>
					<div class="span2" >
					</div>																
				</div>
				<br/>
				<br/>
				<hr>
				<div class="row-fluid">
					<div class="span1" >
					</div>
					<div class="span10" >
						<h3 style="margin: 0px 0px 0px 80px; padding: 0px; outline: 0px; border: 0px currentColor; color: rgb(0, 181, 238); font-family: 微软雅黑, Helvetica, Arial; font-size: 18px; font-weight: inherit; vertical-align: baseline;">为什么要洗西裤？</h3>
						<p style="margin: 10px 0px 0px 80px; padding: 0px; outline: 0px; border: 0px currentColor; color: rgb(68, 68, 68); line-height: 2em; text-indent: 2em; font-family: 微软雅黑, Helvetica, Arial; font-size: 14px; vertical-align: baseline; word-break: break-all;">西裤洗涤最注重的是不破坏西裤原有的造型，挺直的裤线才能展现西裤的魅力。西裤尤其是高档西裤，洗涤方式不当很容易导致褶皱和变形，大大影响西裤的穿着效果和使用寿命。</p>
						<br/>
						<h3 style="margin: 0px 0px 0px 80px; padding: 0px; outline: 0px; border: 0px currentColor; color: rgb(0, 181, 238); font-family: 微软雅黑, Helvetica, Arial; font-size: 18px; font-weight: inherit; vertical-align: baseline;">77洗衣</h3>
						<p style="margin: 10px 0px 0px 80px; padding: 0px; outline: 0px; border: 0px currentColor; color: rgb(68, 68, 68); line-height: 2em; text-indent: 2em; font-family: 微软雅黑, Helvetica, Arial; font-size: 14px; vertical-align: baseline; word-break: break-all;">身着77洗衣有型的西裤可在商务会议、谈判等严肃场合塑造你沉稳、干练的气质，也可以在上班途中树立严谨、精干的工作形象，也可在旅途中保持清爽、整洁的形象。</p>
						<br/>
						<h3 style="margin: 0px 0px 0px 80px; padding: 0px; outline: 0px; border: 0px currentColor; color: rgb(0, 181, 238); font-family: 微软雅黑, Helvetica, Arial; font-size: 18px; font-weight: inherit; vertical-align: baseline;">&nbsp;&nbsp;保养知识</h3>
						<p style="margin: 10px 0px 0px 80px; padding: 0px; outline: 0px; border: 0px currentColor; color: rgb(68, 68, 68); line-height: 2em; text-indent: 2em; font-family: 微软雅黑, Helvetica, Arial; font-size: 14px; vertical-align: baseline; word-break: break-all;">1. 收藏存放西裤应选择通风干燥处。</p>
						<p style="margin: 10px 0px 0px 80px; padding: 0px; outline: 0px; border: 0px currentColor; color: rgb(68, 68, 68); line-height: 2em; text-indent: 2em; font-family: 微软雅黑, Helvetica, Arial; font-size: 14px; vertical-align: baseline; word-break: break-all;">2. 不可把没有干透的西裤进行收藏存放。</p>
						<p style="margin: 10px 0px 0px 80px; padding: 0px; outline: 0px; border: 0px currentColor; color: rgb(68, 68, 68); line-height: 2em; text-indent: 2em; font-family: 微软雅黑, Helvetica, Arial; font-size: 14px; vertical-align: baseline; word-break: break-all;">3. 收藏存放期间，要适当进行通风和晾晒。</p>
						<p style="margin: 10px 0px 0px 80px; padding: 0px; outline: 0px; border: 0px currentColor; color: rgb(68, 68, 68); line-height: 2em; text-indent: 2em; font-family: 微软雅黑, Helvetica, Arial; font-size: 14px; vertical-align: baseline; word-break: break-all;">4. 把樟脑丸用白纸或浅色纱布包好，散放在箱柜四周，或装入小布袋中悬挂在衣柜内防虫防蛀。</p>
						<p style="margin: 10px 0px 0px 80px; padding: 0px; outline: 0px; border: 0px currentColor; color: rgb(68, 68, 68); line-height: 2em; text-indent: 2em; font-family: 微软雅黑, Helvetica, Arial; font-size: 14px; vertical-align: baseline; word-break: break-all;">5. 西裤存放的时候，一定要用衣架挂起来，并把口袋内的物品统统拿出来，还要把皮带抽走。</p>
					</div>
					<div class="span1" >
					</div>																
				</div>
				<hr>
			</div>
		</div>
		<div class="span2">
		</div>
	</div>
</div>

<jsp:include page="foot.jsp" />

</body>
</html>