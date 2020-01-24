$(function() {
	//所有订单
	getAllOrder(-1,1);
	
	
	$("#badge_num").hide();
	$("#page_num").val(1);
	
	//刷新页面后清空文本框
	$("#searchBox").val("");
	$(".change_order_tab").click(function(){
		var state = $(this).data("state");
		var page = parseInt($("#page_num").val());
		getAllOrder(state,page);
	});
	$("#page_container").delegate(".change_page","click", function(){
		//window.open('project_one.jsp?pid='+$(this).attr('id')) ;
		//alert("打开店铺 id="+$(this).attr('page'));
		
		var page1 = $(this).data('page');
		var state1 = $(this).data('state');
		$("#page_num").val(page1);
		getAllOrder(state1,page1);
		
	});
	
	//关键字查询订单
	$("#search_btn").click(function(){
		var page = parseInt($("#page_num").val());
		searchOrder(page);
	});
	
	//点击接单和派送按钮
    $('#tablebody').delegate('.btn-ordercheck', 'click', function() {
        //将该button交给pointer指针
        var pointer = $(this);
        var id = $(this).parents("tr").attr("id");
        var buttonState=$(this).data('state');
        var orderTargetState=0;
        if(buttonState=="receive")
        {
            orderTargetState=2;
            
        }
        else 
        {
            if(buttonState=="deliver")
            orderTargetState=3;
        }
        
        updateOrderState(id,orderTargetState,pointer);

    }); 
});

//更改订单状态
function updateOrderState(id,orderTargetState,pointer){
    
    //将变更后的state回传到回调函数中
    updateOrderState_render.state=orderTargetState;
    updateOrderState_render.pointer=pointer;
    $.post("OrderServlet", {
            op : "update_order_state_by_order_id_and_target_state",
            id:id,
            order_state : orderTargetState
            //获取店铺id 加入联合查询
                
        }, updateOrderState_render, "xml");
}

//更改订单状态回调函数

function updateOrderState_render(data){
    var state = updateOrderState_render.state;
     var pointer = updateOrderState_render.pointer;
     var newbadge=parseInt($("#badge_num").text())-1;

     //更改后的状态为已接
     if(state==2)
    {     
         alert("成功接单！");
        pointer.parent().prev().empty();
        pointer.parent().prev().html("已接单");
        //修改button
         pointer.parent().html("<button type='button' class='btn btn-default btn-ordercheck' data-state='deliver'>派  送</button>");
    }
    else
    {
        alert("成功派送！");
        pointer.parent().prev().empty();
        pointer.parent().prev().html("订单配送中");
        //修改button
         pointer.parent().html("等待用户确认收货");
         // alert(""+newbadge);
              //修改badge个数
         $("#badge_num").text(newbadge);
         
             // $(#badge_num).text(badge-1);
//              
    }
}


//根据关键字查询订单
function searchOrder(page){
	var keyword = $("#searchBox").val();
	
	if(keyword=="") {
		alert("订单号不能为空！");
		return false;
	}
	
	else{
		$("#order_li_container>li").removeClass("active");
		$("#order_all_li").addClass("active");
		$.post("OrderServlet", {
			op : "get_order_list_by_shop_id_and_keyword",
			keyword:keyword,
			page : page
			//获取店铺id 加入联合查询
				
		}, searchOrder_render, "xml");
	}
}

//查询所有订单
function getAllOrder(state,page){
	searchOrder_render.state=state;
	$.post("OrderServlet", {
		op : "get_order_list_by_shop_id_and_order_state",
		order_state : state,
		page : page
	}, searchOrder_render, "xml");
	}


//查询订单的回调函数
function searchOrder_render(data){
	var badge = 0;
	var total = 0;
	//alert("init");
	$("#tablebody").empty();
	badge = $(data).find("result").attr("badge");
	total = $(data).find("result").attr("total");
	//清空table的body
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
		
		
		var buttondesc;
		var statetxt;
		
		switch(state)
		{
		case 0:
			statetxt="未付款";
			buttondesc="等待用户付款";
			break;
			
		case 1:
			statetxt="已付款";
			buttondesc="<button type='button' class='btn btn-default btn-ordercheck' data-state='receive'>接  单</button>";
			break;
		case 2:
			statetxt="已接单";
			buttondesc="<button type='button' class='btn btn-default btn-ordercheck' data-state='deliver'>派  送</button>";
			break;
		case 3:
			statetxt="订单配送中";
			buttondesc="等待用户确认收货";
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
						createtime+
						"</td>"+
						"<td class='orderState'>"+statetxt+
							"</td>"+
						"<td>"
							 +buttondesc+
						"</td>"+
					"</tr>");
		$("#tablebody").append($order);	//将这个shop对象加入shop_list_container中
		
	});
	//开始绘制翻页  total
	var page = parseInt($("#page_num").val());
	var num = parseInt(total/10);
	if(total%10>0){
		num++;
	}

	var $pageli;		//新建一个shop变量，存html
	$("#page_container").empty();
	
	var index = page;
	if(page>1){
		index=page-1;
	}
	//alert(page+"_"+index);
	$pageli = $("<li><a href='#' data-page='"+index+"' data-state='"+searchOrder_render.state+"' class='change_page'>上一页</a></li>");
	$("#page_container").append($pageli);
	
	$pageli = $("<li><a href='#' data-page='"+page+"' data-state='"+searchOrder_render.state+"' class='change_page'>"+page+"/"+num+"</a></li>");
	$("#page_container").append($pageli);
	
	index = num;
	if(page<num){
		index=page+1;
	}
	$pageli = $("<li><a href='#' data-page='"+index+"' data-state='"+searchOrder_render.state+"' class='change_page'>下一页</a></li>");
	$("#page_container").append($pageli);
	
	
	//如果是所有order，则执行下面判断badge
		if(badge>0){
			//alert("0");
			$("#badge_num").show();
			$("#badge_num").text(badge);
		}else{
			$("#badge_num").hide();
		}
		
	
	
}




