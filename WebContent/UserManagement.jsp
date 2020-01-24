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
<script src="${pageContext.request.contextPath}/js/UserManagement.js" type="text/javascript"></script>

<title>会员管理</title>
<style>
input{
margin-left:10%;
}
</style>


</head>
<body>
<input type="hidden" id="pagenum" value="2">
	<jsp:include page="header.jsp" />

		<div class="container-fluid">
	<div class="row-fluid">
		<div class="span1">
		</div>
		<div class="span2">
			<ul class="nav nav-list well">
				<li class="nav-header" id="MyShop">
					管理员中心
				</li>
				<li >
					<a class="mybadge myactive" href="UserManagement.jsp">会员管理</a>
					 
				</li>
				<li>
					<a href="DealerManagement.jsp">商户管理</a>
				</li>
				
			</ul>
		</div>
		<div class="span8">
<h3 id="MyOrder">
<span  class="ng-binding">会员管理</span>
     <img alt="186x55" id="searchbox_img" src="css/images/MyShop_searchboxboy.jpg" />
</h3>
			<div class="row-fluid" style="margin-bottom:30px">
			
                <div class="form-search">
              <input class="input-medium search-query" id="searchBox" type="text" placeholder="请输入账户名关键字"> 
                  <button type="submit" id="search_btn" class="btn" contenteditable="true">搜索</button>
                  <input id="delete" type="submit" class="btn" contenteditable="true" onclick="del_tbl('User_table','code_Value')" value="删除选中">
                </div>

				</div>
	<form name="formGroup" id="formGroup" action="#" method="post" target="_self">  
			<table class="table" id="User_table">
				<thead id="tableheader">
					<tr>
						<th>

							<input name="" type="checkbox" onClick="CheckSelect(this.form);return false;">选择

						</th>
						<th>
							会员账户
						</th>
						
						<th>
							邮箱
						</th>
						<th>
							手机号
						</th>
						
					</tr>
				</thead>
				<tbody id="tablebody">
					<tr>
						<td>
						
					<input name="code_Value" id="code_Value" type="checkbox" >
					
						</td>
						<td>
						<a href="#">maleihahaha1</a>
							
						</td>
						
						<td>
							@123.com
						</td>
						<td>
							12312341234
						</td>
					</tr>
					<tr>
						<td>
						
					<input name="code_Value" id="code_Value" type="checkbox" >
					
						</td>
						<td>
						<a href="#">maleihahaha2</a>
							
						</td>
						
						<td>
							@123.com
						</td>
						<td>
							12312341234
						</td>
					</tr>
					<tr>
						<td>
						
					<input name="code_Value" id="code_Value" type="checkbox" >
					
						</td>
						<td>
						<a href="#">maleihahaha3</a>
							
						</td>
						
						<td>
							@123.com
						</td>
						<td>
							12312341234
						</td>
					</tr>
					<tr>
						<td>
						
					<input name="code_Value" id="code_Value" type="checkbox" >
					
						</td>
						<td>
						<a href="#">maleihahaha4</a>
							
						</td>
						
						<td>
							@123.com
						</td>
						<td>
							12312341234
						</td>
					</tr>
					<tr>
						<td>
						
					<input name="code_Value" id="code_Value" type="checkbox" >
					
						</td>
						<td>
						<a href="#">maleihahaha5</a>
							
						</td>
						<td>
						01/02/2016

						</td>
						<td>
							@123.com
						</td>
						<td>
							12312341234
						</td>
					</tr>
					<tr>
						<td>
						
					<input  name="code_Value" id="code_Value" type="checkbox" >
					
						</td>
						<td>
						<a href="#">maleihahaha6</a>
							
						</td>
						<td>
						01/02/2016

						</td>
						<td>
							@123.com
						</td>
						<td>
							12312341234
						</td>
					</tr>
					
				</tbody>
			</table>
			</form>
			<div class="pagination pagination-right">
					<ul id="pageID">
						<li><a href="javascript:void(0)" onclick="(PageButtonPressed())">上一页</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">下一页</a></li>
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