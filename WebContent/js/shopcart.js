$(function() {
	//所有订单
	initShopCard();
	$("#shop_list_container").delegate(".check-all","click", function(){
		var id = $(this).data("id");
		if($(this).is(':checked')==true){
			$(".shop_"+id).prop("checked",true);
		}else{
			$(".shop_"+id).prop("checked",false);
		}
		calaTotalMoney();
	});
	$("#shop_list_container").delegate(".reduce","click", function(){
		var num = parseInt($(this).next().val());
		if(num>1){
			$(this).next().val(num-1);
		}
		calaTotalMoney();
	});
	$("#shop_list_container").delegate(".add","click", function(){
		var num = parseInt($(this).prev().val());
		$(this).prev().val(num+1);
		calaTotalMoney();
	});
	
	
	$("#shop_list_container").delegate(".check-one","change", function(){
		calaTotalMoney();
	});
	
	$("#shop_list_container").delegate(".buy_now","click", function(){
		//calaTotalMoney();
		var shopId = $(this).data("id");
		buyNow(shopId);
	});
	
	
	
	//关键字查询订单

});
function initShopCard(){
	var goodsList = getGoodsListFromCard();
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
	
	$("#shop_list_container").empty();	//清空shop_list_container
	var count= 0;
	var sumOfPrice = 0;
	var countHaveShow = 0;
	
	$(data).find("shop").each(function() {
		var shopId = $(this).attr("id");
		var name = $(this).attr("name");
		var goodsListStr = "";
		$(data).find("goods_"+shopId).each(function() {
			//开始拼接单个店铺的商品
			var id = $(this).attr("id");
			var name = $(this).attr("name");
			var price = parseFloat($(this).attr("price"));
			var img = $(this).attr("phone");
			
			var numOfGoods = 0;     //从cookie中计算出单个商品的数量
			for(index in goodsListArr){
				if(goodsListArr[index]==id){
					numOfGoods++;
				}
			}
			var subtotal = numOfGoods*price;
			goodsListStr = goodsListStr+"<tr class ='goodstr'>"+
				        "<td class='checkbox'><input class='check-one check shop_"+shopId+"' data-id='"+id+"' type='checkbox'/></td>"+
				        "<td class='goods'><img src='img/duanmianfu.jpg' /><span>"+name+"</span></td>"+
				        "<td class='price' id='price_"+id+"'>"+price+"</td>"+
				        "<td class='count'>"+
				        	"<span class='reduce'>-</span>"+
				          	"<input class='count-input' type='text' id='amount_"+id+"' value='"+numOfGoods+"'/>"+
				          	"<span class='add'>+</span></td>"+
				        "<td class='subtotal'id='subtotal_"+id+"'>"+subtotal+"</td>"+
				        "<td class='operation'><span class='delete'>删除</span></td>"+
				      "</tr>";
			
			

		});
		//开始拼接店铺
		
		var $shop;
		$shop = $("<div class='row-fluid'>"+
				"<div class='catbox'>"+
				 "<table id='cartTable'>"+
				    "<thead>"+
				      "<tr>"+
				       " <th>"+
				        	"<label><input class='check-all check' data-id='"+shopId+"' type='checkbox'/>&nbsp;&nbsp;全选</label>"+
				       "</th>"+
				        "<th>"+name+"</th>"+
				        "<th>单价</th>"+
				        "<th>数量</th>"+
				        "<th>小计</th>"+
				        "<th>操作</th>"+
				      "</tr>"+
				    "</thead>"+
				    "<tbody>"+
				    goodsListStr+
				    "</tbody>"+
				  "</table>"+
				  "<div class='foot' id='foot'>"+
				    "<div class='fr closing buy_now' data-id='"+shopId+"' >结 算</div>"+
				    "<input type='hidden' id='cartTotalPrice' />"+
				    "<div class='fr total'>合计：￥<span style='color:red;font-weight:bold;' id='priceTotal_"+shopId+"'>0</span></div>"+
				    "<div class='fr selected' id='selected'>已选商品<span style='color:red;font-weight:bold;' id='amountTotal_"+shopId+"'>0</span>件</div>"+
				    "<div class='selected-view'>"+
				      "<div id='selectedViewList' class='clearfix'>"+
				        "<div><img src='images/1.jpg'><span>取消选择</span></div>"+
				      "</div>"+
				      "<span class='arrow'>◆<span>◆</span></span> </div>"+
				  "</div>"+
				"</div>"+
			
			"</div>");
		
		
		
		
		
		
		$("#shop_list_container").append($shop);
		
	});

	
		
	}
	
function calaTotalMoney(){
	$(".check-all").each(function(){
		var shopId = $(this).data("id");
		//alert(shopId);
		//计算一个店铺的数据
		var goodsMoneyOfShop = 0;
		var goodsAmountOfShop = 0;
		$(".shop_"+shopId).each(function(){
			//alert("-");
			var id = $(this).data("id");
			var price = parseFloat($("#price_"+id).text());
			var amount = parseInt($("#amount_"+id).val());
			$("#subtotal_"+id).text(price*amount);
			if($(this).is(':checked')==true){
				//参与计算
				goodsMoneyOfShop = goodsMoneyOfShop+price*amount;
				goodsAmountOfShop = goodsAmountOfShop+amount;
				
			}
		});
		//alert(goodsAmountOfShop);
		$("#priceTotal_"+shopId).text(goodsMoneyOfShop);
		$("#amountTotal_"+shopId).text(goodsAmountOfShop);
		
	});
}


function buyNow(shopId){
	
	var goodsMoneyOfShop = 0;
	var goodsAmountOfShop = 0;
	var arr = [];
	$(".shop_"+shopId).each(function(){
		//alert("-");
		if($(this).is(':checked')==true){
			//参与计算
			var id = $(this).data("id");
			//alert($(this).data("id"));
			//alert($("#price_"+id).text());
			var price = parseFloat($("#price_"+id).text());
			var amount = parseInt($("#amount_"+id).val());
			goodsMoneyOfShop = goodsMoneyOfShop+price*amount;
			goodsAmountOfShop = goodsAmountOfShop+amount;
			arr.push(id+"_"+amount);
		}
	});
	//alert("总金额："+goodsMoneyOfShop+"_arr:"+arr.join(","));
	if(goodsAmountOfShop<1){
		alert("请选择商品");
		return false;
	}
	$.post("OrderServlet", {		//发送shopservlet Post请求
		op : "add_new_order",
		array_string : arr.join(","),
		shop_id : shopId
	}, addNewOrder_render, "xml");
}

function addNewOrder_render(){
	alert("订单提交成功");
}

