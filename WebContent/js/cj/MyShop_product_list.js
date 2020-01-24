
	var page =0;
function addGoodPressed()
{
	 window.location.replace("AddGoodsToShop.jsp");

}
function deleteButtonPressed()
{

    var r=document.getElementsByName("goodcheckbox");
    var arraylist = [];
    var j=0;
    for(var i=0;i<r.length;i++)
    {
         if(r[i].checked)
         {
    
         j++;
         arraylist.push(r[i].value);

       }
    }  
    alert(arraylist.join());
    $.post('/XYD/shopservlet',
			  {
		  op:"delete_goods_by_goodsId", //根据商品ID更新商品信息
		  goodsids:arraylist.join(),
		  
		  },
			  function(data,status)
			  {
			  pageChangeButtonPressed();
			  },"xml");
 
}

$(function() 
{
	 var r= document.getElementById("pagenum").value;
	 $.post
	 ("/XYD/ShopServlet",
	  {
	    page:r,
	    op:"get_goods_with_page"
	  },
	  initNearbyShop_render
	   );
	
});
function pageChangeButtonPressed()
{
	 var r= document.getElementById("pagenum").value;
	 $.post
	 ("/XYD/ShopServlet",
	  {
	    page:r,
	    op:"get_goods_with_page"
	  },
	  initNearbyShop_render
	   );
}

function PageButtonPressed()
{
	
	alert($(this).html());
	
}

function initNearbyShop_render(data,status)
{
	$("#trfirst").empty();
	$("#trSecond").empty();
	$("#pageID").empty();//清空html页面


	
		var total = $(data).attr("total");
		 page =  Math.ceil( total/8);
		$pagehtml = $("<li><a href='javascript:void(0)' class ='pageClass'>上一页</a></li>");
		$("#pageID").append($pagehtml);
		for(var i =1;i<page+1;i++)
			{
			if(i == document.getElementById("pagenum").value)
				{
				
				$pagehtml = $("<li><a href='javascript:void(0)'  class ='pageClass' style='color:blue'>"+i+"</a></li>");
				$("#pageID").append($pagehtml);
				}
			else
				{
			$pagehtml = $("<li><a href='javascript:void(0)'  class ='pageClass'>"+i+"</a></li>");
			$("#pageID").append($pagehtml);
				}
			
			}
		$pagehtml = $("<li><a href='javascript:void(0)'  class ='pageClass' >下一页</a></li>");
		$("#pageID").append($pagehtml);
		
		$.each($('.pageClass'),function(i,btn)
		{
			$(btn).click
			(
					function()
					{
					 var r= document.getElementById("pagenum").value;
						 if($(this).html()=="上一页")
						{
							 if(r-1>0)
							 {
								 $("#pagenum").val(r-1);
							 }
						}
						 else if($(this).html()=="下一页")
						{
							 if(parseInt(r)+1<page+1)
							 {
								 $("#pagenum").val(parseInt(r)+1);
							 }
						}
						 else
						{
							 $("#pagenum").val($(this).html());
						}
						 pageChangeButtonPressed();
				
					}
			);
			}
		);
		var count=0;
	$(data).find("goods").each(function()
	{
		
		count++;
		var id = $(this).attr("id");
		var name = $(this).attr("name");
		var price = $(this).attr("price");
		var img = $(this).attr("img");
		if(count<5)
			{
			
			$shop = $("<td><input type='checkbox' name='goodcheckbox' value ="+id+">"+"&nbsp&nbsp&nbsp"+name+" </br>"
					+" <a href=commodityDetail.jsp?id="+id+"><br><img class='img-polaroid' alt='140x140' src="+"PicDownloadServlet?file_name="+img+"/></a>"+"</td>");
				$("#trfirst").append($shop);
			}
		else if(count<9)
			{
			$shop = $("<td><input type='checkbox' name='goodcheckbox' value ="+id+">"+"&nbsp&nbsp&nbsp"+name+" </br>"
					+" <a href=commodityDetail.jsp?id="+id+"><br><img class='img-polaroid' alt='140x140' src="+"PicDownloadServlet?file_name="+img+"/></a>"+"</td>");
			
		$("#trSecond").append($shop);
			
			}
	
	});
}

