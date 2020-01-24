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
<link href="${pageContext.request.contextPath}/css/MyShop_employer.css" type="text/css" rel="stylesheet" />

<script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/xyd.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/MyShop_employer.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-jqLoding.js" type="text/javascript"></script>


<title>店铺信息</title>

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
					<a class="mybadge" href="${pageContext.request.contextPath}/MyShop.jsp">我的订单</a>
					 <span class="badge">1</span>
				</li>
				<li>
					<a href="#">数据统计</a>
				</li>
				<li >
					<a href="#">维护商品</a>
				</li>
							<li>
					<a href="#">店铺信息</a>
				</li>
				<li>
					<a class="myactive"   href="#">员工管理</a>
				</li>
				<li>
					<a href="#">物品管理</a>
				</li>
			</ul>
		</div>
		<div class="span8">
<h3 id="MyOrder">
<span  class="ng-binding">员工管理</span>
     <img alt="186x55" id="searchbox_img" src="css/images/MyShop_searchboxboy.png" />
</h3>

	<div class="row-fluid" >
			<div class="tabbable" id="tabs-738603">
<!-- 				<ul class="nav nav-tabs">
					</li> -->

                <form class="form-search">
              <input class="input-medium search-query" id="searchBox" type="text" placeholder="请输入员工姓名"> 
                  <button type="submit" class="btn" id="searchemp_btn" contenteditable="true">查询员工</button>
                  					                  <button type="button" class="btn btn-default btn-ordercheck btn-tabletop" style="float:right">删除</button>
					                   <button type="button" class="btn btn-default btn-ordercheck btn-tabletop" style="float:right">添加</button>
					                    <button type="button" class="btn btn-default btn-ordercheck btn-tabletop" style="float:right">编辑</button>

                </form>

<!-- 				</ul> -->
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
							
						</th>
						<th>
							员工姓名
						</th>
						<th>
							出生日期
						</th>
						<th>
							性别
						</th>
						<th>
							入职时间
						</th>
						<th>
							学历
						</th>
						<th>
							状态
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
					<td>
					<input type="checkbox">
					</td>
						<td>
						王五
						</td>
						<td>
						19890324
							
						</td>
						<td>
							2015年3月1日
						</td>
						<td>
							男
						</td>
						<td>
							本科
						</td>
						<td>
							在职
						</td>
					</tr>
			<tr>
					<td>
					<input type="checkbox">
					</td>
						<td>
						王五
						</td>
						<td>
						19890324
							
						</td>
						<td>
							2015年3月1日
						</td>
						<td>
							男
						</td>
						<td>
							本科
						</td>
						<td>
							在职
						</td>
					</tr>
			<tr>
					<td>
					<input type="checkbox">
					</td>
						<td>
						王五
						</td>
						<td>
						19890324
							
						</td>
						<td>
							2015年3月1日
						</td>
						<td>
							男
						</td>
						<td>
							本科
						</td>
						<td>
							在职
						</td>
					</tr>
			<tr>
					<td>
					<input type="checkbox">
					</td>
						<td>
						王五
						</td>
						<td>
						19890324
							
						</td>
						<td>
							2015年3月1日
						</td>
						<td>
							男
						</td>
						<td>
							本科
						</td>
						<td>
							在职
						</td>
					</tr>
			<tr>
					<td>
					<input type="checkbox">
					</td>
						<td>
						王五
						</td>
						<td>
						19890324
							
						</td>
						<td>
							2015年3月1日
						</td>
						<td>
							男
						</td>
						<td>
							本科
						</td>
						<td>
							在职
						</td>
					</tr>
			<tr>
					<td>
					<input type="checkbox">
					</td>
						<td>
						王五
						</td>
						<td>
						19890324
							
						</td>
						<td>
							2015年3月1日
						</td>
						<td>
							男
						</td>
						<td>
							本科
						</td>
						<td>
							在职
						</td>
					</tr>
			<tr>
					<td>
					<input type="checkbox">
					</td>
						<td>
						王五
						</td>
						<td>
						19890324
							
						</td>
						<td>
							2015年3月1日
						</td>
						<td>
							男
						</td>
						<td>
							本科
						</td>
						<td>
							在职
						</td>
					</tr>
			<tr>
					<td>
					<input type="checkbox">
					</td>
						<td>
						王五
						</td>
						<td>
						19890324
							
						</td>
						<td>
							2015年3月1日
						</td>
						<td>
							男
						</td>
						<td>
							本科
						</td>
						<td>
							在职
						</td>
					</tr>
			<tr>
					<td>
					<input type="checkbox">
					</td>
						<td>
						王五
						</td>
						<td>
						19890324
							
						</td>
						<td>
							2015年3月1日
						</td>
						<td>
							男
						</td>
						<td>
							本科
						</td>
						<td>
							在职
						</td>
					</tr>
			<tr>
					<td>
					<input type="checkbox">
					</td>
						<td>
						王五
						</td>
						<td>
						19890324
							
						</td>
						<td>
							2015年3月1日
						</td>
						<td>
							男
						</td>
						<td>
							本科
						</td>
						<td>
							在职
						</td>
					</tr>
			<tr>
					<td>
					<input type="checkbox">
					</td>
						<td>
						王五
						</td>
						<td>
						19890324
							
						</td>
						<td>
							2015年3月1日
						</td>
						<td>
							男
						</td>
						<td>
							本科
						</td>
						<td>
							在职
						</td>
					</tr>
			<tr>
					<td>
					<input type="checkbox">
					</td>
						<td>
						王五
						</td>
						<td>
						19890324
							
						</td>
						<td>
							2015年3月1日
						</td>
						<td>
							男
						</td>
						<td>
							本科
						</td>
						<td>
							在职
						</td>
					</tr>
			<tr>
					<td>
					<input type="checkbox">
					</td>
						<td>
						王五
						</td>
						<td>
						19890324
							
						</td>
						<td>
							2015年3月1日
						</td>
						<td>
							男
						</td>
						<td>
							本科
						</td>
						<td>
							在职
						</td>
					</tr>
			<tr>
					<td>
					<input type="checkbox">
					</td>
						<td>
						王五
						</td>
						<td>
						19890324
							
						</td>
						<td>
							2015年3月1日
						</td>
						<td>
							男
						</td>
						<td>
							本科
						</td>
						<td>
							在职
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
</div>
</div>
<jsp:include page="foot.jsp" />
</body>
</html>