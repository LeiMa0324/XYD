
$(function() {
	var lng;
	var lat;
	var address;
	var marker;
	var addr_prov;
	var addr_city;
	var addr_area;
	var addr_desc;
	$("#id_areaSelect").change(function(){
		var area = $(this).find("option:selected").text();
		initMap(area);
	});
	loadProvince('320506');
	initMap("吴中区");
});

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
	
	function start(){
		
		
		$.post("ShopServlet", {
			op : "register2",
			addr_prov : addr_prov,
			addr_city : addr_city,
			addr_area : addr_area,
			addr_desc : addr_desc,
			lng : lng,
			lat : lat
		}, register_render, "xml");
		
	}
	function register_render(){
		window.open("Shop_login.jsp");
	}
	
	function initMap(area){
		var map = new BMap.Map("container");
		map.centerAndZoom(area, 14);
		map.enableScrollWheelZoom(true);
		map.addEventListener("click", showInfo);
		
		function showInfo(e){
			//alert(e.point.lng + ", " + e.point.lat);
			//map.clearOverlays();
			marker = new BMap.Marker(e.point); // 创建点
			//marker.addEventListener("click",attribute);
			map.addOverlay(marker);    //增加点
			var p = marker.getPosition();  //获取marker的位置
			//alert("marker的位置是" + p.lng + "," + p.lat);    
			var geoc = new BMap.Geocoder();
			geoc.getLocation(p, function(rs){
				var addComp = rs.addressComponents;
				//alert(addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber);
				lng=p.lng;
				lat=p.lat;
				addr_prov = $("#id_provSelect").find("option:selected").text();
				addr_city = $("#id_citySelect").find("option:selected").text();
				addr_area = $("#id_areaSelect").find("option:selected").text();
				addr_desc = addComp.street +addComp.streetNumber;
				address = addComp.province + " " + addComp.city + " " + addComp.district + " " + addComp.street + " " + addComp.streetNumber;
				var address_zuobiao = "坐标："+p.lng + "," + p.lat;
				var sContent =
					"<h4 style='margin:0 0 5px 0;padding:0.2em 0'>当前位置</h4>" + 
					"<p style='margin:0;line-height:1.5;font-size:13px;text-indent:2em'>"+address+"</p>" + 
					"<p style='margin:0;line-height:1.5;font-size:13px;text-indent:2em'>"+address_zuobiao+"</p>" + 
					"<button class='search_shop' data-lng='"+p.lng+"' data-lat='"+p.lat+"' data-address='"+address+"' onclick='start()'>标记为店铺地址</button>" + 
					"</div>";
				var infoWindow = new BMap.InfoWindow(sContent);  // 创建信息窗口对象
				marker.addEventListener("click", function(){ 
					   this.openInfoWindow(infoWindow);
					   //图片加载完毕重绘infowindow
					   document.getElementById('imgDemo').onload = function (){
						   infoWindow.redraw();   //防止在网速较慢，图片未加载时，生成的信息框高度比图片的总高度小，导致图片部分被隐藏
						   
					   };
					});
			});
			
			
			
			
//			function attribute(){
//				var p = marker.getPosition();  //获取marker的位置
//				//alert("marker的位置是" + p.lng + "," + p.lat);    
//				var geoc = new BMap.Geocoder();
//				geoc.getLocation(p, function(rs){
//					var addComp = rs.addressComponents;
//					alert(addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber);
//					var sContent =
//						"<h4 style='margin:0 0 5px 0;padding:0.2em 0'>天安门</h4>" + 
//						"<img style='float:right;margin:4px' id='imgDemo' src='http://app.baidu.com/map/images/tiananmen.jpg' width='139' height='104' title='天安门'/>" + 
//						"<p style='margin:0;line-height:1.5;font-size:13px;text-indent:2em'>天安门坐落在中国北京市中心,故宫的南侧,与天安门广场隔长安街相望,是清朝皇城的大门...</p>" + 
//						"</div>";
//						var infoWindow = new BMap.InfoWindow(sContent);  // 创建信息窗口对象
//						this.openInfoWindow(infoWindow);
//						   //图片加载完毕重绘infowindow
//						   document.getElementById('imgDemo').onload = function (){
//							   infoWindow.redraw();   //防止在网速较慢，图片未加载时，生成的信息框高度比图片的总高度小，导致图片部分被隐藏
//						   }
//				}); 
//			}
		}
		
	}