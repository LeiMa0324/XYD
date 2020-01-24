$(function() {
	$("#send_email_btn").click(sendEmail);
	$("#check_identify_code_btn").click(checkIdentifyCode);
	$("#set_new_pwd_btn").click(setNewPwd);
});

function sendEmail(){
	var account = $("#account").val();
	var email = $("#email").val();
	var EmailReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; //邮件正则
	if(account==""||email=="") {
		showTips("账号/邮箱不能为空");
	}else if(!EmailReg.test(email)){
		showTips('您的邮箱格式错咯~');
	}else{
		$("#account_hidden").val(account);
		$("#step2_email").text(email);
		$.post("UserServlet", {
			op : "find_pwd_step1",
			account : account,
			email : email
		}, sendEmail_render, "xml");
	}
}

function sendEmail_render(data){
	showTips('提交成功~ 即将进入下一步',2500,1);
	$('.processorBox li').removeClass('current').eq(1).addClass('current');
	$('.step').fadeOut(300).eq(1).fadeIn(500);
}

function showTips(txt,time,status)
{
	var htmlCon = '';
	if(txt != ''){
		if(status != 0 && status != undefined){
			htmlCon = '<div class="tipsBox" style="width:220px;padding:10px;background-color:#4AAF33;border-radius:4px;-webkit-border-radius: 4px;-moz-border-radius: 4px;color:#fff;box-shadow:0 0 3px #ddd inset;-webkit-box-shadow: 0 0 3px #ddd inset;text-align:center;position:fixed;top:25%;left:50%;z-index:999999;margin-left:-120px;"><img src="images/ok.png" style="vertical-align: middle;margin-right:5px;" alt="OK，"/>'+txt+'</div>';
		}else{
			htmlCon = '<div class="tipsBox" style="width:220px;padding:10px;background-color:#D84C31;border-radius:4px;-webkit-border-radius: 4px;-moz-border-radius: 4px;color:#fff;box-shadow:0 0 3px #ddd inset;-webkit-box-shadow: 0 0 3px #ddd inset;text-align:center;position:fixed;top:25%;left:50%;z-index:999999;margin-left:-120px;"><img src="images/err.png" style="vertical-align: middle;margin-right:5px;" alt="Error，"/>'+txt+'</div>';
		}
		$('body').prepend(htmlCon);
		if(time == '' || time == undefined){
			time = 1500; 
		}
		setTimeout(function(){ $('.tipsBox').remove(); },time);
	}
}

function checkIdentifyCode(){
	var identifyCode = $("#identify_code").val();
	if(identifyCode==""){
		showTips("请输入验证码");
		return false;
	}
	$("#identify_code_hidden").val(identifyCode);
	$.post("UserServlet", {
		op : "find_pwd_step2",
		num : identifyCode
	}, checkIdentifyCode_render, "xml");
}

function checkIdentifyCode_render(data){
	showTips('提交成功~ 即将进入下一步',2500,1);
	$('.processorBox li').removeClass('current').eq(2).addClass('current');
	$('.step').fadeOut(300).eq(2).fadeIn(500);
	//
}

function setNewPwd(){
	var password = $("#password").val();
	var password_re = $("#password_re").val();
	
	var identifyCode = $("#identify_code_hidden").val();
	var account = $("#account_hidden").val();
	
	if(password==""||password_re==""){
		showTips("请输入新的密码");
		return false;
	}
	if(password!=password_re){
		showTips("请输入的密码不一致");
		return false;
	}
	$.post("UserServlet", {
		op : "find_pwd_step3",
		pw : password,
		account : account,
		num : identifyCode
	}, setNewPwd_render, "xml");
}

function setNewPwd_render(data){
	showTips('密码修改完成，请重新登录',2500,1);
	window.location.href = "login.jsp";
}



