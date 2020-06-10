package com.spring.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardBean;
import com.springbook.biz.board.impl.BoardDAO;

public class InsertBoardController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("글 등록 처리");
		
//		if (request.getMethod().equals("GET")) {
//			ModelAndView mav = new ModelAndView();
//			mav.setViewName("insertBoard");
//
//			return mav;
//		}

		// 1. 사용자 입력 정보 추출
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		if (title == null || title.equals("")) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("insertBoard");

			return mav;
		}

		// 2. DB 연동 처리
		BoardBean bean = new BoardBean();
		bean.setTitle(title);
		bean.setWriter(writer);
		bean.setContent(content);

		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(bean);

		// 3. 화면 네비게이션
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");

		return mav;
	}

}