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
<script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/xyd.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/shop_register2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-jqLoding.js" type="text/javascript"></script>


<script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/TestAddress.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/TestChooseAddress.js" type="text/javascript"></script>
<script src="http://api.map.baidu.com/api?v=1.4" type="text/javascript"></script>

<title>洗衣店管理系统</title>

</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span1">
				</div>
			<div class="span10">
			<div id="choose_city">
				<select id="id_provSelect" name="provSelect" onChange="loadCity(this.value);"><option value="">请选择省份</option></select>&nbsp;
	  			<select id="id_citySelect" name="citySelect" onChange="loadArea(this.value);"><option value="">请选择城市</option></select>&nbsp;
	  			<select id="id_areaSelect" name="areaSelect"><option value="">请选择区域</option></select>&nbsp;
			</div>
			<div id="container" style="width:100%;height:600px;text-align: center;margin:auto;"></div> 
			</div>
			
			<div class="span1">
			</div>
		
	</div>
		</div>
	<jsp:include page="foot.jsp" />
</body>

</html>
