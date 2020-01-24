function btnOK_click()
{

	var file1 = document.getElementById("goodsname");
	var file2 = document.getElementById("goodprice");
	var file3 =  $("#testimg").attr('src');
	var w=file3.indexOf("=");
	file3=	file3.substring(w+1);
	if(file1.value == "")
		{
		alert("请填写商品名称");
		}
	else if(file2.value == "")
		{
		alert("请填写商品价格");
		}
	else
	{

	  $.post('/XYD/shopservlet',
			  {
		  op:"add_good_to_shop", //根据商品ID更新商品信息
		  goodsname:file1.value,
		  goodprice:file2.value,
		  image:file3,
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
    if (type != "jpg" && type != "bmp" && type != "gif" && type != "png") {
        alert("请上传正确的图片格式");
    }
    else
    	{
    	
    	
    	$.ajaxFileUpload({  
            url:'/XYD/upLoadImageServlet',             //需要链接到服务器地址  
            secureuri:false,  
            fileElementId:'picPath',                         //文件选择框的id属性  
            dataType: 'json',                                     //服务器返回的格式，可以是json  
            success: function (data, status)             //相当于java中try语句块的用法  
            {     
            	//alert(1);
            	$("#testimg").attr("src", data.url);
            	console.log(data.url);
            	
            	
            	
            	
            	
            //alert(data);       //data是从服务器返回来的值     
               // $('#result').html('上传图片成功!请复制图片地址<br/>'+data.src);  

            },  
            error: function (data, status, e)             //相当于java中catch语句块的用法  
            {  
            	alert(2);
            	
            } 
          }  
        );  
    	
    	

   	}

}