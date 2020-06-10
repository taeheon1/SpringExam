package com.spring.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BoardBean;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {

	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	// 글 등록
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardBean bean, BoardDAO boardDAO) {
		boardDAO.insertBoard(bean);
		return "getBoardList.do";
	}
	
	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardBean bean, BoardDAO boardDAO){
		System.out.println("번호 : " + bean.getSeq());
		System.out.println("제목 : " + bean.getTitle());
		System.out.println("작성자 : " + bean.getWriter());
		System.out.println("내용 : " + bean.getContent());
		System.out.println("등록일 : " + bean.getRegdate());
		System.out.println("조회수 : " + bean.getCnt());
		boardDAO.updateBoard(bean);
		return "getBoardList.do";
	}
	
	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardBean bean, BoardDAO boardDAO){
		boardDAO.deleteBoard(bean);
		return "getBoardList.do";
	}
	
	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardBean bean, BoardDAO boardDAO, Model model) {
		model.addAttribute("board", boardDAO.getBoard(bean));
		return "getBoard.jsp";
	}
	
	// 글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(@RequestParam(value="serchCondition", defaultValue="TITLE", required = false) String condition, @RequestParam(value="searchKeyword",
	defaultValue="", required = false) String keyword, BoardBean bean, BoardDAO boardDAO, Model model) {
		System.out.println("검색 조건 : " + condition);
		System.out.println("검색 단어 : " + keyword);
		model.addAttribute("boardList", boardDAO.getBoardList(bean));
		return "getBoardList.jsp";
	}
}
