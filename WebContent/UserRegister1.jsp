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
<script src="${pageContext.request.contextPath}/js/register.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-jqLoding.js" type="text/javascript"></script>


<title>会员注册1</title>
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
		<div class="span2">
		</div>
		<div class="span5">
  <table class="table">
				<thead id="tableheader">
					<tr>
						<th>
							新用户注册
						</th>
					</tr>
				</thead>
				<tbody>
					
		<tr>
			<td>
			<label  class="control-label" for="inputEmail" contenteditable="true"><span style="color:#C00">*</span>用户名</label>
			</td>
			<td style="text-align:left">
			<input id="account" type="text">
			</td>
		</tr>
<tr>
<td>
			<label  class="control-label" for="inputEmail" contenteditable="true"><span style="color:#C00">*</span>email</label>
			</td>
			<td style="text-align:left">
			<input id="email" type="text">
			</td>
	</tr>
		<tr>
			<td>
				<label  class="control-label" for="inputEmail" contenteditable="true"><span style="color:#C00">*</span>密码</label>
			</td>
			<td style="text-align:left">
			<input id="password" type="text">
			</td>
			
					</tr>
					<tr>
						<td>
							<label  class="control-label" for="inputEmail" contenteditable="true"><span style="color:#C00">*</span>确认密码</label>
						</td>
						<td style="text-align:left">
						<input id="password_re" type="text">
						</td>
						
					</tr>
					<tr>
						<td>
							<label class="control-label" for="inputEmail" contenteditable="true"><span style="color:#C00">*</span>电话</label>
						</td>
						<td style="text-align:left">
						<input id="phone" type="text">
						</td>
						
					</tr>
<tr>
	<td></td>
<td style="text-align:left">					
<button type="submit" class="btn" id="register_btn" style="margin-left:10%" contenteditable="true">下一步</button>
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