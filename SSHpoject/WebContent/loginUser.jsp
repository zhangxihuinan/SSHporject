<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Insert title here</title>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div align="center" style="margin-top: 200px;">
	<h1 style="color: red;">${str}</h1>
	<form class="form-horizontal" role="form" 
		action="${pageContext.request.contextPath }/user_login.action" method="post">
		<div class="form-group" style="width: 500px;">
			<label for="firstname" class="col-sm-2 control-label">账号</label>
			<div class="col-sm-10" style="width: 300px">
				<input type="text" class="form-control" name="username" value="zhangsan"
					   placeholder="请输入账号">
			</div>
		</div>
		
		<div class="form-group" align="center" style="width: 500px;">
			<label for="lastname" class="col-sm-2 control-label">密码</label>
			<div class="col-sm-10" style="width: 300px" align="center">
				<input type="password" class="form-control" name="password" value="123"
					   placeholder="请输入密码">
			</div>
		</div>
		<div style="height: 50px;width: 200px;">
		<div class="form-group" style="width: 100px;float: left;">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">登录</button>
			</div>
		</div>
		<div class="form-group" style="width: 100px;float: left;">
			<div class="col-sm-offset-2 col-sm-10">
				<button id="button1" type="button" class="btn btn-danger">注册</button>
			</div>
		</div>
		</div>
	</form>
</div>


	<script>
	$(function () {
        $("#button1").click(function(){
        	var flag = confirm("点击确认将前往注册页面");
        	if (flag == true) {
        		//location.assign("localhost:8080/SSHpoject/router_reg.action");
        		window.location.href="router_reg.action";	
			}
        });
    });
	</script>
</body>
</html>