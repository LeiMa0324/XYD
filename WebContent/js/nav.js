/* nav.js zhaokun 20150709 主要应用于首页右侧导航栏 */
$(document).ready(function(){
	
	$("#jtc-item-goods-container").delegate(".tbar-cart-item","mouseenter", function(){
		$(this).find('.p-del').show(); 
	});
	$("#jtc-item-goods-container").delegate(".tbar-cart-item","mouseleave", function(){
		$(this).find('.p-del').hide();
	});
	
	$('.toolbar-tab').hover(function (){
		$(this).find('.tab-text').addClass("tbar-tab-hover");
		$(this).find('.footer-tab-text').addClass("tbar-tab-footer-hover");
		$(this).addClass("tbar-tab-selected");
	},function(){
		$(this).find('.tab-text').removeClass("tbar-tab-hover");
		$(this).find('.footer-tab-text').removeClass("tbar-tab-footer-hover");
		$(this).removeClass("tbar-tab-selected");
	});
	
	$('.close-panel').click(function (){
		var info = "<em class='tab-text '>购物车</em>";
		$('.toolbar-wrap').removeClass('toolbar-open');
		$('.tbar-tab-cart').append(info);
		$('.tbar-tab-cart').removeClass('tbar-tab-click-selected');
		$('.tbar-panel-cart').css({'visibility':"hidden","z-index":"-1"});
		
		
		
	});
	
	$('.tbar-tab-cart').click(function (){ 
		if($('.toolbar-wrap').hasClass('toolbar-open')){
			if($(this).find('.tab-text').length > 0){
//				if(! $('.tbar-tab-follow').find('.tab-text').length > 0){
//					var info = "<em class='tab-text '>我的关注</em>";
//					$('.tbar-tab-follow').append(info);
//					$('.tbar-tab-follow').removeClass('tbar-tab-click-selected'); 
//					$('.tbar-panel-follow').css({'visibility':"hidden","z-index":"-1"});
//				}
//				if(! $('.tbar-tab-history').find('.tab-text').length > 0){
//					var info = "<em class='tab-text '>我的足迹</em>";
//					$('.tbar-tab-history').append(info);
//					$('.tbar-tab-history').removeClass('tbar-tab-click-selected'); 
//					$('.tbar-panel-history').css({'visibility':"hidden","z-index":"-1"});
//				}
				$(this).addClass('tbar-tab-click-selected'); 
				$(this).find('.tab-text').remove();
				$('.tbar-panel-cart').css({'visibility':"visible","z-index":"1"});
				
			}else{
				var info = "<em class='tab-text '>购物车</em>";
				$('.toolbar-wrap').removeClass('toolbar-open');
				$(this).append(info);
				$(this).removeClass('tbar-tab-click-selected');
				$('.tbar-panel-cart').css({'visibility':"hidden","z-index":"-1"});
			}
			 
			
		}else{ 
			$(this).addClass('tbar-tab-click-selected'); 
			$(this).find('.tab-text').remove();
			$('.tbar-panel-cart').css({'visibility':"visible","z-index":"1"});
			$('.tbar-panel-follow').css('visibility','hidden');
			$('.tbar-panel-history').css('visibility','hidden');
			$('.toolbar-wrap').addClass('toolbar-open'); 
		}
	});
	
	
	
	
	$('.tbar-tab-follow').click(function (){ 
		window.location.href = "UserCenter-account.jsp";

	});
	$('.tbar-tab-history').click(function (){ 
		window.location.href = "UserCenter-order.jsp";

	});
	
});








