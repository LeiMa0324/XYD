$(function() {
	$("#register_btn").click(register);
});

function register(){
	var account = $("#account").val();
	var password = $("#password").val();
	var password_re = $("#password_re").val();
	var email = $("#email").val();
	var phone = $("#phone").val();
	if(account=="") {
		alert("账号不能为空");
		return false;
	}
	if(password=="") {
		alert("密码不能为空");
		return false;
	}
	if(password!=password_re) {
		alert("您输入的密码前后不一致");
		return false;
	}
	if(email=="") {
		alert("邮箱不能为空");
		return false;
	}
	if(phone=="") {
		alert("电话不能为空");
		return false;
	}
	
	$.post("UserServlet", {
		op : "register",
		account : account,
		pw : password,
		email : email,
		phone : phone,
	}, register_render, "xml");
}

function register_render(data){
	//alert("render");
	window.location.href = "home.jsp";







function enterkeydown(){
//	if ($(this).val().length == 0)
//		return;
//
//	if (navigator.appName == "Microsoft Internet Explorer") {
//		if (event.keyCode == 13) {
//			login();
//		}
//	} else {
//		if (event.which == 13) {
//			login();
//		}
//	}
}
}