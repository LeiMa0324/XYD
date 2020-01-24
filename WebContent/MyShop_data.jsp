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
<link href="${pageContext.request.contextPath}/css/MyShop_data.css" type="text/css" rel="stylesheet" />


<script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/xyd.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/index.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-jqLoding.js" type="text/javascript"></script>


<title>数据统计</title>

</head>
<body>
	<jsp:include page="header.jsp" />

		<div class="container-fluid">
	<div class="row-fluid">
		<div class="span1">
		</div>
		<div class="span2">
			<ul class="nav nav-list well">
				<li class="nav-header" id="MyShop">
					我的店铺
				</li>
				<li >
					<a href="#">我的订单</a>
					 <span class="badge">1</span>
				</li>
				<li>
					<a class="mybadge myactive"  href="#">数据统计</a>
				</li>
				<li>
					<a href="#">维护商品</a>
				</li>
				<li>
					<a href="#">店铺信息</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/MyShop_employer.jsp">员工管理</a>
				</li>
				<li>
					<a href="#">物品管理</a>
				</li>
			</ul>
		</div>
		<div class="span8">
<h3 id="MyOrder">
<span  class="ng-binding">数据统计</span>
     <img alt="186x55" id="searchbox_img" src="css/images/MyShop_searchboxboy.png" />
</h3>
			<div class="row-fluid" style="margin-bottom:30px">
			
                <form class="form-search">
              <input class="input-medium search-query" id="searchBox" type="text" placeholder="请输入订单号和商品名称"> 
                  <button type="submit" class="btn" contenteditable="true">订单查询</button>
                </form>

				</div>
	<div class="row-fluid" >
			<div class="tabbable" id="tabs-738603">
				<ul class="nav nav-tabs">
					<li>
						<a href="#panel-395975" data-toggle="tab">全部订单</a>
					</li>
					<li>
						<a href="#panel-395975" data-toggle="tab">已付款</a>
					</li>
					<li>
						<a href="#panel-178151" data-toggle="tab">已接单</a>
					</li>
					<li class="active">
						<a href="#panel-178151" data-toggle="tab">订单配派送中</a>
					</li>
					<li>
						<a href="#panel-178151" data-toggle="tab">已完成</a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane" id="panel-395975">
					</div>
					<div class="tab-pane active" id="panel-178151">
					</div>
				</div>
			</div>
			</div>
			<table class="table">
				<thead id="tableheader">
					<tr>
						<th>
							订单编号
						</th>
						<th>
							客户账户
						</th>
						<th>
							下单时间
						</th>
						<th>
							订单状态
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
						<p>
							<a href="#">2016030111111</a>
							</p>
						</td>
						<td>
						<a href="${pageContext.request.contextPath}/MyShop_customer.jsp">maleihahaha</a>
							
						</td>
						<td>
						<a href="#">maleihahaha</a>

						</td>
						<td>
							已付款
						</td>
						<td>
							 <button type="button" class="btn btn-default btn-ordercheck">接单</button>
						</td>
					</tr>
					<tr >
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Approved
						</td>
						<td>
							Default
						</td>
					</tr>
					<tr>
						<td>
							2
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							02/04/2012
						</td>
						<td>
							Declined
						</td>
						<td>
							Default
						</td>
					</tr>
					<tr>
						<td>
							3
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							03/04/2012
						</td>
						<td>
							Pending
						</td>
						<td>
							Default
						</td>
					</tr>
					<tr>
						<td>
							4
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							04/04/2012
						</td>
						<td>
							Call in to confirm
						</td>
						<td>
							Default
						</td>
					</tr>
						<tr>
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Default
						</td>
						<td>
							Default
						</td>
					</tr>
						<tr>
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Default
						</td>
						<td>
							Default
						</td>
					</tr>
						<tr>
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Default
						</td>
						<td>
							Default
						</td>
					</tr>
						<tr>
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Default
						</td>
						<td>
							Default
						</td>
					</tr>
						<tr>
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Default
						</td>
						<td>
							Default
						</td>
					</tr>
						<tr>
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Default
						</td>
						<td>
							Default
						</td>
					</tr>
						<tr>
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Default
						</td>
						<td>
							Default
						</td>
					</tr>
						<tr>
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Default
						</td>
						<td>
							Default
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
		<div class="span1">
		</div>
	</div>
</div>

<jsp:include page="foot.jsp" />
</body>
</html>