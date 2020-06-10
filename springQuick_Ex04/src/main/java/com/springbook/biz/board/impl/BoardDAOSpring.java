package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardBean;

@Repository
public class BoardDAOSpring {

	// SQL 명령어들
	private final String BOARD_INSERT = "INSERT INTO board(seq, title, writer, content) "
			+ "VALUES ((SELECT NVL(MAX(seq), 0) + 1 FROM board), ?, ?, ?)";
	private final String BOARD_UPDATE = "UPDATE board SET title = ?, content = ? WHERE seq = ?";
	private final String BOARD_DELETE = "DELETE FROM board WHERE seq = ?";
	private final String BOARD_GET = "SELECT * FROM board WHERE seq = ?";
	private final String BOARD_LIST = "SELECT * FROM board ORDER BY seq DESC";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(BoardBean bean) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		jdbcTemplate.update(BOARD_INSERT, bean.getTitle(), bean.getWriter(), bean.getContent());
	}

	// 글 수정
	public void updateBoard(BoardBean bean) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		jdbcTemplate.update(BOARD_UPDATE, bean.getTitle(), bean.getContent(), bean.getSeq());
	}

	// 글 삭제
	public void deleteBoard(BoardBean bean) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		jdbcTemplate.update(BOARD_DELETE, bean.getSeq());
	}

	// 글 상세 조회
	public BoardBean getBoard(BoardBean bean) {
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		Object[] args = { bean.getSeq() };

		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}

	// 글 목록 조회
	public List<BoardBean> getBoardList(BoardBean bean) {
		System.out.println("===> JDBC로 getBoardList() 기능 처리");

		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}
}