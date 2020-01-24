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
<link href="${pageContext.request.contextPath}/css/MyShop_customer.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/footer.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/header.css" type="text/css" rel="stylesheet" />

<script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/xyd.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/index.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-jqLoding.js" type="text/javascript"></script>


<title>客户信息</title>

</head>
<body>
	<jsp:include page="header.jsp" />

		<div class="container-fluid">
	<div class="row-fluid">
		<div class="span1">
		</div>

		<div class="span10">
		<h3 id="MyOrder">
    <a href="${pageContext.request.contextPath}/MyShop.jsp" style="color:black">
    <img alt="186x55" id="back" src="css/images/back.png" />返回</a>
</h3>
</div>


	<div class="row-fluid">

<div class="span2">
			
			</div>
		<div class="span3">
		<h3 id="customer_info">
<span  class="ng-binding">客 户 信 息</span>
</h3>
<ul id="customer_info_list">
                        <li><span></span><p></p>
                        </li><li><span class="title">客户账户：</span>malei</li>
                        <li><span class="title">客户邮箱：</span>gorillazhip@126.com</li>
                        <li><span class="title">手机号：</span>18120076642</li>
                        <li><span class="title">收货地址：</span>江苏省苏州市独墅湖高教区文荟人才公寓11栋614</li>
                    </ul>
           </div>
		<div class="span3">
		 <img alt="186x55" id="customer_logo_img" src="css/images/customer_logo_img.jpg" />
		<div class="span1">
		</div>


		<div class="span2">

	</div>
		<div class="span1">
		</div>
	</div>
</div>
</div>
	<div class="row-fluid">
<jsp:include page="foot.jsp" />
</div>
</div>
</body>
</html>