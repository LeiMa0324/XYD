<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



		
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<link href="${pageContext.request.contextPath}/css/xyd.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/find_pwd.css" type="text/css" rel="stylesheet" />

<script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/xyd.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/find_pwd.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/footer.css" type="text/css" rel="stylesheet" />

<title>找回密码</title>

</head>
<body>
<div id="login">
    <div class="wrapper">
    <a  href="${pageContext.request.contextPath}/home.jsp">
    <img alt="im a ad" id="login_nav" src="css/images/sunshine_min.png" />
    </a>
        <div class="login">
            <div class="container offset1 loginform">
                <div class="container w960 mt20">
			<div id="processor" >
				<ol class="processorBox oh">
					<li class="current">
						<div class="step_inner fl">
							<span class="icon_step">1</span>
							<h4>填写账号信息</h4>
						</div>
					</li>
					<li>
						<div class="step_inner">
							<span class="icon_step">2</span>
							<h4>填写邮箱验证码</h4>
						</div>
					</li>
					<li>
						<div class="step_inner fr">
							<span class="icon_step">3</span>
							<h4>设置新的密码</h4>
						</div>
					</li>
				</ol>
				<div class="step_line"></div>
			</div>
			<div class="content">
				<div id="step1" class="step hide">
					<div  id="step1_frm">
						<div class="frm_control_group">
							<label class="frm_label">账号</label>
							<div class="frm_controls">
								<input id="account" type="text" name="" class="frm_input email" maxlength="32" placeholder="请输入注册时填写的账号"/>
							</div>
						</div>
						<div class="frm_control_group">
							<label class="frm_label">邮箱</label>
							<div class="frm_controls">
								<input id="email" type="text" name="" class="frm_input email" maxlength="32" placeholder="请输入注册时填写的邮箱"/>
							</div>
						</div>
						<div class="toolBar">
							<a id="send_email_btn" class="btn btn_primary" href="javascript:;">下一步</a>
						</div>
					</div>
				</div><!-- // step1 end -->
				<div id="step2" class="step hide">
					<div class="w330">
						<strong class="f16">验证信息已经发送至您的邮箱: <br /><span id="step2_email"> </span></strong>
						<p class="c7b">请进入邮箱查看邮件，并在下方输入您获得的验证码。</p>
						<div class="frm_control_group">
							<label class="frm_label">验证码</label>
							<div class="frm_controls">
								<input id="identify_code" type="text" name="" class="frm_input name" maxlength="32"/>
								<p class="frm_tips">请填写您收到的验证码</p>
							</div>
						</div>
						<div class="toolBar">
							<a id="check_identify_code_btn" class="btn btn_primary" href="javascript:;">下一步</a>
						</div>
						<p class="c7b mt20">没有收到邮件？</p>
						<p>1. 请检查邮箱地址是否正确，你可以返回 <a href="#" class="c46">重新填写</a></p>
						<p>2. 检查你的邮件垃圾箱</p>
						<p>3. 若仍未收到确认，请尝试 <a href="#" class="c46">重新发送</a></p>
					</div>
				</div><!-- // step2 end -->
				<div id="step3" class="step hide">
					<div id="step3_frm">
						<div class="frm_control_group">
							<label class="frm_label">新的密码</label>
							<div class="frm_controls">
								<input type="hidden" id="account_hidden" value=""/>
								<input type="hidden" id="identify_code_hidden" value=""/>
								<input id="password" type="password" name="" class="frm_input name" maxlength="32"/>
								<p class="frm_tips">请填写新的密码</p>
							</div>
						</div>
						<div class="frm_control_group">
							<label class="frm_label">确认密码</label>
							<div class="frm_controls">
								<input id="password_re" type="password" name="" class="frm_input phone"/>
								<p class="frm_tips">请填确认新的密码</p>
							</div>
						</div>
						<div class="toolBar">
							<a id="set_new_pwd_btn" class="btn btn_primary" href="javascript:;">完成</a>
						</div>
					</div>
				</div><!-- // step3 end -->
			</div>
		</div><!-- // container end -->
            </div>
        </div>
        <jsp:include page="foot.jsp" />
    </div>
  
</div>


</body>
</html>