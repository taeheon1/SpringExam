<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
		<style>
			div {
				text-align: center;
				font-size: 18px;
			}

			form > table, div > table {
				margin: 0 auto;
			}
		</style>
	</head>
	<body>
		<div>
			<h1>로그인</h1>
			<hr>
			<form action="login.do" method="POST">
				<table border="1" cellpadding="0" cellspacing="0">
					<tr>
						<td bgcolor="oragne">아이디</td>
						<td><input type="text" name="id" value="${userBean.id}"/></td>
					</tr>
					<tr>
						<td bgcolor="oragne">비밀번호</td>
						<td><input type="password" name="password" value="${userBean.password}" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit" value="로그인" /></td>
					</tr>
				</table>
			</form>
			<hr>
		</div>
	</body>
</html>