$(function(){
	$("#logout_btn").click(logout);
	
});
function logout(){
	$.post("UserServlet", {
		op : "logout"
	}, logout_render, "xml");
}

function logout_render(data){
	window.location.href = "index.jsp";
}

$(document).ajaxError(function(event, data, setting) {
	var text = $(data.responseText).filter('p:eq(1)').find('u').text();
	if (text == "登录超时，请重新登录") {
		window.location.href = "timeout_error.jsp";
		return;
	}
	alert(text);
});


function addGoodsToCard(goodsId,initShopCard){
	
	//$.cookie("shop_card_list", ""); 
	var goodsList  ="";
	goodsList = $.cookie("shop_card_list");
	if(goodsList==null){
		$.cookie("shop_card_list", ""); 
	}
	goodsList = $.cookie("shop_card_list");
	//alert(goodsList);
	var goodsArray = [];
	goodsArray = goodsList.split(",");
	goodsArray.push(goodsId);
	$.cookie("shop_card_list", goodsArray.join(","));
	
	goodsList = $.cookie("shop_card_list");
	//alert(goodsList);
	initShopCard();
}
function addGoodsToCardWithAmount(goodsId,amount,initShopCard){
	
	//$.cookie("shop_card_list", ""); 
	var goodsList  ="";
	goodsList = $.cookie("shop_card_list");
	if(goodsList==null){
		$.cookie("shop_card_list", ""); 
	}
	goodsList = $.cookie("shop_card_list");
	//alert(goodsList);
	var goodsArray = [];
	goodsArray = goodsList.split(",");
	for(var i=0;i<amount;i++){
		goodsArray.push(goodsId);
	}
	
	$.cookie("shop_card_list", goodsArray.join(","));
	
	goodsList = $.cookie("shop_card_list");
	//alert(goodsList);
	initShopCard();
}
function removeGoodsToCard(goodsId,initShopCard){
	
	//$.cookie("shop_card_list", ""); 
	var goodsList  ="";
	goodsList = $.cookie("shop_card_list");
	if(goodsList==null){
		$.cookie("shop_card_list", ""); 
	}
	goodsList = $.cookie("shop_card_list");
	//alert(goodsList);
	var goodsListArr = [];
	var goodsListArrNew = [];
	goodsListArr = goodsList.split(",");
	
	for(index in goodsListArr){
		if(goodsListArr[index]!=goodsId){
			//goodsListArr.pop(goodsListArr[index]);
			goodsListArrNew.push(goodsListArr[index]);
		}
	}
	$.cookie("shop_card_list", goodsListArrNew.join(","));
	goodsList = $.cookie("shop_card_list");
	//alert(goodsList);
	initShopCard();
}
function getGoodsListFromCard(){
	var goodsList  ="";
	goodsList = $.cookie("shop_card_list");
	return goodsList;
}