<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>修改密码</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="css/bootstrap.css"/> 
</head>
<body>
<div class="container-fluid">

	<!-- 头部 -->
	<jsp:include page="/admin/header.jsp"></jsp:include>

	<br><br>
	<c:if test="${!empty msg }"><div class="alert alert-success">${msg }</div></c:if>
	<c:if test="${!empty filMsg }"><div class="alert alert-danger">${filMsg}</div></c:if>
	<form class="form-horizontal" action="${pageContext.request.contextPath }/admin/password_reset" method="post">
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">用户名</label>
			<div class="col-sm-5">${user.name }</div>
		</div>
		<div class="form-group">
			<label for="input_pass" class="col-sm-1 control-label">原密码</label>
			<div class="col-sm-5">
				<input type="password" class="form-control" id="input_pass" name="password" required="required">
			</div>
		</div>
		<div class="form-group">
			<label for="input_pass_new" class="col-sm-1 control-label">新密码</label>
			<div class="col-sm-5">
				<input type="password" class="form-control" id="input_pass" name="Newpassword" required="required">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-10">
				<button type="submit" class="btn btn-success">提交修改</button>
			</div>
		</div>
	</form>
	
	<span style="color:red;"></span>
	
</div>	
</body>
</html>