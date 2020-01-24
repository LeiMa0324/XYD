$(function() {
	$("#register_btn").click(register);
});

function register(){
	var account = $("#account").val();
	var name = $("#name").val();
	var password = $("#password").val();
	var password_re = $("#password_re").val();
	var email = $("#email").val();
	var phone = $("#phone").val();
	var desc = $("#desc").val();
	if(account=="") {
		alert("账号不能为空");
		return false;
	}
	if(name=="") {
		alert("店铺名称不能为空");
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
	
	$.post("ShopServlet", {
		op : "register",
		account : account,
		name : name,
		pw : password,
		email : email,
		phone : phone,
		desc : desc
	}, register_render, "xml");
}

function register_render(data){
	//alert("render");
	window.location.href = "Shop_register2.jsp";

}