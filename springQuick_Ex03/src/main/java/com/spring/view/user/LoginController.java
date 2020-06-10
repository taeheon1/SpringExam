package com.spring.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserBean;
import com.springbook.biz.user.impl.UserDAO;

public class LoginController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로그인 처리");

		// 1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		if (request.getMethod().equals("GET")) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("login");

			return mav;
		}

		// 2. DB 연동 처리
		UserBean bean = new UserBean();
		bean.setId(id);
		bean.setPassword(password);

		UserDAO userDAO = new UserDAO();
		UserBean user = userDAO.getUser(bean);

		// 3. 화면 네비게이션
		ModelAndView mav = new ModelAndView();
		if (user != null) {
			mav.setViewName("redirect:getBoardList.do");
		} else {
			mav.setViewName("login");
		}

		return mav;
	}

}