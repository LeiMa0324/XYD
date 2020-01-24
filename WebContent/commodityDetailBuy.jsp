<%@page import="com.seu.xyd.data.Goods"%>
<%@page import="com.seu.xyd.servlet.UIUtil"%>
<%@page import="com.seu.xyd.servlet.XYDWebParam"%>
<%@page import="com.seu.xyd.logic.ShopLogic"%>
<%@page import="com.seu.xyd.data.Goods"%>
<%@page import="com.seu.xyd.data.GoodsImg"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    long id = UIUtil.getParamInLong(request, XYDWebParam.ID);
     final ShopLogic sL = ShopLogic.getInstance();
     Goods goods = sL.getGoodsByGoodsId(id);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>

<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="pragma" content="no-cache" />
<link href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/cj/commodityDetailBuy.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/header.css" type="text/css" rel="stylesheet" />

<script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src = "${pageContext.request.contextPath}/js/jquery.fileupload.js" type="text/javascript"></script>
<script src = "${pageContext.request.contextPath}/js/jquery.fileupload-validate.js" type="text/javascript"></script>
<script src = "${pageContext.request.contextPath}/js/jquery.fileupload-process.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/ajaxfileupload.js" type="text/javascript"></script>
<script src = "${pageContext.request.contextPath}/js/cj/commodityDetailBuy.js" type="text/javascript"></script>


</head>
<body>
	<jsp:include page="header.jsp" />
<div class="container">
	<div class="row">
		<div class="span12">
			<div class="row">
			<div class="span3">
			</div>
				<div class="span3 cjimageContentPosition contentPosition">
				<img  src="PicDownloadServlet?file_name=<%=goods.getLogo() %>" class="img-polaroid" id="testimg" />
				</div>
				<div class="span4 contentPosition">
				
	
					<div class="span4">
					商品名称：<%=goods.getName() %>
					</div>
			
					<div class="span4 cjDetailBuytopMargin">
					商品名称：<%=goods.getPrice() %>
					</div>

			<div class="span4 cjDetailBuytopMargin">
			<div class="row submitButtonPosition">
				<div class="span1.5">
					 <button class="btn" type="button" onclick="(btnBuyNow_click())">  立即购买       </button>
				</div>
				<div class="span1.5">
					 <button class="btn" type="button" onclick="(btnAddToBasket_click())">  加入购物车     </button>
				</div>
				</div>
			
					</div>
					</div>
					
			</div>
			<div>
			<div class="span3">
		
			</div>
			<div class="span3">
		
			</div>
			
			<div class="span3">
		
			</div>
			
			</div>
			
			<div class = row>
				<div class ="span3">
			</div>
			<div class ="span6" >
			<hr>
			</div>
			<div class ="span3">
			</div>
			
			</div>
		
			<div class="row">
			
			<div class="span3">
		
			</div>
				<div class="span6 contentPosition">
				<%for(int i=0;i<goods.getGoodsImgs().length;i++){
					GoodsImg goodsImg = goods.getGoodsImgs()[i];
					
					%>
					<div>
					<img  src="PicDownloadServlet?file_name=<%=goodsImg.getImgUrl() %>" class="cjDetailImageFrame" />
					<br><br><br><br>
					&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<%=goodsImg.getImgDesc()%>
					<br><br><br><br>
					
					</div>
					<%}%>
				 
				 
				
				</div>
				<div class="span3">
		
			</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="foot.jsp" />
</body>
</html>