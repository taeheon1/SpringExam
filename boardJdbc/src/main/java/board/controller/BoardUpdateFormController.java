
package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.dao.BoardDao;
import board.dto.BoardDto;

@Controller
public class BoardUpdateFormController {
	private BoardDao boardDao;

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@RequestMapping(value = "/board_update.do")
	protected ModelAndView movieUpdateForm(HttpServletRequest req) {
		BoardDto dto = boardDao.findBySeq(Integer.parseInt(req.getParameter("seq")));
		ModelAndView view = new ModelAndView();
		view.setViewName("update");
		view.addObject("dto", dto);
		return view;
	}

	@RequestMapping(value = "/board_update.do", method = RequestMethod.POST)
	protected ModelAndView updateProcess(@ModelAttribute BoardDto dto) {
		System.out.println(dto);
		boardDao.update(dto);
		return new ModelAndView("redirect:board_list.do");
	}
}
