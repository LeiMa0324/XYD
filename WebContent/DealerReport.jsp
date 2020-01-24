<!DOCTYPE html>
<%@page import="com.seu.xyd.data.Shop"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.seu.xyd.servlet.UIUtil"%>
<%@page import="com.seu.xyd.servlet.XYDWebParam"%>

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
<link href="${pageContext.request.contextPath}/css/header.css" type="text/css" rel="stylesheet" />

<script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/xyd.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/js/jquery-ui-jqLoding.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/DealerReport.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/ajaxfileupload.js" type="text/javascript"></script>
<title>商户营业报表</title>
<style>
.table td
{
border-top:0px;

}

</style>
</head>
<body>
<input type="hidden" id="shopId" value=<%=UIUtil.getParamInLong(request, XYDWebParam.ID)%>>
	<jsp:include page="header.jsp" />

		<div class="container-fluid">
	<div class="row-fluid">
		<div class="span2" style="text-align:center">
		<a href="DealerManagement.jsp" >«返回</a>
		</div>
		<div class="span8">
				<table class="table">
					<tbody id="shoptable">
						<tr>
							<td rowspan="3">
								<div class="view">
									<img  src="" alt="140x140"/>
								</div>
							</td>
							<td>阳光洗衣店</td>
							<td>营业额</td>
							<td>￥1200</td>
						</tr>
						<tr>
							<td>0512-1234567</td>
							<td>订单数</td>
							<td>120</td>
						</tr>
						<tr>
							<td>苏州市吴中区林泉街399号</td>
						</tr>
					</tbody>
				</table>
				<table class="table">
				<thead id="tableheader">
					<tr>
						<th>
							订单日期
						</th>
						<th>
							订单编号
						</th>
						<th>
							客户账户
						</th>
						
						<th>
							金额
						</th>
						<th>订单状态</th>
					</tr>
				</thead>
				<tbody id="tablebody">
					<tr>
						<td>
						01/02/2016

						</td>
						<td>
						123456789

						</td>
						<td>
						<a href="#">maleihahaha</a>
							
						</td>
						
						<td>
							123
						</td>
					</tr>
					<tr>
						<td>
						01/02/2016

						</td>
						<td>
						123456789

						</td>
						<td>
						<a href="#">maleihahaha</a>
							
						</td>
						
						<td>
							123
						</td>
					</tr>
					<tr>
						<td>
						01/02/2016

						</td>
						<td>
						123456789

						</td>
						<td>
						<a href="#">maleihahaha</a>
							
						</td>
						
						<td>
							123
						</td>
					</tr>
					<tr>
						<td>
						01/02/2016

						</td>
						<td>
						123456789

						</td>
						<td>
						<a href="#">maleihahaha</a>
							
						</td>
						
						<td>
							123
						</td>
					</tr>
					<tr>
						<td>
						01/02/2016

						</td>
						<td>
						123456789

						</td>
						<td>
						<a href="#">maleihahaha</a>
							
						</td>
						
						<td>
							123
						</td>
					</tr>
					<tr>
						<td>
						01/02/2016

						</td>
						<td>
						123456789

						</td>
						<td>
						<a href="#">maleihahaha</a>
							
						</td>
						
						<td>
							123
						</td>
					</tr>
					</tbody>
					</table>
		<div class="pagination pagination-right">
				<ul>
					<li>
						<a href="#">上一页</a>
					</li>
					<li>
						<a href="#">1</a>
					</li>
					<li>
						<a href="#">2</a>
					</li>
					<li>
						<a href="#">3</a>
					</li>
					<li>
						<a href="#">4</a>
					</li>
					<li>
						<a href="#">5</a>
					</li>
					<li>
						<a href="#">下一页</a>
					</li>
				</ul>
			</div>			
  </div>
		<div class="span2">
		</div>
	</div>
</div>

<jsp:include page="foot.jsp" />
</body>
</html>