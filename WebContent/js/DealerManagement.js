$(function() 
		{
	//所有用户
	getAllShop();	
	$("#searchBox").val("");
	//关键字查询用户
	$("#search_btn").click(searchShop);

});

function getAllShop()
{
	var r= document.getElementById("pagenum").value;
	 $.post
	 ("/XYD/ShopServlet",
	  {
	    page:r,
	    op:"get_All_Shops"
	  
	}, 
	getAllShopCallBack
	  );
}
function getAllShopCallBack(data,status)
{
	alert("Data: " + data + "nStatus: " + status); 
	

	var count=0;
	$("#tablebody").empty();
	//$("#pageID").empty();//清空html页面
	$(data).find("shop").each(function()
	{
		count++;
		var name = $(this).attr("name");
		var account = $(this).attr("account");
		var id = $(this).attr("id");
		var phone = $(this).attr("phone");
		var addr_desc = $(this).attr("addr_desc");
		//var state = $(this).attr("state");
		if (count<9)
		{
//		$shop = $("<tr><td><input name='code_Value' id='code_Value' type='checkbox'></td><td><a href='#'>"+
//				account+"</a></td><td>"+email+"</td><td>"+phone+"</td></tr>");
		$shop = $("<tr><td><input type='checkbox'></td><td>"+name+"</td><td><a href='javascript:void(0)' class='pageClass' id ="+id+">" +
				account+"</a></td><td>"+phone+"</td><td>"+addr_desc+"</td><td>123</td></tr>");
						
		$("#tablebody").append($shop);
		}
	
	});
	$.each($('.pageClass'),function(i,btn)
			{
				$(btn).click
				(
						function()
						{
				
						 window.location.replace("DealerReport.jsp?id="+$(this).attr('id'));
						}
				);
				}
			);
}
function searchShop(){
	var keyword = $("#searchBox").val();
	
	if(keyword=="") 
	{
		alert("商户账户不能为空！");
		return false;
		
	}	
	else{
	
	$.post("/XYD/ShopServlet",
			{
		op : "get_Shop_List_By_Keyword",
		search_user_keyword:keyword,
		user_page:1
		//获取用户id 加入联合查询
			
	}, getAllShopCallBack, "xml");
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




