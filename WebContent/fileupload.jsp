<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/FileUpLoad" enctype="multipart/form-data" method="post">
	上传用户:<input type="text" name="username" /><br/>
	上传文件1:<input type="file" name="file1"/><br/>
	上传文件2:<input type="file" name="file2"/><br/>
	上传文件3:<input type="file" name="file3"/><br/>
</form>
</body>
</html>