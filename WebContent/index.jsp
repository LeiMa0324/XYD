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
<link href="${pageContext.request.contextPath}/css/index.css" type="text/css" rel="stylesheet" />

<script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/xyd.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/index.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-jqLoding.js" type="text/javascript"></script>

<title>洗衣店管理系统</title>

</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container-fluid">
	<div class="row-fluid">
		<div class="span1">
		</div>
		<div class="span10">
			<div class="wrapper">
				<div class="carousel slide" id="carousel-176152">
					<ol class="carousel-indicators">
						<li data-slide-to="0" data-target="#carousel-176152">
						</li>
						<li data-slide-to="1" data-target="#carousel-176152">
						</li>
						<li data-slide-to="2" data-target="#carousel-176152" class="active">
						</li>
					</ol>
					<div class="carousel-inner">
						<div class="item">
							<img alt="" src="img/1.jpg" />
							<div class="carousel-caption">
								<h4>
									棒球
								</h4>
								<p>
									棒球运动是一种以棒打球为主要特点，集体性、对抗性很强的球类运动项目，在美国、日本尤为盛行。
								</p>
							</div>
						</div>
						<div class="item">
							<img alt="" src="img/2.jpg" />
							<div class="carousel-caption">
								<h4>
									冲浪
								</h4>
								<p>
									冲浪是以海浪为动力，利用自身的高超技巧和平衡能力，搏击海浪的一项运动。运动员站立在冲浪板上，或利用腹板、跪板、充气的橡皮垫、划艇、皮艇等驾驭海浪的一项水上运动。
								</p>
							</div>
						</div>
						<div class="item active">
							<img alt="" src="img/3.jpg" />
							<div class="carousel-caption">
								<h4>
									自行车
								</h4>
								<p>
									以自行车为工具比赛骑行速度的体育运动。1896年第一届奥林匹克运动会上被列为正式比赛项目。环法赛为最著名的世界自行车锦标赛。
								</p>
							</div>
						</div>
					</div> <a data-slide="prev" href="#carousel-176152" class="left carousel-control">‹</a> <a data-slide="next" href="#carousel-176152" class="right carousel-control">›</a>
				</div>
				<div id="my_address_container">
					<span style="color: gray;">当前位置：</span>
					<span id="address_spn" >东南大学苏州研究院</span>&nbsp;&nbsp;
					<span  >
					<a href="home.jsp" style="color:#0089dc;">[切换地址]</a>
					</span>
				</div>
				
				<div id="shop_list_container">
					<div id="loading_container">
						<img id="loading_img" alt="" src="img/loading1.gif" />
						<span style="color: gray;">正在载入附近的商家</span>
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