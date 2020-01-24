$(function() {
	$("#login_btn").click(login);
});

function login(){
	var account = $("#account").val();
	var password = $("#password").val();
	if(account==""||password=="") {
		alert("账号/密码不能为空");
	} else{
		$.post("UserServlet", {
			op : "sigin",
			account : account,
			pw : password
		}, login_render, "xml");
	}
}

function login_render(data){
	//alert("render");
	window.location.href = "index.jsp";
}







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