$(function() {
	checkAddress();
	
	$("#shop_list_container").delegate(".shop_container","click", function(){
		//alert("打开店铺 id="+$(this).attr('id'));
		window.location.href = "ShopDetail.jsp?id="+$(this).attr('id');
		return false;
	});
	$("#shop_list_container").delegate(".shop_container","mouseenter ", function(){
		$(".shop_container").removeClass("shop_container_mouse_over");
		$(this).addClass("shop_container_mouse_over");
	});
	$("#shop_list_container").delegate(".shop_container","mouseleave  ", function(){
		$(this).removeClass("shop_container_mouse_over");
	});
	
});

function checkAddress(){
	var address = $.cookie("address");
	var lng = $.cookie("lng");
	var lat = $.cookie("lat");
	//alert(address);
	if(address==null||lng==null||lat==null){
		window.location.href = "home.jsp";
	}else{
		$("#address_spn").text(address);
		//开始查询附近商家
		initNearbyShop(lng,lat);
	}
}

function initNearbyShop(lng,lat){
	$.post("ShopServlet", {		//发送shopservlet Post请求
		op : "get_nearby_shop",
		lng : lng,
		lat : lat
	}, initNearbyShop_render, "xml");
}

function initNearbyShop_render(data){
	//alert("init");
	$("#shop_list_container").empty();	//清空shop_list_container
	$(data).find("shop").each(function() {
		var id = $(this).attr("id");
		var name = $(this).attr("name");
		var img = $(this).attr("img");
		var phone = $(this).attr("phone");
		var desc = $(this).attr("desc");
		var addrProv = $(this).attr("addr_prov");
		var addrCity = $(this).attr("addr_city");
		var addrArea = $(this).attr("addr_area");
		var addrDesc = $(this).attr("addr_desc");
		var length = parseFloat($(this).attr("length"));	
		var lengthStr = "";
		if(length<1){
			lengthStr = (length.toFixed(2)*1000)+"米";
		}else{
			lengthStr = length.toFixed(1)+"千米";
		}
		var $shop;
		$shop = $("<div id='"+id+"' class='shop_container'>"+
					"<div class='shop_container_head'>"+
						"<div class='shop_img_container'>"+
							"<img class='shop_img' src='img/shop_logo.jpg' />"+
						"</div>"+
						"<div class='shop_info_container'>"+
							"<div>"+
							"<span class='shop_name'>"+name+"</span>"+
							"</div>"+
							"<div class='shop_order_num'>"+
							"<span style='color: gray;'>月售：</span>"+
							"<span style='color: black;'>23</span>"+
							"<span style='color: gray;'>单</span>"+
							"</div>"+
							"<div class='shop_order_num'>"+
							"<span style='color: gray;'>距离：</span>"+
							"<span style='color: black;'>"+lengthStr+"</span>"+
							"</div>"+
						"</div>"+
					"</div>"+
					"<div>"+
						"<div style='margin-top: 10px;'>"+
							"<span style='color: gray;'>地址：</span>"+
							"<span style='color: gray;'>"+addrDesc+"</span>"+
						"</div>"+
						"<div style='margin-top: 10px;'>"+
							"<span style='color: gray;'>电话：</span>"+
							"<span style='color: gray;'>"+phone+"</span>"+
						"</div>"+
						"<div style='margin-top: 10px;'>"+
							"<span style='color: gray;'>描述：</span>"+
							"<span style='color: gray;'>"+desc+"</span>"+
						"</div>"+
					"</div>"+
					"</div>");
		$("#shop_list_container").append($shop);
		
	});
}




