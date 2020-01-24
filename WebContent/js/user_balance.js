$(function() {
	get_balance();
	$('.chargeinput').labelauty();
	$("#confirmCharge").click(confirm_charge);
	
});
//获取账户余额
function get_balance(){
	$.post("UserServlet", {
		op : "get_userinfo"
	   }, money_render, "xml");
		
}
//回调页面写入账户余额
function money_render(data){
		var balance = $(data).find("user").attr("balance");
		$("#accountmoney_span_con").html(balance);
//		alert("Data: " + balance );
}

//确认支付
function confirm_charge(){
	
	var moneychecked=$('input[name="money_radio"]:checked').val();
	alert("确认充值"+moneychecked+"元，我是大爷我怕谁");
	$.post("UserServlet", {
		op : "charge_money" ,
		chargemoney : moneychecked,
	   }, function(data){
		     alert("充值成功，谢谢！" );
		     get_balance();
		   });
}





