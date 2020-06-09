package com.springbook.biz.board;

import java.util.List;

public interface BoardService {
	// CRUD 기능의 메소드 구현
	// 글 등록
	void insertBoard(BoardVO bean);

	// 글 수정
	void updateBoard(BoardVO bean);

	// 글 삭제
	void deleteBoard(BoardVO bean);

	// 글 상세 조회
	BoardVO getBoard(BoardVO bean);

	// 글 목록 조회
	List<BoardVO> getBoardList(BoardVO bean);
}