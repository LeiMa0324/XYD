$(function() {
	get_email_phone();
	$("#modifyinfo_btn").click(modifyinfo);
});

//获取账户的邮箱和电话
function get_email_phone(){
	$.post("UserServlet", {
		op : "get_userinfo"
	   }, info_render, "xml");
		
}

//回调页面写入账户的邮箱电话
function info_render(data){
		var email = $(data).find("user").attr("email");
		var phone = $(data).find("user").attr("phone");
		$("#email_conf").val(email);
		$("#phone_conf").val(phone);
		//alert("Data: " + email +phone );
}


function modifyinfo(){
	var email = $("#email_conf").val();
	var phone = $("#phone_conf").val();
	
	var EmailReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; //邮件正则
	if(email==""||phone=="") {
		alert("邮箱/联系方式不能为空");
	} else if(!EmailReg.test(email)){
		alert("您的邮箱格式错误");
	}else{
		alert("Data: " + email +phone );
		$.post("UserServlet", {
			op : "modify_info",
			email : email,
			phone: phone,			
		},function(){
		     alert("信息修改成功");
		   });
	}
}





