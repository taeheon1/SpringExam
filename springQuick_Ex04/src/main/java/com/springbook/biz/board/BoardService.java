package com.springbook.biz.board;

import java.util.List;

public interface BoardService {
	// CRUD 기능의 메소드 구현
	
	// 글 등록
	void insertBoard(BoardBean bean);

	// 글 수정
	void updateBoard(BoardBean bean);

	// 글 삭제
	void deleteBoard(BoardBean bean);

	// 글 상세 조회
	BoardBean getBoard(BoardBean bean);

	// 글 목록 조회
	List<BoardBean> getBoardList(BoardBean bean);
}