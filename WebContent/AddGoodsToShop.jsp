<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>

<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src = "${pageContext.request.contextPath}/js/jquery.fileupload.js" type="text/javascript"></script>
<script src = "${pageContext.request.contextPath}/js/jquery.fileupload-validate.js" type="text/javascript"></script>
<script src = "${pageContext.request.contextPath}/js/jquery.fileupload-process.js" type="text/javascript"></script>
<script src = "${pageContext.request.contextPath}/js/cj/AddGoodsToShop.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/ajaxfileupload.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/cj/commodityDetail.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" type="text/css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/xyd.js" type="text/javascript"></script>
</head>
<body>
<jsp:include page="header.jsp" />
		<div class="container">
			<div class="row">
						<div class="span4">
						
								<div class="span4 cjrow1FirstImage cjtextaligncenter ">
									<img src="PicDownloadServlet?file_name=123456.gif" class="img-polaroid" id="testimg"  height="350" width="350" />
						 		 </div>

								<div class="span4 ">
							   		<form class = "cjrow2upLoadButton cjtextaligncenter">
					  					<a class="btn_addPic"><span><em>+</em>添加图片</span>
					  						<input type="file" tabindex="3" title="支持jpg、jpeg、gif、png格式，文件小于5M" size="3" class="filePrew" name="picPath"  id="picPath" onchange="(checkPic())">
					  					</a>
									</form>
							 	</div>
						</div>
						
						<div class="span8 cjrow1FirstImage ">
						
				                <form class="form-horizontal">
				                  <div class="control-group">
				                    <label class="control-label" for="goodsname" contenteditable="true">商品名称</label>
				                    <div class="controls">
				                      <input id="goodsname" placeholder="请填写商品名称"  type="text">
				                    </div>
				                  </div>
				                  
				                    <div class="control-group">
				                    <label class="control-label" for="goodprice" contenteditable="true">市场价格</label>
				                    <div class="controls">
				                      <input id="goodprice" placeholder="请填写商品价格" type="text">
				                    </div>
				                  </div> 

				                 <div class="control-group ">
				                   <button class="btn btn-large cjSubmitbutton" type="button" onclick="(btnOK_click())">确认提交</button>
				                </div>
				                </form>
				
						</div>
			</div>
		</div>
	<jsp:include page="foot.jsp" />
	</body>
</body>
</html>