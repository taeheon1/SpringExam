package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardBean;
import com.springbook.view.common.JDBCUtil;

@Repository
public class BoardDAO {
	// JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL 명령어들
	private final String BOARD_INSERT = "INSERT INTO board(seq, title, writer, content, filename) "
			+ "VALUES ((SELECT NVL(MAX(seq), 0) + 1 FROM board), ?, ?, ?, ?)";
	private final String BOARD_UPDATE = "UPDATE board SET title = ?, content = ? WHERE seq = ?";
	private final String BOARD_DELETE = "DELETE FROM board WHERE seq = ?";
	private final String BOARD_GET = "SELECT * FROM board WHERE seq = ?";
	private final String BOARD_LIST = "SELECT * FROM board ORDER BY seq DESC";
	private final String BOARD_LIST_T = "SELECT * FROM board WHERE title LIKE '%'||?||'%' ORDER BY seq DESC";
	private final String BOARD_LIST_C = "SELECT * FROM board WHERE content LIKE '%'||?||'%' ORDER BY seq DESC";

	// CRUD 기능의 메소드 구현

	// 글 등록
	public void insertBoard(BoardBean bean) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, bean.getTitle());
			stmt.setString(2, bean.getWriter());
			stmt.setString(3, bean.getContent());
			stmt.setString(4, bean.getFileName());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 글 수정
	public void updateBoard(BoardBean bean) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, bean.getTitle());
			stmt.setString(2, bean.getContent());
			stmt.setInt(3, bean.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 글 삭제
	public void deleteBoard(BoardBean bean) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, bean.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 글 상세 조회
	public BoardBean getBoard(BoardBean bean) {
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		BoardBean board = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, bean.getSeq());
			rs = stmt.executeQuery();
			if (rs.next()) {
				board = new BoardBean();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				board.setFileName(rs.getString("FILENAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return board;
	}

	// 글 목록 조회
	public List<BoardBean> getBoardList(BoardBean bean) {
		System.out.println("===> JDBC로 getBoardList() 기능 처리");
		List<BoardBean> boardList = new ArrayList<BoardBean>();
		try {
			conn = JDBCUtil.getConnection();
			if (bean.getSearchCondition().equals("TITLE")) {
				stmt = conn.prepareStatement(BOARD_LIST_T);
			} else if (bean.getSearchKeyword().equals("CONTENT")) {
				stmt = conn.prepareStatement(BOARD_LIST_C);
			}
			stmt.setString(1, bean.getSearchKeyword());
			rs = stmt.executeQuery();
			while (rs.next()) {
				BoardBean board = new BoardBean();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return boardList;
	}
}