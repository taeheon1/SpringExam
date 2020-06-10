package com.springbook.biz.board.impl;

import java.util.List;

import com.springbook.biz.board.BoardBean;
import com.springbook.biz.board.BoardService;

public class BoardServiceImpl implements BoardService {
	private BoardDAO boardDAO;

	public BoardServiceImpl() {
		boardDAO = new BoardDAO();
	}

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

}