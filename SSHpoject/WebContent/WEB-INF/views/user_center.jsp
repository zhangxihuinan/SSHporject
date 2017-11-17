<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<title>REGISTRY PAGE</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
		<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>

<body>
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
	

<div align="center">
	<div style=" width: 210px; height: 250px;">
		<img style="height: 200px;width: 200px;" src="${detail.filePath }" class="img-circle">
		
		<form action="${pageContext.request.contextPath }/user_upload.action?uid=${user.uid }"
			method="post" enctype="multipart/form-data">
			<br /><input id="file1" type="file" name="upload" style="display: none;"/><br />
		
		<button id="but1" type="button" class="btn btn-primary">更换头像</button>	
		<button id="st1" type="submit" class="btn btn-primary" onclick="return confirm('确认修改头像么？')" style="display: none;">上传</button>	
	</form>
	</div><br><br><br>
	
	<form class="form-horizontal" role="form" 
		action="${pageContext.request.contextPath }/user_center_update.action" method="post">
	<div style="width: 400px;">
		<div class="form-group" style="width: 600px;">
			<label for="firstname" class="col-sm-2 control-label">用户账号</label>
			<div class="col-sm-10" style="width: 300px">
				<input style="background-color: #e5e5e5;" readonly="readonly" type="text" class="form-control" name="username" value="${user.username }"
					   placeholder="用户账号">
				<input type="text" value="${user.uid }" name="uid" style="display: none;"/>
				<input type="text" value="${user.priority }" name="priority" style="display: none;"/>
				<input type="text" value="${user.adddate }" name="adddate" style="display: none;"/>
				<input type="text" value="${detail.filePath }" name="filePath" style="display: none;"/>
			</div>
		</div>
		<div class="form-group" align="center" style="width: 600px;">
			<label for="lastname" class="col-sm-2 control-label">用户密码</label>
			<div class="col-sm-10" style="width: 300px" align="center">
				<input type="text" class="form-control" name="password" value="${user.password }"
					   placeholder="用户密码">
			</div>
		</div>
		<div class="form-group" align="center" style="width: 600px;">
			<label for="lastname" class="col-sm-2 control-label">真实姓名</label>
			<div class="col-sm-10" style="width: 300px" align="center">
				<input type="text" class="form-control" name="realname" value="${detail.realname }"
					   placeholder="真实姓名">
			</div>
		</div>
		<div class="form-group" align="center" style="width: 600px;">
			<label for="lastname" class="col-sm-2 control-label">用户性别</label>
			<div class="col-sm-10" style="width: 300px" align="center">
				<input type="text" class="form-control" name="sex" value="${detail.sex }"
					   placeholder="用户性别">
			</div>
		</div>
		<div class="form-group" align="center" style="width: 600px;">
			<label for="lastname" class="col-sm-2 control-label">手机号码</label>
			<div class="col-sm-10" style="width: 300px" align="center">
				<input type="text" class="form-control" name="phone" value="${detail.phone }"
					   placeholder="手机号码">
			</div>
		</div>
		<div class="form-group" align="center" style="width: 600px;">
			<label for="lastname" class="col-sm-2 control-label">出生日期</label>
			<div class="col-sm-10" style="width: 300px" align="center">
				<input type="date" class="form-control" name="birthday" value="${detail.sqlbirthday}"
					   placeholder="出生日期">
			</div>
		</div><br>
		
			
			<div style="width: 100px;">
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-danger" onclick="return confirm('确认修改该账号资料么？')">修改资料</button>
				</div>
			</div>
			</div>
	</div>
	</form>
</div>
	<script type="text/javascript">
		$("#but1").click(function(){
			$("#st1").show(300);
			$("#file1").show(300);
			$("#but1").hide(300);
		 });
		
		$("#st1").click(function(){
			$("#st1").hide(300);
			$("#file1").hide(300);
			$("#but1").show(300);
		 });
		
	</script>
</body>

</html>