<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<link href="${pageContext.request.contextPath}/css/xyd.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/login.css" type="text/css" rel="stylesheet" />

<script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/xyd.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/shop_register.js" type="text/javascript"></script>

<title>商户注册</title>

</head>
<body>
<div id="login">
    <div class="wrapper">
	    <a  href="${pageContext.request.contextPath}/home.jsp">
	    <img alt="im a ad" id="login_nav" src="css/images/sunshine_min.png" />
	    </a>
        <div class="login">
            <div  class="container offset1 loginform">
                <div id="owl-login">
                    <div class="hand"></div>
                    <div class="hand hand-r"></div>
                    <div class="arms">
                        <div class="arm"></div>
                        <div class="arm arm-r"></div>
                    </div>
                </div>
                <div class="pad">
               		 <h3>
						商户注册
					</h3>
                    <input type="hidden" name="_csrf" value="9IAtUxV2CatyxHiK2LxzOsT6wtBE6h8BpzOmk=">
                    <div class="control-group">
                        <div class="controls">
                            <label for="account" class="control-label fa fa-user"></label>
                            <input id="account"  name=account placeholder="请输入账号" tabindex="1" autofocus="autofocus" class="form-control input-medium">
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <label for="name" class="control-label fa fa-institution"></label>
                            <input id="name"  name=name placeholder="请输入店铺名称" tabindex="1" autofocus="autofocus" class="form-control input-medium">
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <label for="password" class="control-label fa fa-asterisk"></label>
                            <input id="password" type="password" name="password" placeholder="请输入密码" tabindex="2" class="form-control input-medium">
                        </div>
                    </div>
                     <div class="control-group">
                        <div class="controls">
                            <label for="password_re" class="control-label fa fa-asterisk"></label>
                            <input id="password_re" type="password" name="password_re" placeholder="确认密码" tabindex="2" class="form-control input-medium">
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <label for="email" class="control-label fa fa-envelope"></label>
                            <input id="email" type="email" name="email" placeholder="邮箱" tabindex="2" class="form-control input-medium">
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <label for="phone" class="control-label fa fa-phone"></label>
                            <input id="phone"  name=phone placeholder="联系电话" tabindex="2" class="form-control input-medium">
                        </div>
                    </div>
                     <div class="control-group">
                        <div class="controls">
                            <label for="desc" class="control-label fa fa-comment"></label>
                            <input id="desc"  name=desc placeholder="商家描述" tabindex="2" class="form-control input-medium">
                        </div>
                    </div>
                   
                </div>
                <div class="form-actions"><a href="login.jsp" tabindex="6" class="btn btn-link text-muted">商户登录</a>
                    <button id="register_btn" tabindex="4" class="btn btn-primary">下一步</button>
                </div>
            </div>
        </div>
    </div>
    <script>
    $(function() {

        $('#login #password').focus(function() {
            $('#owl-login').addClass('password');
        }).blur(function() {
            $('#owl-login').removeClass('password');
        });
    });
    </script>
</div>


</body>
</html>