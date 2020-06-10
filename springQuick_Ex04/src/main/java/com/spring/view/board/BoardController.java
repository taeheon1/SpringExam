package com.spring.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardBean;
import com.springbook.biz.board.BoardService;

@Controller
@SessionAttributes("board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	// 글 등록
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardBean bean) throws IOException {
		//파일 업로드 처리
		String fileName = null;
		MultipartFile uploadFile = bean.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String originalFileName = uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFileName);
			UUID uuid = UUID.randomUUID();
			fileName=uuid + "." +ext;
			uploadFile.transferTo(new File("C:\\upload\\" + fileName));
		}
		bean.setFileName(fileName);
		boardService.insertBoard(bean);
		return "getBoardList.do";
	}
	
	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardBean bean){
		boardService.updateBoard(bean);
		return "getBoardList.do";
	}
	
	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardBean bean){
		boardService.deleteBoard(bean);
		return "getBoardList.do";
	}
	
	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardBean bean, Model model) {
		model.addAttribute("board", boardService.getBoard(bean));
		return "getBoard.jsp";
	}

	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	 
	// 글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(@RequestParam(value="serchCondition", defaultValue="TITLE", required = false) String condition, @RequestParam(value="searchKeyword",
	defaultValue="", required = false) String keyword, BoardBean bean, Model model) {
		// Null check
		if(bean.getSearchCondition() == null) bean.setSearchCondition("TITLE");
		if(bean.getSearchKeyword() == null) bean.setSearchKeyword("");
		// Model 정보 저장
		model.addAttribute("boardList", boardService.getBoardList(bean));
		return "getBoardList.jsp"; // View 이름 리턴
	}
}
