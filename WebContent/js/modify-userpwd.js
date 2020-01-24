$(function() {
	$("#modifypwd_btn").click(modifypwd);
});

//修改账户密码
function modifypwd(){
	var oldpassword = $("#OldPassword").val();
	var newpassword = $("#NewPassword").val();
	var newpassword_re = $("#NewPassword_re").val();
	if(oldpassword=="") {
		alert("请填写原密码");
	}else if(newpassword==""||newpassword_re=="") {
		alert("请填写新密码/确认密码");
	} else if(newpassword!=newpassword_re) {
		alert("两次填写密码不一致");
	}else{
		$.post("UserServlet", {
			op : "modify_pwd",
			pw : oldpassword,
			pw_new : newpassword
		}, function(data){
		     alert("修改密码成功，请重新登录" );
		     window.location.href = "login.jsp";
		   });
	}
}



