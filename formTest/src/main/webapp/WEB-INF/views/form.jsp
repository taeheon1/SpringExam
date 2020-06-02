<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>form</title>
</head>
<body>
<h1>${ sampleData }</h1>
	<form action="formProc" method="post">
		번호 : <input type="text" name="num" value="7369"><br>
		이름 : <input type="text" name="name" value="ssss"><br>
			   <input type="submit" value="send"><br>
	</form>
</body>
</html>
