var html = '';
html += '<div id="modify_address_dialog" title="编辑收货地址" class="modal modal-content">';
html += '<div id="dialog_inner_layout">';
html += '<br>';
html += '	<div id="choose_city" style="margin-left: 15px;">';
html += '			<select id="id_provSelect" name="provSelect" onChange="loadCity(this.value);"><option value="">请选择省份</option></select>&nbsp;';
html += '			<select id="id_citySelect" name="citySelect" onChange="loadArea(this.value);"><option value="">请选择城市</option></select>&nbsp;';
html += '			<select id="id_areaSelect" name="areaSelect"><option value="">请选择区域</option></select>&nbsp;';
html += '	</div>	';
html += '<br>';
html += '	<div style="margin-top: 5px;"><span class="span_name">详细地址 </span><input style="width:70%" type="text" id="add_new_addr_detail" value="" autofocus="autofocus"/>';
html += '	</div>';
html += '<br>';
html += '	<div style="margin-top: 5px;display:inline-block; width:40%"><span class="span_name">收件人 </span><input style="width:60%" type="text" id="add_new_addr_name" value=""/>';
html += '	</div>';
html += '	<div style="margin-top: 5px;display:inline-block; width:40%"><span class="span_name">联系电话 </span><input style="width:60%" type="text" id="add_new_addr_phone" value=""/>';
html += '	</div>';
html += '<br>';
html += '	<div style="margin-top: 5px;margin-left: 70%;">';
html += '     <button type="button" class="btn btn-default btn-sure">保 存</button>';
html += '     <button type="button" class="btn btn-default btn-cancel">取 消</button>';
html += '	</div>';
html += '<br>';
html += '</div></div>';
var rec_id = 0;//当前操作地址编号，新增则置0
var rec_count = 0;//当前保有收货地址数目

$(function() {	
	$("body").append(html);
	loadProvince('130205');
	//所有收货地址
	getAllAddress();
	//监听设置默认事件
	$('#tablebody').delegate('.make_default_btn', 'click', function() {
		var id = $(this).parents("tr").attr("id");
		makeDefault(id);
	}); 
	//监听删除地址事件
	$('#tablebody').delegate('.delete_btn', 'click', function() {
		var id = $(this).parents("tr").attr("id");
		deleteAddress(id);
	});
	//监听修改地址事件
	$('#tablebody').delegate('.modify_btn', 'click', function() {
		var id = $(this).parents("tr").attr("id");
		modifyAddress(id);
		
	});
	//监听新增地址事件
	$('#MyAddress').delegate('#add_new_addr_btn', 'click', function() {
		if(rec_count>=5){
			alert("每个用户最多保有五个收货地址");
		}else{
			addAddress();
		}		
	});
	//监听取消按钮
	$('#modify_address_dialog').delegate('.btn-cancel', 'click', function(){
		$("#modify_address_dialog").hide();
	});
	//监听保存按钮
	$('#modify_address_dialog').delegate('.btn-sure', 'click', function(){
		confirmAddress();
	});
});

//响应新增收货地址
function addAddress(){
	$("#modify_address_dialog").show();
	rec_id = 0;
}
//响应弹出收货地址页面
function modifyAddress(id){
	
	$.post("UserServlet", {
		op : "get_addres_by_id",
		rec_id : id ,
	}, modifyAddress_render, "xml");
}
//加载收货地址页面
function modifyAddress_render(data){
	rec_id = $(data).find("receiverinfo").attr("id");
	var rev_name = $(data).find("receiverinfo").attr("recName");
	var rec_phonenum = $(data).find("receiverinfo").attr("recPhonenum");
	var address_prov = $(data).find("receiverinfo").attr("addressProv");
	var address_city = $(data).find("receiverinfo").attr("addressCity");
	var address_area = $(data).find("receiverinfo").attr("addressArea");
	var address_detail = $(data).find("receiverinfo").attr("addressDetail");
	$("#modify_address_dialog").show();
	$("#dialog_inner_layout").val(rec_id);
	$("#add_new_addr_detail").val(address_detail);
	$("#add_new_addr_name").val(rev_name);
	$("#add_new_addr_phone").val(rec_phonenum); 
	$("#id_provSelect option:contains('"+address_prov+"')").each(function(){
		  if ($(this).text() == address_prov) {
			  loadProvince($(this).val());
		  }
		});
	$("#id_citySelect option:contains('"+address_city+"')").each(function(){
		  if ($(this).text() == address_city) {
		     loadProvince($(this).val());
		  }
		});
	$("#id_areaSelect option:contains('"+address_area+"')").each(function(){
		  if ($(this).text() == address_area) {
			  loadProvince($(this).val());
		  }
		});

}

