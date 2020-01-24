$(function() 
	{
		getShopInfo();
		getAllOrder();	
	});
function getShopInfo()
{
	var id= document.getElementById("shopId").value;
    
	 $.post
	 ("/XYD/ShopServlet",
	  {
		 id:id,
	    op:"get_shop_by_id",
	 
	}, 
	getShopInfoCallBack
	  );
}
function getShopInfoCallBack(data,status)
{
	alert("Data: " + data + "nStatus: " + status);
	var count=0;
	$("#shoptable").empty();
	$(data).find("shop").each(function()
			{
				count++;
				var name = $(this).attr("name");
				var account = $(this).attr("account");
				var id = $(this).attr("id");
				var img = $(this).attr("img");
				var phone = $(this).attr("phone");
				var addr_desc = $(this).attr("addr_desc");
				//var state = $(this).attr("state");
				if (count<9)
				{
//					$shop = $("<tr><td rowspan='3'><div class='view'><img alt='140x140' src='img/a.jpg'></div></td><td>"+name+"</td>" +
//							"<td>营业额</td><td>￥1200</td></tr><tr><td>"+phone+"</td><td>订单数</td><td>120</td></tr><tr><td>"+addr_desc+"</td></tr>");		
				$shop = $("<tr><td rowspan='3'><div class='view'><img alt='140x140' style='width:140px;height:140px;' src=PicDownloadServlet?file_name="+img+"></div></td><td>"+name+"</td>" +
						"<td>营业额</td><td>￥1200</td></tr><tr><td>"+phone+"</td><td>订单数</td><td>120</td></tr><tr><td>"+addr_desc+"</td></tr>");		
				$("#shoptable").append($shop);
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
function getAllOrder()
{
	 var id= document.getElementById("shopId").value;
    
	 $.post
	 ("/XYD/OrderServlet",
	  {
		 id:id,
	    op:"get_order_list_by_shop_id",
	 
	}, 
	getAllOrderCallBack
	  );
}
function getAllOrderCallBack(data,status)
{
	//alert("Data: " + data + "nStatus: " + status);
	var count=0;
	$("#tablebody").empty();
	$(data).find("order").each(function() {		//在xml中找到shop标签 对于每一个shop 执行如下函数，类似一个for循环
		var id = $(this).attr("id");	//将每一个shop中的标签都抓出来
		var num = $(this).attr("num");
		var address = $(this).attr("address");
		var price_sum = $(this).attr("price_sum");
		var user_id = $(this).attr("user_id");
		var createtime = $(this).attr("createtime"); 
		var shop_id = $(this).attr("shop_id");
		var review_flag = $(this).attr("review_flag");
		var review_detail = $(this).attr("review_detail");
		var review_level = $(this).attr("review_level");
		var state = parseInt(($(this).attr("state")));	
		
var statetxt;
		
		switch(state)
		{
		case 0:
			statetxt="未付款";
			
			break;
			
		case 1:
			statetxt="已付款";
			
			break;
		case 2:
			statetxt="已接单";
		
			break;
		case 3:
			statetxt="订单配送中";
			
			break;
		case 4:
			statetxt="已完成";
		
			break;
		case 5:
			statetxt="已取消";
		
			break;
		}
			
		var $order;		
		
		$order = $("<tr><td>"+createtime+"</td><td>"+num+"</td>" +
				"<td>" +"<a href='javascript:void(0)' class='pageClass' id ="+id+">" +
						"" +id+"</a></td><td>"+price_sum+"</td><td>"+statetxt+
							"</td></tr>");
		
		$("#tablebody").append($order);	//将这个shop对象加入shop_list_container中
		
	});
}
