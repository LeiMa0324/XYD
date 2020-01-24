$(function() {
	//所有订单
	getAllOrder();
	
	//关键字查询订单
	$("#search_btn").click(searchOrder);

});

function searchOrder(){
	var keyword = $("#searchBox").val();
	
	if(keyword=="") {
		alert("订单号不能为空！");
		return false;
	}
	
	else{
	
	$.post("OrderServlet", {
		op : "get_order_list_by_shop_id_and_keyword",
		keyword:keyword
		//获取店铺id 加入联合查询
			
	}, searchOrder_render, "xml");
	}
}

function getAllOrder(){

	$.post("OrderServlet", {
		op : "get_order_list_by_shop_id",	
	}, searchOrder_render, "xml");
	}



function searchOrder_render(data){
	//alert("init");
	$("#tablebody").empty();
	//清空table的body
	$(data).find("order").each(function() {		//在xml中找到shop标签 对于每一个shop 执行如下函数，类似I一个for循环
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
		var buttondesc;
		var statetxt;
		
		switch(state)
		{
		case 0:
			statetxt="未付款";
			buttondesc="付款";
			break;
			
		case 1:
			statetxt="已付款";
			buttondesc="";
			break;
		case 2:
			statetxt="已接单";
			buttondesc="";
			break;
		case 3:
			statetxt="订单配送中";
			buttondesc="";
			break;
		case 4:
			statetxt="已完成";
			buttondesc="";
			break;
		case 5:
			statetxt="已取消";
			buttondesc="";
			break;


		}
		
		
		var $order;		//新建一个shop变量，存html
		$order = $(	"<tr id='"+id+"'>"+
						"<td>"+
						"<p>"+
							"<a href='#''>"+num+"</a>"+
							"</p>"+
						"</td>"+
						"<td>"+
						"<a href='MyShop_customer.jsp'>"+user_id+"</a>"+	//如何传值到customer
						"</td>"+
						"<td>"+
						"<a>"+createtime+"</a>"+
						"</td>"+
						"<td>"+statetxt+
							"</td>"+
						"<td>"+
							 "<button type='button' class='btn btn-default btn-ordercheck'>"+buttondesc+"</button>"+
						"</td>"+
					"</tr>");
		$("#tablebody").append($order);	//将这个shop对象加入shop_list_container中
		
	});
}




