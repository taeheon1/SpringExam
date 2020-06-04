<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<script type="text/javascript">
	function fnList() {
		location.href = "board_list.do";		
	}
	function fnUpdate() {
		location.href = "board_update.do?seq=" + ${ board.seq };		
	}
	function fnDelete() {
		location.href = "board_delete.do?seq=" + ${ board.seq };		
	}
</script>
</head>
<body>
	<div align="center">
		<h1>상세보기</h1>
		<table border="1">
			<tr>
				<th>번호</th><td>${ board.seq }</td>
				<th>제목</th><td>${ board.title }</td>
				<th>내용</th><td>${ board.content }</td>
			</tr><tr>
				<td colspan="2" align="center">
				<input type="button" value="임수정" onclick="fnUpdate()">
				<input type="button" value="삭제" onclick="fnDelete()">
				<input type="button" value="목록" onclick="fnList()">
				</td></tr>
		</table></div>
</body>
</html>