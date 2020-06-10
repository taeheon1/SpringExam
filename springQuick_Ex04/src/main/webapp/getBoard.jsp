<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세</title>
<style>
div {
	text-align: center;
	font-size: 21px;
}

form>table, div>table {
	margin: 0 auto;
}
</style>
</head>
<body>
	<div>
		<h1>글 상세</h1>
		<a href="logout.do">Log-out</a>
		<hr>
		<form action="updateBoard.do" method="POST">
			<input type="hidden" name="seq" value="${board.seq}" />
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left"><input type="text" name="title"
						value="${board.title}" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">작성자</td>
					<td align="left">${board.writer}</td>
				</tr>
				<tr>
					<td bgcolor="orange">내용</td>
					<td align="left"><textarea name="content" cols="40" rows="10">${board.content}</textarea></td>
				</tr>
				<tr>
					<td bgcolor="orange">등록일</td>
					<td align="left">${board.regdate}</td>
				</tr>
				<tr>
					<td bgcolor="orange" width="100">조회수</td>
					<td align="left">${board.cnt}</td>
				</tr>
				<c:if test="${board.fileName ne null}">
					<tr>
						<td bgcolor="orange">첨부파일</td>
						<td align="left"><a
							href="fileDownload.do?fileName=${board.fileName}">${board.fileName}</a></td>
					</tr>
				</c:if>
				<tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="글 수정" /></td>
				</tr>
			</table>
		</form>
		<br> <a href="insertBoard.do">글등록</a>&nbsp;&nbsp;&nbsp; <a
			href="deleteBoard.do?seq=${board.seq}">글삭제</a>&nbsp;&nbsp;&nbsp; <a
			href="getBoardList.do">글목록</a>
	</div>
</body>
</html>