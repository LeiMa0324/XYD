<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>

 
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cj/tasp.css" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/cj/orderconfirm.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/cj/SubmitShopOrder.css" type="text/css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/cj/submitShopOrder.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/shopcart.css" type="text/css" rel="stylesheet" />
<title>提交订单</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="container">
		<div class="row">
				<div class="span12">
						<div class="row">
								<div class="span2">
								</div>
								<div class="span8">
										<div class="span8">
									<div id="address" class="address" style="margin-top: 20px;" data-spm="2">
<form name="addrForm" id="addrForm" action="#">
<h3>确认收货地址
 <span class="manage-address">
 <a href="http://member1.taobao.com/member/fresh/deliver_address.htm" target="_blank" title="管理我的收货地址"
 class="J_MakePoint" data-point-url="http://log.mmstat.com/buy.1.7">管理收货地址</a>
 </span>
</h3>
<ul id="address-list" class="address-list">
     <li class="J_Addr J_MakePoint clearfix  J_DefaultAddr "  data-point-url="http://log.mmstat.com/buy.1.20">
 <s class="J_Marker marker"></s>
 <span class="marker-tip">寄送至</span>
   <div class="address-info">
 <a href="#" class="J_Modify modify J_MakePoint" >修改本地址</a>
 <input name="address"
 class="J_MakePoint "
 type="radio"
 value="674944241"
 id="addrId_674944241"
  checked="checked" >
 <label for="addrId_674944241" class="user-address">
         湖北省 恩施土家族苗族自治州 恩施市 湖北民族学院（信息工程学院）  男生宿舍楼235栋2323102 (某某 收) <em>18427717260</em>
   </label>
 <em class="tip" style="display: none">默认地址</em>
 <a class="J_DefaultHandle set-default J_MakePoint" href="/auction/update_address_selected_status.htm?addrid=674944241" style="display: none" >设置为默认收货地址</a>
 </div>
     </li>
     <li class="J_Addr J_MakePoint clearfix" >
 <s class="J_Marker marker"></s>
 <span class="marker-tip">寄送至</span>
   <div class="address-info">
 <a href="#" class="J_Modify modify J_MakePoint" >修改本地址</a>
 <input name="address"
 class="J_MakePoint"
 type="radio"
 value="594209677"
 id="addrId_594209677"
 >
 <label for="addrId_594209677" class="user-address">
       湖北省 恩施土家族苗族自治州 恩施市 某某某 (某某某 收) <em>1342407681</em></label><em class="tip" style="display: none">默认地址</em>
   <a class="J_DefaultHandle set-default J_MakePoint" style="display: none" data-point-url="#" href="#">设置为默认收货地址</a>
 </div>
   </li>
     </ul>
<ul id="J_MoreAddress" class="address-list hidden">
     
 </ul>

<div class="address-bar">
 <a href="#" class="new J_MakePoint" id="J_NewAddressBtn">使用新地址</a>
 </div>

</form>
</div>
										<br>
										</div>
										<div class="span8">
										<h5>确认订单信息</h5>
										<div class="catbox">
				  <table id="cartTable">
				    <thead>
				      <tr>
				    
				        <th>程老板洗衣店</th>
				        <th>单价</th>
				        <th>数量</th>
				        <th>小计</th>
				      </tr>
				    </thead>
				    <tbody>
				      <tr>
	
				        <td class="goods"><img src="img/duanmianfu.jpg" alt=""/><span>短棉服</span></td>
				        <td class="price">30</td>
				        <td class="count">5</td>
				        <td class="subtotal">30</td>
				      </tr>
				      <tr>

				        <td class="goods"><img src="img/yangmaoshan.jpg" alt=""/><span>羊毛衫</span></td>
				        <td class="price">15</td>
				        <td class="count">
				       	15
				       	</td>
				        <td class="subtotal">15</td>
				      </tr>
				    </tbody>
				  </table>
				  <div class="foot" id="foot">
				    <input type="hidden" id="cartTotalPrice" />
				    <div class="fr total">合计：￥<span id="priceTotal">0.00</span></div>
				    <div class="fr selected" id="selected">已选商品<span id="selectedTotal">0</span>件<span class="arrow up">︽</span><span class="arrow down">︾</span></div>
				    <div class="selected-view">
				      <div id="selectedViewList" class="clearfix">
				        <div><img src="images/1.jpg"><span>取消选择</span></div>
				      </div>
				      <span class="arrow">◆<span>◆</span></span> </div>
				  </div>
				</div>
				
										</div>
										<div class="span8 " >
										 <button class="btn cjButtonRight" type="button">确认提交</button>
										</div>
									
								</div>
								<div class="span2">
								</div>
						</div>
				</div>
		</div>
</div>
<jsp:include page="foot.jsp" />
</body>
</html>