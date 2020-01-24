<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />

<link href="${pageContext.request.contextPath}/css/jquery-ui-1.10.4.custom.min.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/dams.css" type="text/css" rel="stylesheet" />
<style type="text/css">
	a {
		color:red;
	}
</style>
<title>登录异常</title>
</head>
<body>
	<div id="header">
		<span id="logo">数据分析管理系统</span> <span id="cloud"></span>
	</div>
	<div class="wrapper">
		<div class="container">
			会话超时，请点击&nbsp;&nbsp;<a href="index.jsp">重新登录</a>
			<br />
		</div>
	</div>
	
<script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
</body>
</html>