package com.springbook.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardBean;

@Repository
public class BoardDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;

	// 글 등록
	public void insertBoard(BoardBean bean) {
		System.out.println("===> Mybatis로 insertBoard() 기능 처리");
		mybatis.insert("BoardDAO.insertBoard", bean);
	}

	// 글 수정
	public void updateBoard(BoardBean bean) {
		System.out.println("===> Mybatis로 updateBoard() 기능 처리");
		mybatis.update("BoardDAO.updateBoard", bean);
	}

	// 글 삭제
	public void deleteBoard(BoardBean bean) {
		System.out.println("===> Mybatis로 deleteBoard() 기능 처리");
		mybatis.delete("BoardDAO.deleteBoard", bean);
	}

	// 글 상세 조회
	public BoardBean getBoard(BoardBean bean) {
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		return (BoardBean) mybatis.selectOne("BoardDAO.getBoard", bean);
	}

	// 글 목록 조회
	public List<BoardBean> getBoardList(BoardBean bean) {
		System.out.println("===> Mybatis로 getBoardList() 기능 처리");
		return mybatis.selectList("BoardDAO.getBoardList", bean);
	}
	
	// 글 조회수 증가
	public void plusCnt(BoardBean bean) {
		mybatis.update("plusCnt", bean);
	}
}
