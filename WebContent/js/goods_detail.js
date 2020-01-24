$(function() {
	
	initShopCard();
	$('.spinnerExample').spinner({});
	$("#buy_amount").val("1");
	var offsetHeight = 300;
	var offsetWidth = $(window).width();
	
	
	
	$("#jtc-item-goods-container").delegate(".p-del","click", function(){
		var id = $(this).data("id");
		//alert("------删除购物车的商品-------"+id);
		removeGoodsToCard(id,initShopCard);
	});
	$("#add_to_card_btn").click(function(event){
		var id = $(this).data("id");
		var amount = parseInt($("#buy_amount").val());
		if(amount<1){
			alert("请选择购买数量");
			return false;
		}
		//alert(amount);
		addGoodsToCardWithAmount(id,amount,initShopCard);
		var img = $("#goods_img_container").find('img').attr('src');
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
	$("#buy_now_btn").click(function(event){
		var id = $(this).data("id");
		var amount = parseInt($("#buy_amount").val());
		if(amount<1){
			alert("请选择购买数量");
			return false;
		}
		//alert(amount);
		addGoodsToCardWithAmount(id,amount,initShopCard);
		var img = $("#goods_img_container").find('img').attr('src');
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
				window.open("UserCenter-shopcart.jsp");
				this.destory();
			}
		});
		
		
		return false;
	});
	
});

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
