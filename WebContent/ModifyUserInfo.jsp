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
<link href="${pageContext.request.contextPath}/css/header.css" type="text/css" rel="stylesheet" />

<script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/xyd.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/index.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-jqLoding.js" type="text/javascript"></script>


<title>修改会员信息</title>
<style>
input,.btn-group{
margin-left:10%;
}
</style>
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
					用户中心
				</li>
				<li >
					<a href="#">我的订单</a>					 
				</li>
				<li >
					<a href="#">会员充值</a>					 
				</li>
				<li >
					<a href="#">充值记录</a>					 
				</li>
				<li>
					<a class="mybadge myactive" href="ModifyUserInfo.jsp">修改会员信息</a>
				</li>
				<li >
					<a href="#">我的购物车</a>					 
				</li>
			</ul>
		</div>
		<div class="span8">
<h3 id="MyOrder">
<span  class="ng-binding">修改会员信息</span>
     <img alt="186x55" id="searchbox_img" src="css/images/MyShop_searchboxboy.jpg" />
</h3>
	<table class="table">
				<thead id="tableheader">
					<tr>
						<th>
							个人信息
						</th>
					</tr>
				</thead>
				<tbody>
					
					<tr>
						<td>
						<label class="control-label" for="inputEmail" contenteditable="true">用户名</label>
						</td>
						<td style="text-align:left">
						<input type="text">
						</td>
						<td>
						<label class="control-label" for="inputEmail" contenteditable="true">原密码</label>
						</td>
						<td style="text-align:left">
						<input type="text">
						</td>
						
					</tr>
					<tr>
						<td>
						<label class="control-label" for="inputEmail" contenteditable="true">email</label>
						</td>
						<td style="text-align:left">
						<input type="text">
						</td>
						<td>
						<label class="control-label" for="inputEmail" contenteditable="true">新密码</label>
						</td>
						<td style="text-align:left">
						<input type="text">
						</td>
						
					</tr>
					<tr>
						<td>
						<label class="control-label" for="inputEmail" contenteditable="true">手机</label>
						</td>
						<td style="text-align:left">
						<input type="text">
						</td>
						<td>
						<label class="control-label" for="inputEmail" contenteditable="true">确认密码</label>
						</td>
						<td style="text-align:left">
						<input type="text">
						</td>
						
					</tr>
					<tr>
					<td></td>
					<td></td>
					<td></td>
					<td>
					 <button type="submit" class="btn" contenteditable="true">确认修改</button>
					 </td>
					</tr>			
				</tbody>
			</table>		
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
              
                <div class="btn-group">
                  <button class="btn" contenteditable="true">江苏</button>
                  <button data-toggle="dropdown" class="btn dropdown-toggle"><span class="caret"></span></button>
                  <ul class="dropdown-menu" contenteditable="true">
                    <li><a href="#">浙江</a></li>
                    <li><a href="#">河北</a></li>
                    <li><a href="#">广东</a></li>
                
                  </ul>
                </div>
  
                 <div class="btn-group">
                  <button class="btn" contenteditable="true">南京</button>
                  <button data-toggle="dropdown" class="btn dropdown-toggle"><span class="caret"></span></button>
                  <ul class="dropdown-menu" contenteditable="true">
                    <li><a href="#">苏州</a></li>
                    <li><a href="#">常州</a></li>
                    <li><a href="#">徐州</a></li>
                
                  </ul>
                </div>
							 <div class="btn-group">
                  <button class="btn" contenteditable="true">秦淮区</button>
                  <button data-toggle="dropdown" class="btn dropdown-toggle"><span class="caret"></span></button>
                  <ul class="dropdown-menu" contenteditable="true">
                    <li><a href="#">浙江</a></li>
                    <li><a href="#">河北</a></li>
                    <li><a href="#">广东</a></li>
                
                  </ul>
                </div>
						
						</td>
		
					</tr>
					<tr>
						<td>
						<label class="control-label" for="inputEmail" contenteditable="true">收货人</label>
						</td>
						<td style="text-align:left">
						<input type="text">
						</td>
						<td>
						<label class="control-label" for="inputEmail" contenteditable="true">联系电话</label>
						</td>
						<td style="text-align:left">
						<input type="text">
						</td>
						
					</tr>
					<tr>
						<td>
						<label class="control-label" for="inputEmail" contenteditable="true">详细地址</label>
						</td>
						<td style="text-align:left">
						<input type="text">
						</td>
						
					</tr>
					
					<tr>
					<td></td>
					<td></td>
					<td></td>
					<td>
					 <button type="submit" class="btn" contenteditable="true">确认修改</button>
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