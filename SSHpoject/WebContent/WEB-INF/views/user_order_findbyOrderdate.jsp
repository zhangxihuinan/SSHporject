<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>商品一览</title>
<meta charset="utf-8" />
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style type="text/css">
		body{
			padding: 0;
			margin: 0;
		}
		td{
			border : 1px solid black;
			text-align: center;
		}
		#table1{
			width: 400px;
		}
		
		
	</style>
</head>
<body onload="begin()">
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

	<h3 id="h3">订单详情一览</h3>
	<br/><br/>
	<h4>订单编号：${orderdate }</h4>
	<h4>收货地址：${receive }</h4>
<div align="center" style="width: 700px;">
	<div style="width: 501px;">
	<div id="div2" style="float: left;">
	<table id="table1">
		<tr>
			<td width="100px">封面</td>
			<td >商品</td>
			<td >作者</td>
		</tr>
		<c:forEach items="${goodsList}" var="g">
			<tr>
				<td>
					<img style="height: 124px;width: 100px;" src="${g.filePath}">
				</td>
				<td >${g.gname}</td>
				<td >${g.maker}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<div style="float: left;">
		<table style="width: 100xp;">
			<tr>
				<td width="100px" height="20px;">购买数量</td>
			</tr>
		<c:forEach items="${orderList}" var="o">
			<tr>
				<td height="125px;">
					${o.quantity}
				</td>
			</tr>
		</c:forEach>
		</table>
		<br/>
		<br/>
	</div>
		<h2 style="color: red;">订单总价：${allcount }</h2>
	</div>
</div>
</div>
	<script>
	
	</script>
</body>
</html>