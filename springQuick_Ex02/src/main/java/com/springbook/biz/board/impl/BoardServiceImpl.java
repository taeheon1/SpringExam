package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAOSpring boardDAO;

	public void insertBoard(BoardVO bean) {
//		if (bean.getSeq() == 0) {
//			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
//		}
		boardDAO.insertBoard(bean);
	}

	public void updateBoard(BoardVO bean) {
		boardDAO.updateBoard(bean);
	}

	public void deleteBoard(BoardVO bean) {
		boardDAO.deleteBoard(bean);
	}

	public BoardVO getBoard(BoardVO bean) {
		return boardDAO.getBoard(bean);
	}

	public List<BoardVO> getBoardList(BoardVO bean) {
		return boardDAO.getBoardList(bean);
	}
	
//	public BoardVO addCnt(BoardVO bean) {
//		return boardDAO.addCnt(bean);
//	}

}