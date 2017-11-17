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
<div align="center" style="border: 1px solid black;">
	<h1 style="color: red;">${str}</h1>
	<form class="form-horizontal" role="form" 
		action="${pageContext.request.contextPath }/user_registry.action" method="post">
		<div class="form-group" style="width: 600px;">
			<label for="firstname" class="col-sm-2 control-label">用户账号</label>
			<div class="col-sm-10" style="width: 300px">
				<input type="text" class="form-control" name="username" value="user01"
					   placeholder="用户账号">
				<input type="text" value="goodsImg\user\default.png" name="filePath" style="display: none;"/>
			</div>
		</div>
		<div class="form-group" align="center" style="width: 600px;">
			<label for="lastname" class="col-sm-2 control-label">用户密码</label>
			<div class="col-sm-10" style="width: 300px" align="center">
				<input type="text" class="form-control" name="password" value="123"
					   placeholder="用户密码">
			</div>
		</div>
		<div class="form-group" align="center" style="width: 600px;">
			<label for="lastname" class="col-sm-2 control-label">真实姓名</label>
			<div class="col-sm-10" style="width: 300px" align="center">
				<input type="text" class="form-control" name="realname" value="大傻"
					   placeholder="真实姓名">
			</div>
		</div>
		<div class="form-group" align="center" style="width: 600px;">
			<label for="lastname" class="col-sm-2 control-label">用户性别</label>
			<div class="col-sm-10" style="width: 300px" align="center">
				<input type="text" class="form-control" name="sex" value="女"
					   placeholder="用户性别">
			</div>
		</div>
		<div class="form-group" align="center" style="width: 600px;">
			<label for="lastname" class="col-sm-2 control-label">手机号码</label>
			<div class="col-sm-10" style="width: 300px" align="center">
				<input type="text" class="form-control" name="phone" value="131"
					   placeholder="手机号码">
			</div>
		</div>
		<div class="form-group" align="center" style="width: 600px;">
			<label for="lastname" class="col-sm-2 control-label">出生日期</label>
			<div class="col-sm-10" style="width: 300px" align="center">
				<input type="date" class="form-control" name="birthday" value="2017-01-01"
					   placeholder="出生日期">
			</div>
		</div>
		
			
		<div style="height: 50px;width: 200px;">
		<div class="form-group" style="width: 100px;float: left;">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary" onclick="return confirm('确认注册该账号么？')">注册</button>
			</div>
		</div>
		</div>
	</form>
</div>

</body>

</html>