//确认修改地址
function confirmAddress(){
		var recname = $("#add_new_addr_name").val();
		var recphonenum = $("#add_new_addr_phone").val();
		var recaddrdetail = $("#add_new_addr_detail").val();
		var recprov = $("#id_provSelect :selected").text();
		var reccity = $("#id_citySelect :selected").text();
		var recarea = $("#id_areaSelect :selected").text();
		$.post("UserServlet",{
			op : "modify_address",
			rec_id : rec_id,
			recprov : recprov,
			reccity : reccity,
			recarea : recarea,
			recaddrdetail : recaddrdetail,
			recname : recname,
			recphonenum : recphonenum,
		},confirmModifyAddress_render,"xml");
	
}
//保存收货地址回调函数
function confirmModifyAddress_render(data){	
	$("#modify_address_dialog").hide();
	getAllAddress();
}

//获取所有收货地址
function getAllAddress(){
	$.post("UserServlet", {
		op : "get_addres_list",
	}, address_render, "xml");
	}

//查询的回调函数
function address_render(data){
	var defId = $(data).find("user").attr("def_rec_info_id");
	$("#tablebody").empty();
	//清空table的body
	$(data).find("receiverinfo").each(function() {		//在xml中找到shop标签 对于每一个shop 执行如下函数，类似一个for循环
		var id = $(this).attr("id");	//将每一个shop中的标签都抓出来
		var rev_name = $(this).attr("recName");
		var rec_phonenum = $(this).attr("recPhonenum");
		var address_prov = $(this).attr("addressProv");
		var address_city = $(this).attr("addressCity");
		var address_area = $(this).attr("addressArea");
		var address_detail = $(this).attr("addressDetail");
		rec_count++;
		var buttondesc ;
		if(defId == id){
			buttondesc = "默认地址";
		}else{
			buttondesc = "<button type='button' class='btn btn-default make_default_btn'>设为默认</button>";
		}		
		var $address;		//新建一个address变量，存html
		$address = $(	"<tr id='"+id+"'>"+
						"<td>"+rev_name+
						"</td>"+
						"<td>"+address_prov+address_city+address_area+
						"</td>"+
						"<td>"+address_detail+
						"</td>"+
						"<td>"+rec_phonenum+
						"</td>"+
						"<td>"+"<button type='button' class='btn btn-default modify_btn'>修改</button>"+
						"<button type='button' class='btn btn-default delete_btn'>删除</button>"+
						"</td>"+
						"<td>"+buttondesc+
						"</td>"+
					"</tr>");
		$("#tablebody").append($address);	//将这个shop对象加入shop_list_container中
		
	});
	
}



//删除收货地址信息
function deleteAddress(id){
	$.post("UserServlet", {
		op : "delete_address",
		rec_id : id,
	}, function(data){
		alert("删除收货地址成功");
		getAllAddress();
	   });
	}

//设置默认收货地址信息
function makeDefault(id){
	$.post("UserServlet", {
		op : "make_default_address",
		rec_id : id,
	}, function(data){
		getAllAddress();
	   });
	}

function loadProvince(regionId){
	  $("#id_provSelect").html("");
	  $("#id_provSelect").append("<option value=''>请选择省份</option>");
	  var jsonStr = getAddress(regionId,0);
	  for(var k in jsonStr) {
		$("#id_provSelect").append("<option value='"+k+"'>"+jsonStr[k]+"</option>");
	  }
	  if(regionId.length!=6) {
		$("#id_citySelect").html("");
	    $("#id_citySelect").append("<option value=''>请选择城市</option>");
		$("#id_areaSelect").html("");
	    $("#id_areaSelect").append("<option value=''>请选择区域</option>");
	  } else {
		 $("#id_provSelect").val(regionId.substring(0,2)+"0000");
		 loadCity(regionId);
	  }
	}

	function loadCity(regionId){
	  $("#id_citySelect").html("");
	  $("#id_citySelect").append("<option value=''>请选择城市</option>");
	  if(regionId.length!=6) {
		$("#id_areaSelect").html("");
	    $("#id_areaSelect").append("<option value=''>请选择区域</option>");
	  } else {
		var jsonStr = getAddress(regionId,1);
	    for(var k in jsonStr) {
		  $("#id_citySelect").append("<option value='"+k+"'>"+jsonStr[k]+"</option>");
	    }
		if(regionId.substring(2,6)=="0000") {
		  $("#id_areaSelect").html("");
	      $("#id_areaSelect").append("<option value=''>请选择区域</option>");
		} else {
		   $("#id_citySelect").val(regionId.substring(0,4)+"00");
		   loadArea(regionId);
		}
	  }
	}

	function loadArea(regionId){
	  $("#id_areaSelect").html("");
	  $("#id_areaSelect").append("<option value=''>请选择区域</option>");
	  if(regionId.length==6) {
	    var jsonStr = getAddress(regionId,2);
	    for(var k in jsonStr) {
		  $("#id_areaSelect").append("<option value='"+k+"'>"+jsonStr[k]+"</option>");
	    }
		if(regionId.substring(4,6)!="00") {$("#id_areaSelect").val(regionId);}
	  }
	}