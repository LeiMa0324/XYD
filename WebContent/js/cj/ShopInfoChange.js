
$(function() 
{
	 $.post
	 ("/XYD/ShopServlet",
	  {
	    op:"get_shop_info"
	  },
	  upDataWebData
	   );
	
});

function upDataWebData(data,status)
{
	$(data).find("shop").each(function()
			{
				var account = $(this).attr("account");
				var name = $(this).attr("name");
				var phone = $(this).attr("phone");
				var img = $(this).attr("img");
				var desc = $(this).attr("desc");
				 $("#account").val(account);
				 $("#name").val(name);
				 $("#phone").val(phone);
				 $("#desc").val(desc);
				 $("#testimg").attr("src","PicDownloadServlet?file_name="+img+"/");
			});
}





function btnOK_click()
{

	var file1 = document.getElementById("name");
	var file2 = document.getElementById("phone");
	var file3 =  $("#testimg").attr('src');
	var file4 = document.getElementById("desc");
	var w=file3.indexOf("=");
	
	file3=	file3.substring(w+1) ;
	if(file1.value == "")
		{
		alert("请填写商户名称");
		}
	else if(file2.value == "")
		{
		alert("请填写商户电话");
		}
	else
	{

	  $.post('/XYD/shopservlet',
			  {
		  op:"updata_shop_info", //根据商品ID更新商品信息
		  name:file1.value,
		  phone:file2.value,
		  image:file3,
		  desc:file4.value
		  },
			  function(data,status)
			  {
			  window.location.replace("MyShop_product_list.jsp");
			  },"xml");
	}
	
}





function checkPic() 
        {
        	var file1 = document.getElementById("picPath");
            var picPath = document.getElementById("picPath").value;
            var type = picPath.substring(picPath.lastIndexOf(".") + 1, picPath.length).toLowerCase();
            if (type != "jpg" && type != "bmp" && type != "gif" && type != "png") 
            {
                alert("请上传正确的图片格式");
            }
            else
           	{
            	$.ajaxFileUpload
            	(
            			{  
		                    url:'/XYD/upLoadImageServlet',             //需要链接到服务器地址  
		                    secureuri:false,  
		                    fileElementId:'picPath',                         //文件选择框的id属性  
		                    dataType: 'json',                                     //服务器返回的格式，可以是json  
		                    success: function (data, status)             //相当于java中try语句块的用法  
		                    {     
		                    	//alert(1);
		                    	$("#testimg").attr("src", data.url);
		                    	console.log(data.url);
		
		                    },  
		                    error: function (data, status, e)             //相当于java中catch语句块的用法  
		                    {  
		                    	alert(2);
		                    	
		                    } 
            			}  
                );  
            	
           	}
        }