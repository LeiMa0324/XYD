$(function() 
		{
	//所有用户
	getAllUser();	
	//关键字查询用户
	$("#search_btn").click(searchUser);

});

function getAllUser()
{
	var r= document.getElementById("pagenum").value;
	 $.post
	 ("/XYD/UserServlet",
	  {
	    page:r,
	    op:"get_user_with_admin"
	  
	}, 
	getAllUserCallBack
	  );
}
function getAllUserCallBack(data,status)
{
	alert("Data: " + data + "nStatus: " + status); 
	

	var count=0;
	$("#tablebody").empty();
	//$("#pageID").empty();//清空html页面
	$(data).find("user").each(function()
	{
		count++;
		var account = $(this).attr("account");
		var email = $(this).attr("email");
		var phone = $(this).attr("phone");
		//var state = $(this).attr("phone");
		if (count<9)
		{
		$shop = $("<tr><td><input name='code_Value' id='code_Value' type='checkbox'></td><td><a href='#'>"+
				account+"</a></td><td>"+email+"</td><td>"+phone+"</td></tr>");
		
		
		$("#tablebody").append($shop);
			
		}
	});
}
function searchUser(){
	var keyword = $("#searchBox").val();
	
	if(keyword=="") 
	{
		alert("用户名不能为空！");
		return false;

	}

	else{
	
	$.post("/XYD/UserServlet",
			{
		op : "getUserListByKeyword",
		search_user_keyword:keyword,
		user_page:1
		//获取用户id 加入联合查询
			
	}, getAllUserCallBack, "xml");
	}
}




function searchUser_render(data){
	//alert("init");
	$("#tablebody").empty();
	//清空table的body
	$(data).find("user").each(
			function() {		//在xml中找到shop标签 对于每一个shop 执行如下函数，类似I一个for循环
		var id = $(this).attr("id");	//将每一个shop中的标签都抓出来
		var account = $(this).attr("account");
		var email = $(this).attr("email");
		var phoneNum = $(this).attr("phoneNum");
		
		var state = parseInt(($(this).attr("state")));	
		
	
		
		var $user;		//新建一个shop变量，存html
		$user = $(	"<tr id='"+id+"'>"+
						"<td>"+
						"<p>"+
							"<a href='#''>"+account+"</a>"+
							"</p>"+
						"</td>"+
						"<td>"+
						"<a href='#''>"+email+"</a>"+	//如何传值到customer
						"</td>"+
						"<td>"+
						"<a>"+phoneNum+"</a>"+
						"</td>"+
//						"<td>"+statetxt+
//							"</td>"+
//						"<td>"+
//							 "<button type='button' class='btn btn-default btn-ordercheck'>"+buttondesc+"</button>"+
//						"</td>"+
					"</tr>");
		$("#tablebody").append($user);	//将这个shop对象加入shop_list_container中
		
	});
}




