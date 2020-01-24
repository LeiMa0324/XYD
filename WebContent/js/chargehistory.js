$(function() {

	$("#page_num").val(1);
	getAllRecord(1);
	var page = parseInt($("#page_num").val());
	$("#page_container").delegate(".change_page","click", function(){
		//window.open('project_one.jsp?pid='+$(this).attr('id')) ;
		//alert("打开店铺 id="+$(this).attr('page'));
		
		var page1 = $(this).data('page');
		$("#page_num").val(page1);
		getAllRecord(page1);
		
	});
});



function getAllRecord(page){

	$.post("UserServlet", {
		op : "get_record_list",	
		page : page
	}, record_render, "xml");
	}



function record_render(data){
	var total = 0;
	//alert("init");
	$("#tablebody").empty();
	total = $(data).find("result").attr("total");
	$(data).find("chargerecord").each(function() {		//在xml中找到chargerecord标签 对于每一个chargerecord 执行如下函数，类似I一个for循环
		var id = $(this).attr("id");	//将每一个chargerecord中的标签都抓出来
		var user_id = $(this).attr("userId");
		var createtime = $(this).attr("createtime");
		alert(createtime);
		var account = $(this).attr("account");
		var state = $(this).attr("state");
		var $record;		//新建一个record变量，存html
		$record = $(	"<tr>"+
						"<td>"+id+
						"</td>"+
						"<td>"+user_id+
						"</td>"+
						"<td>"+createtime+
						"</td>"+
						"<td>"+account+
						"</td>"+
						"<td>"+state+
						"</td>"+
					"</tr>");
		$("#tablebody").append($record);	//将这个record对象加入record_list_container中
		
	});
	//开始绘制翻页  total
	var page = parseInt($("#page_num").val());
	var num = Math.ceil(total/10);
	if(total%10>0){
		num++;
	}

	var $pageli;		
	$("#page_container").empty();

	var index = page;
	if(page>1){
		index=page-1;
	}
	//alert(page+"_"+index);
	$pageli = $("<li><a href='#' data-page='"+index+"' class='change_page'>上一页</a></li>");
	$("#page_container").append($pageli);

	$pageli = $("<li><a href='#' data-page='"+page+"' class='change_page'>"+page+"/"+num+"</a></li>");
	$("#page_container").append($pageli);

	index = num;
	if(page<num){
		index=page+1;
	}
	$pageli = $("<li><a href='#' data-page='"+index+"' class='change_page'>下一页</a></li>");
	$("#page_container").append($pageli);

	
}


	





