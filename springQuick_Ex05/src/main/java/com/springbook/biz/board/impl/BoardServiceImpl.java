package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardBean;
import com.springbook.biz.board.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAOMybatis boardDAO;

	public void insertBoard(BoardBean bean) {
		boardDAO.insertBoard(bean);
	}

	public void updateBoard(BoardBean bean) {
		boardDAO.updateBoard(bean);
	}

	public void deleteBoard(BoardBean bean) {
		boardDAO.deleteBoard(bean);
	}

	public BoardBean getBoard(BoardBean bean) {
		return boardDAO.getBoard(bean);
	}

	public List<BoardBean> getBoardList(BoardBean bean) {
		return boardDAO.getBoardList(bean);
	}

	@Override
	public void plusCnt(BoardBean bean) {
		boardDAO.plusCnt(bean);
	}
}