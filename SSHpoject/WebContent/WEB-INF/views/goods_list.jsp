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
		table{
			width: 700px;
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

	<h3 id="h3">${nowtype}商城</h3>
	
<nav class="navbar navbar-default" role="navigation" style="width: 702px;">

<div class="btn-group" style="float: left;margin-top: 8px;margin-left: 20px;">
	<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
	商品类型 
		<span class="caret"></span>
	</button>
	<ul class="dropdown-menu" role="menu">
		<li><a href="${pageContext.request.contextPath}/goods_findbygtypepage.action?gtype=book">书籍</a></li>
		<li><a href="${pageContext.request.contextPath}/goods_findbygtypepage.action?gtype=game">游戏</a></li>
		<li><a href="${pageContext.request.contextPath}/goods_findallpage.action">综合</a></li>
	</ul>
</div>

	<div class="container-fluid" style="float: right;"> 
	<form class="navbar-form navbar-left" role="search"
		 action="${pageContext.request.contextPath}/goods_findbynamepage.action" method="post">
		<div class="form-group">
			<input type="text" class="form-control" name="gname" placeholder="输入信息搜索商品">
		</div>
		<button type="submit" class="btn btn-default">搜索</button>
	</form>
	</div>
</nav>
	
	
	
	
	<div id="div2">
	<table>
		<tr>
			<td width="130px">封面</td>
			<td width="100px">编号</td>
			<td width="145px">名称</td>
			<td>制作</td>
			<td width="75px">单价</td>
			<td width="150px">操作</td>
		</tr>
	</table>
	<table>
		<c:forEach items="${goodsList}" var="goods">
			<tr>
				<td style="width: 130px;">
					<a href="#">
						<img alt="封面" src="${goods.filePath}" style="width: 130px;height: 170px;">
					</a>
				</td>
				<td style="width: 100px;">${goods.gid}</td>
				<td style="width: 145px;">${goods.gname}</td>
				<td>${goods.maker}</td>
				<td style="width: 75px;">${goods.price}</td>
				<td style="width: 150px;">
					 <button type="button" class="btn btn-primary" data-toggle="button" onclick="window.location.href='add_shoppingcart.action?gid=${goods.gid}&pageBegin=${pageBegin}';alert('添加成功!')">添加至购物车</button>
				</td>
			</tr>
			<tr height="20px"></tr>
		</c:forEach>
	</table>
	</div>
	<!-- 第几页 -->
	<%-- <h2>${pageBegin}</h2> --%>
	<!-- 总商品数量 --> 
	<%-- <h2>${all}</h2>  --%>
	<!-- 总页数 -->
	<%-- <h2>${page}</h2>  --%>
	
	<%-- <c:choose>  
  			<c:when test="">    如果  
  			</c:when>  
     
   			<c:otherwise>  否则  
   			</c:otherwise>  
		</c:choose>   --%>
<div id="div3">
	<ul class="pagination">
		<li><a href="${pageContext.request.contextPath}/goods_${fristurl }">&laquo;</a></li>
		
		<c:choose>
			<c:when test="${pageBegin > 1}">
				<li><a href="${pageContext.request.contextPath}/goods_${urlprev }">上一页</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
			</c:otherwise>
		</c:choose>	
			
				<li><a href="#">第${pageBegin}页</a></li>
		
		<c:choose>
			<c:when test="${pageBegin != page}">
				<li><a href="${pageContext.request.contextPath}/goods_${urlnext }">下一页</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
			</c:otherwise>
		</c:choose>
		<li><a href="${pageContext.request.contextPath}/goods_${urllast }">&raquo;</a></li>
	</ul>
	</div>
</div>
	<script>
		function begin() {
			var tx = $("#h3").text();
			if(tx == "商城"){
				alert("搜索结果不存在！");
				//返回上一页
				window.history.go(-1);
			}
		}
	</script>
</body>
</html>