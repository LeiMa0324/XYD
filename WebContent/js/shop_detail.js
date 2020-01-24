$(function() {
	
	initGoods();
	initShopCard();
	
	$("#goods_list_container").delegate(".goods_container","click", function(){
		//window.open('project_one.jsp?pid='+$(this).attr('id')) ;
		var goodsId = $(this).data("id");
		//alert("打开店商品详情 id:"+goodsId);
		window.open('commodityDetailBuy.jsp?id='+goodsId) ;
		return false;
	});
	var offsetHeight = $(window).height()/2;
	var offsetWidth = $(window).width();
	
	$("#goods_list_container").delegate(".add_to_card","click", function(event){
		var goodsId = parseInt($(this).data("id"));
		//alert("添加至购物车 id:"+goodsId);
		addGoodsToCard(goodsId,initShopCard);
		var addcar = $(this);
		var img = addcar.parent().parent().find('img').attr('src');
		var flyer = $('<img class="u-flyer" src="'+img+'">');
		flyer.fly({
			start: {
				left: event.pageX,
				top: offsetHeight
			},
			end: {
				left: offsetWidth-20,
				top: offsetHeight-20,
				width: 0,
				height: 0
			},
			onEnd: function(){
				//$("#msg").show().animate({width: '250px'}, 200).fadeOut(500);
				//addcar.css("cursor","default").removeClass('orange').unbind('click');
				this.destory();
			}
		});
		
		
		return false;
	});
	
	
	$("#goods_list_container").delegate(".goods_container","mouseenter ", function(){
		$(".goods_container").removeClass("goods_container_mouse_over");
		$(this).addClass("goods_container_mouse_over");
	});
	$("#goods_list_container").delegate(".goods_container","mouseleave  ", function(){
		$(this).removeClass("goods_container_mouse_over");
	});
	$("#goods_list_container").delegate(".add_to_card","mouseenter ", function(){
		$(".add_to_card").removeClass("add_to_card_big");
		$(this).addClass("add_to_card_big");
	});
	$("#goods_list_container").delegate(".add_to_card","mouseleave  ", function(){
		$(this).removeClass("add_to_card_big");
	});
	
	$("#jtc-item-goods-container").delegate(".p-del","click", function(){
		var id = $(this).data("id");
		//alert("------删除购物车的商品-------"+id);
		removeGoodsToCard(id,initShopCard);
	});
	
});

function initGoods(){
	var id = $("#shop_id_bidden").val();
	$.post("ShopServlet", {		//发送shopservlet Post请求
		op : "get_goods_list_by_shop_id",
		id : id
	}, initGoods_render, "xml");
}
function initGoods_render(data){
	var shopName = $(data).find("shop").attr("name");
	var shopDesc = $(data).find("shop").attr("desc");
	var shopPhone = $(data).find("shop").attr("phone");
	var shopAddr = $(data).find("shop").attr("addr_desc");
	$("#shop_name").text(shopName);
	$("#shop_desc").text(shopDesc);
	$("#shop_phone").text(shopPhone);
	$("#shop_addr").text(shopAddr);
	
	$("#goods_list_container").empty();	//清空shop_list_container
	$(data).find("goods").each(function() {
		var id = $(this).attr("id");
		var name = $(this).attr("name");
		var price = $(this).attr("price");
		var img = $(this).attr("phone");
		var $goods;
		$goods = $("<div data-id='"+id+"' class='goods_container'>"+
						"<div class='goods_container_head'>"+
							"<div class='goods_img_container'>"+
								"<img class='goods_img' src='img/goods_simple.jpg'>"+
							"</div>"+
						"</div>"+
						"<div class='goods_container_foot'>"+
							"<div style='margin-top: 5px;' >"+
								"<span style='color: black;'>"+name+"</span>"+
							"</div>"+
							"<div style='margin-top: 0px;' >"+
								"<span style='color: gray;'>价格："+price+"</span>"+
							"</div>"+
							"<div style='margin-top: 10px;' data-id='"+id+"' class='add_to_card'>"+
							"</div>"+
						"</div>"+
					"</div>");
		$("#goods_list_container").append($goods);
		
	});
}
function initShopCard(){
	var goodsList = getGoodsListFromCard();
	//alert(goodsList);
	
	$.post("ShopServlet", {		//发送shopservlet Post请求
		op : "get_goods_list_by_cookie",
		cookie_string : goodsList
	}, initShopCard_render, "xml");	
}
function initShopCard_render(data){
	//alert("cookie");
	var goodsListArr = [];
	var goodsList = getGoodsListFromCard();
	goodsListArr = goodsList.split(",");
	var sum = 0;
	for(index in goodsListArr){
		if(goodsListArr[index]!=""){
			sum++;
		}
	}
	
	$("#jtc-item-goods-container").empty();	//清空shop_list_container
	var count= 0;
	var sumOfPrice = 0;
	var countHaveShow = 0;
	
	$(data).find("shop").each(function() {
		var id = $(this).attr("id");
		var name = $(this).attr("name");
		$(data).find("goods_"+id).each(function() {
			count++;
			
			var id = $(this).attr("id");
			var name = $(this).attr("name");
			var price = parseFloat($(this).attr("price"));
			var img = $(this).attr("phone");
			var numOfGoods = 0;
			for(index in goodsListArr){
				if(goodsListArr[index]==id){
					numOfGoods++;
				}
			}
			sumOfPrice = sumOfPrice+numOfGoods*price;
			if(count<7){
				countHaveShow = countHaveShow+numOfGoods;
				var $goods;
				$goods = $("<div class='tbar-cart-item'>"+
										"<div class='jtc-item-goods'>"+
											"<span class='p-img'>"+
												"<a href='#' target='_blank'><img src='img/goods_simple.jpg'  height='50' width='50' /></a>"+
											"</span>"+
											"<div class='p-name'>"+
												"<a href='#'>"+name+"</a>"+
											"</div>"+
											"<div class='p-price'><strong>¥"+price+"</strong>×"+numOfGoods+"</div>"+
											"<a href='#none' class='p-del J-del' data-id='"+id+"'>删除</a> "+
										"</div>"+
									"</div>");
				$("#jtc-item-goods-container").append($goods);
			}

		});
		
		
	});
	if(sum-countHaveShow>0){
		$("#more_goods_num_container").show();
		$("#more_goods_num").text(sum-countHaveShow);
	}else{
		$("#more_goods_num").text(0);
		$("#more_goods_num_container").hide();
	}
	$("#total_sum_of_goods_money").text(sumOfPrice);
	$("#J-count").text(sum);
	$("#total_sum_of_goods_amount").text(sum);
}
