<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tn17.util.TimeUtil"%>
<%@ page import="com.seu.xyd.servlet.UIUtil"%>
<%@ page import="com.seu.xyd.data.User"%>
<%@ page import="com.seu.xyd.data.Shop"%>


<div class="row-fluid" style="margin-bottom:30px;">

			<div class="navbar navbar-inverse test">
				<div class="  navbar-inner ">
				<div class="span1">
				</div>
				<div class="span10">
					<div class="container-fluid">
<!-- 						<a class="btn btn-navbar" data-target=".navbar-responsive-collapse" data-toggle="collapse"></a> 
						<a class="brand" href="#">阳光洗衣店</a> -->
						<div class="nav-collapse collapse navbar-responsive-collapse" id="header_nav1">
							<ul class="nav" >
								<li >
									<img alt="186x55" id="sunshine_img" src="css/images/sunshine.png" />
								</li>
								<li >
									<a href="#">附近商家</a>
								</li>
								<li>
									<a href="UserCenter-order.jsp">我的订单</a>
								</li>
								<li>
									<a href="#">活动</a>
								</li>
								
							</ul>
							<ul class="nav pull-right">
								<%
	
									try{
										String role = UIUtil.getLogonRole(session);
										if(role.equals(UIUtil.SESSION_ATTRIBUTE_KEY_FOR_USER)){
											User user = UIUtil.getLogonUser(session);
											%>
											<li class="dropdown">
												<a class="dropdown-toggle" data-toggle="dropdown" href="#"><%=user.getAccount() %>
												<strong class="caret"></strong></a>
												<ul class="dropdown-menu">
													<li>
														<a href="UserCenter-order.jsp">我的订单</a>
													</li>
													<li>
														<a href="UserCenter-order.jsp">用户中心</a>
													</li>
													<li class="divider">
													</li>
													<li>
														<a href="#" id="logout_btn">退出登录</a>
													</li>
												</ul>
											</li>
											<%
										}else if(role.equals(UIUtil.SESSION_ATTRIBUTE_KEY_FOR_SHOP)){
											Shop shop = UIUtil.getLogonShop(session);
											%>
											<li class="dropdown">
												<a class="dropdown-toggle" data-toggle="dropdown" href="#"><%=shop.getAccount() %>
												<strong class="caret"></strong></a>
												<ul class="dropdown-menu">
													<li>
														<a href="MyShop.jsp">我的订单</a>
													</li>
													<li>
														<a href="MyShop.jsp">用户中心</a>
													</li>
													<li class="divider">
													</li>
													<li>
														<a href="#" id="logout_btn">退出登录</a>
													</li>
												</ul>
											</li>
											<%
										}
									
									}catch(ServletException e){
									%>
									<li>
										<a href="${pageContext.request.contextPath}/login.jsp">登录</a>
									</li>
									<li>
										<a href="${pageContext.request.contextPath}/register.jsp">注册</a>
									</li>
									<%
									}finally{
										
									}
								%>
								
								
							</ul>
						</div>
						
					</div>
				</div>
								<div class="span1">
				</div>
				</div>
				
			</div>
		</div>
</div>