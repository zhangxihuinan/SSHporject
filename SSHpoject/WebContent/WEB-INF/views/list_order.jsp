<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Insert title here</title>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style type="text/css">
		td{
			border: 1px solid #c5c5c5;
		}
	</style>
</head>
<body onload="changecount()">
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid" >
	<div class="navbar-header" style="float: left;">
		<a class="navbar-brand" href="#">导航</a>
	</div>
	<div>
		<ul class="nav navbar-nav" style="float: right;margin-right: 300px;">
			<li class="active">
				<a href="${pageContext.request.contextPath}/goods_findallpage.action">
					首页
				</a>
			</li>
			<li><a href="#">A</a></li>
			<li><a href="#">B</a></li>
	
			<li><a data-toggle="button" onclick="window.location.href='findAll_usershoppingcart.action'">进入购物车</a></li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					活动中心
					<b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="#">有奖问答</a></li>
					<li class="divider"></li>
					<li><a href="${pageContext.request.contextPath}/user_center.action">积分商城</a></li>
					<li class="divider"></li>
					<li><a href="${pageContext.request.contextPath}/money_center.action">转盘抽奖</a></li>
				</ul>
			</li>
			
			
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					${sessionScope.username}
					<b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="${pageContext.request.contextPath}/user_center.action">用户中心</a></li>
					<li class="divider"></li>
					<li><a href="${pageContext.request.contextPath}/money_center.action">账户管理</a></li>
					<li class="divider"></li>
					<li><a href="${pageContext.request.contextPath}/user_order_center.action">订单查询</a></li>
					<li class="divider"></li>
					<li><a href="user_out.action" onclick="return confirm('是否注销登录?')">注销登录</a></li>
					
				</ul>
			</li>
		</ul>
	</div>
	</div>
</nav>


<div id="div1" align="center" style="width: 100%;height: 800px;">
<form action="add_order.action" method="post">
<h2>订单编号：
	<input style="border: none;" name="date" type="text" readonly="readonly" value="${date}"/>
</h2>
	<div class="form-group" style="width: 200px;">
		<label for="name">请选择收货地址</label>
		<select class="form-control" name="receive">
			<option>${money.receive1 }</option>
			<option>${money.receive2 }</option>
			<option>${money.receive3 }</option>
		</select>
	</div>
	
	<table style="border: none;text-align: center;">
		<tr>
			<td width="145px">名称</td>
			<td width="75px">制作</td>
			<td width="75px">单价</td>
			<td width="75px">数量</td>
			<td width="75px">总价</td>
		</tr>
	
		<c:forEach items="${goodsList}" var="goods">
			<tr >
				
				<td style="width: 145px;">${goods.gname}</td>
				<td>${goods.maker}</td>
				<td style="width: 75px;">${goods.price}</td>
				<td>
					<input style="text-align: center;width: 75px;" type="text" value="${goods.quantity}" name="orderquantity" readonly="readonly"/>
				</td>
				<td class="count1" style="width: 75px;color:blue;">${goods.nowcount}</td>			
				
			</tr>
			
			
		</c:forEach>
	</table>
		<h3>订单总价</h3>
		<input value="${allcount}" style="color: red;text-align: center;font-weight: bolder;font-size: 6mm" type="text" readonly="readonly" id="allcount" name="orderallcount" /><br><br>
		<button onclick="return confirm('确定结账么？')" type="submit" class="btn btn-primary">结账</button>
</form>
</div>


	<script type="text/javascript">

	
	
	
	</script>
</body>
</html>