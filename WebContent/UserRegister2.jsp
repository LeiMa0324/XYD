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

<script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/xyd.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-jqLoding.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/UserRegister2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/TestAddress.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/TestChooseAddress.js" type="text/javascript"></script>
<title>会员注册2</title>
<style>
.table td
{
border-top:0px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />

		<div class="container-fluid">
	<div class="row-fluid">
		<div class="span1">
		</div>
<!-- 		<div class="span2"> -->
<!-- 			<ul class="nav nav-list well"> -->
<!-- 				<li class="nav-header" id="MyShop"> -->
<!-- 					我的店铺 -->
<!-- 				</li> -->
<!-- 				<li > -->
<!-- 					<a class="mybadge myactive" href="#">我的订单</a> -->
<!-- 					 <span class="badge">1</span> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<a href="#">数据统计</a> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<a href="#">维护商品</a> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<a href="#">店铺信息</a> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<a href="#">员工管理</a> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<a href="#">物品管理</a> -->
<!-- 				</li> -->
<!-- 			</ul> -->
<!-- 		</div> -->
<div class="span1">
		</div>
		<div class="span5">
  <table class="table">
				<thead id="tableheader">
					<tr>
						<th>
							收货人信息
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>配送区域</td>
						<td style="text-align:left">               
              
                
				<div id="choose_city">
				<select id="id_provSelect" name="provSelect" onChange="loadCity(this.value);"><option value="">请选择省份</option></select>&nbsp;
	  			<select id="id_citySelect" name="citySelect" onChange="loadArea(this.value);"><option value="">请选择城市</option></select>&nbsp;
	  			<select id="id_areaSelect" name="areaSelect"><option value="">请选择区域</option></select>&nbsp;
			</div>
						</td>
		
					</tr>
					<tr>
						<td>
						<label class="control-label" for="inputEmail" contenteditable="true"><span style="color:#C00">*</span>收货人姓名</label>
						</td>
						<td style="text-align:left">
						<input type="text">
						</td>
						
						
					</tr>
<tr>
	<td>
						<label class="control-label" for="inputEmail" contenteditable="true"><span style="color:#C00">*</span>联系电话</label>
						</td>
						<td style="text-align:left">
						<input type="text">
						</td>
	</tr>
					<tr>
						<td>
							<label class="control-label" for="inputEmail" contenteditable="true"><span style="color:#C00">*</span>详细地址</label>
						</td>
						<td style="text-align:left">
						<input type="text">
						</td>
						
					</tr>
<tr>
	<td></td>
<td style="text-align:left">
 
					<input style="margin-top:0px" type="checkbox"> <a href="#">《网站协议》</a>
					<button type="submit" class="btn" style="margin-left:10%" contenteditable="true">注册</button>

</td>

	</tr>				
				</tbody>
			</table>
  </div>
		<div class="span1">
		</div>
	</div>
</div>

<jsp:include page="foot.jsp" />
</body>
</html>