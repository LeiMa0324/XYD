<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.seu.xyd.servlet.XYDSessionTimeout"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%
	String error = "未知异常,请联系管理员";
	if(exception != null) 
		error = exception.getMessage();
	
	if (exception instanceof XYDSessionTimeout) {
	        response.sendRedirect("timeout_error.jsp");
	    }
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />

<script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" type="text/css" rel="stylesheet">

<title>数据分析管理系统</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="wrapper">
		<div class="container">
			<%=error %>
		</div>
	</div>
<jsp:include page="foot.jsp" flush="false" />
</body>
</html>