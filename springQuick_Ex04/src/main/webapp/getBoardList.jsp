<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>글 목록</title>
		<style>
			div {
				text-align: center;
				font-size: 21px;
			}

			form > table, div > table {
				margin: 0 auto;
			}
		</style>
	</head>
	<body>
		<div>
			<h1><spring:message code="message.board.list.mainTitle"/></h1>
			<h3>${ userName }<spring:message code="message.board.list.welcomeMsg"/><a href="logout.do">Log-out</a></h3>
			<!-- 검색 시작 -->
			<form action="getBoardList.do" method="POST">
				<table border="1" cellpadding="0" cellspacing="0" width="700">
					<tr>
						<td align="right">
							<select name="searchCondition">
							<c:forEach items="${conditionMap}" var="option">
								<option value="${option.value}">${option.key}											
							</c:forEach>
							</select>
							<input name="searchKeyword" type="text" />
							<input type="submit" value="<spring:message code="message.board.list.search.condition.btn"/>" />
						</td>
				</table>
			</form>
			<!-- 검색 종료 -->
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.seq"/></th>
					<th bgcolor="orange" width="200"><spring:message code="message.board.list.table.head.title"/></th>
					<th bgcolor="orange" width="150"><spring:message code="message.board.list.table.head.writer"/></th>
					<th bgcolor="orange" width="150"><spring:message code="message.board.list.table.head.regDate"/></th>
					<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.cnt"/></th>
				</tr>
				<c:forEach items="${boardList}" var="board">
				<tr>
					<td>${board.seq}</td>
					<td align="left"><a href="getBoard.do?seq=${board.seq}">${board.title}</a></td>
					<td>${board.writer}</td>
					<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"/></td>
					<td>${board.cnt}</td>
				</tr>
				</c:forEach>
			</table>
			<br>
			<a href="insertBoard.jsp"><spring:message code="message.board.list.link.insertBoard"/></a>
		</div>
	</body>
</html>