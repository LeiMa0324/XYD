<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="pragma" content="no-cache" />

<script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src = "${pageContext.request.contextPath}/js/jquery.fileupload.js" type="text/javascript"></script>
<script src = "${pageContext.request.contextPath}/js/jquery.fileupload-validate.js" type="text/javascript"></script>
<script src = "${pageContext.request.contextPath}/js/jquery.fileupload-process.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/cj/AddToshopCartSucceed.css" type="text/css" rel="stylesheet" />
<title>添加购物车成功</title>
</head>
<body>
		<jsp:include page="header.jsp" />
		<div class="container">
			<div class="row">
				<div class="span12">
						<div class="row">
								<div class="span2">
								</div>
								<div class="span8">
								<div  class= "cjAddToShopFinshBox">
								<div class="cjtestMiddle">加入购物车成功</div>
								</div>
								</div>
								<div class="span2">
								</div>
						</div>
				</div>
			</div>
			<div class= "row">
			<div class="span12">
			<div class="row">
								<div class="span2">
								</div>
								<div class="span8" >
							<div class="row">
							<div class="span2" ></div>
							<div class="span4 cjAddToShopButton" >
							<div class="row">
							<div class="span2 cjRightButton">
							 <button class="btn" type="button">继续购物</button>
							 </div>
							 	<div class="span2 cjRightButton">
							  <button class="btn " type="button">去结算</button>
							  </div>
							  </div>
							  </div>
							</div>
							<div class="span2" ></div>
								</div>
								<div class="span2">
								</div>	
			</div>
			</div>
		</div>
		</div>
		<jsp:include page="foot.jsp" />
		
</body>
</html>