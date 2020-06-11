<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title><spring:message code="message.user.login.title"/></title>
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
			<h1><spring:message code="message.user.login.title"/></h1>
			<a href="login.do?lang=en">
				<spring:message code="message.user.login.language.en"/>
			</a>&nbsp;&nbsp;
			<a href="login.do?lang=ko">
				<spring:message code="message.user.login.language.ko"/>
			</a>
			<hr>
			<form action="login.do" method="POST">
				<table border="1" cellpadding="0" cellspacing="0">
					<tr>
						<td bgcolor="oragne"><spring:message code="message.user.login.id"/></td>
						<td><input type="text" name="id" value="${userBean.id}"/></td>
					</tr>
					<tr>
						<td bgcolor="oragne"><spring:message code="message.user.login.password"/></td>
						<td><input type="password" name="password" value="${userBean.password}" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit" value='<spring:message code="message.user.login.loginBtn"/>' /></td>
					</tr>
				</table>
			</form>
			<hr>
		</div>
	</body>
</html>