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
<body onload="changecount();nowerror()">
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
<form action="list_order.action" method="post">
	
	<table style="border: none;text-align: center;">
		<tr>
			<td>选择</td>
			<td width="145px">名称</td>
			<td>制作</td>
			<td width="75px">单价</td>
			<td width="75px">数量</td>
			<td width="75px">总价</td>
		</tr>
	
		<c:forEach items="${goodsList}" var="goods">
			<tr >
				<td>
					<input type="checkbox" id="sid" name="sid" value="${goods.sid}" ${goods.checkbox } onclick="f1()"/>
				</td>
				<td style="width: 145px;">${goods.gname}</td>
				<td>${goods.maker}</td>
				<td style="width: 75px;">${goods.price}</td>
				<td style="width: 75px;">
					<input type="number" min="1" max="99" value="1" name="quantity" onchange="count()"/>
				</td>
				<td class="count1" style="width: 75px;color:blue;">
					${goods.price}
				</td>			
				<td style="border: none;width: 20px;"></td>
				<td id="X" style="border: none;">
					<!-- 删除操作 -->
					<button value="${goods.sid}" type="button" class="btn btn-danger" data-toggle="button" onclick="window.location.href='delete_goods_shoppingcart.action?sid=${goods.sid}'">
						X
					</button>
				</td>
				<td style="display: none;">
					<input type="text" name="nowcount" readonly="readonly" value="${goods.price}"/>
				</td>
			</tr>
			
			<tr style="height: 10px"></tr>
		</c:forEach>
	</table>
		<h3>商品总价</h3>
		<input style="color: red;text-align: center;font-weight: bolder;font-size: 6mm" type="text" readonly="readonly" id="allcount" name="allcount" /><br><br>
		<button onclick="return confirm('确认提交该订单么？')" type="submit" class="btn btn-primary">提交订单</button>
</form>
<h1 style="display: none;" id="balanceError">${balanceError }</h1>
</div>


	<script type="text/javascript">
		function count() {
			var obj = event.target||event.srcElement;//得到点击的对象
			var value = $(obj).val();//就得到你点击的值了
			//单价
			var price = $(obj).parent().prev().text();
			//总价
			$(obj).parent().next().text(price*value);
			$(obj).parent().next().next().next().next().children().val(price*value);
			//alert(value);
			//alert(inner);
			allcount = 0;
			changecount();
		}
		var allcount = 0;
		function changecount(){ 
			$(".count1").each(function(){
				if($(this).prev().prev().prev().prev().prev().children().is(":checked")){
					allcount +=+ $(this).text();
				}
			  });
			$("#allcount").val(allcount);
		}
		
		
		
		
		
		function f1(){			
			var obj = event.target||event.srcElement;
			var baycount = $(obj).parent().next().next().next().next().next().text();
			var flag = $(obj).is(":checked");
			var value = $(obj).val();
			if (flag) {
				var thisAll = $("#allcount").val();
				var all = Number(thisAll) + Number(baycount);
				$("#allcount").val(all);
				$(function() {
					$.ajax({
						url: "http://localhost:8080/SSHpoject/add_usershoppingcart_checked.action?check=1&ssid="+value,
						type: "GET",
						asynch: true,
						dataType:"text",
						success: function(data) {
							
						}
					});
				});
			}else{
				$(function() {
					var thisAll = $("#allcount").val();
					var all = Number(thisAll) - baycount;
					$("#allcount").val(all);
					$.ajax({
						url: "http://localhost:8080/SSHpoject/add_usershoppingcart_checked.action?check=0&ssid="+value,
						type: "GET",
						asynch: true,
						dataType:"text",
						success: function(data) {
							
						}
					});
				});
			}
			
		}
		
		function nowerror() {
			var tx = $("#balanceError").text();
			if (tx == "balanceError") {
				alert("账户余额不足请充值！");
				location.assign("user_center.action");
			}
		}
	
	</script>
</body>
</html>