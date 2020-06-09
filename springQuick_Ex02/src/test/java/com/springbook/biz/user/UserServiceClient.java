package com.springbook.biz.user;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		// 2. Spring 컨테이너로부터 BoardServiceImpl 객체를 Lookup한다.
		UserService userService = (UserService) container.getBean("userService");

		// 3. 회원 조회 기능 테스트
		UserVO bean = new UserVO();
		bean.setId("admin1");
		bean.setPassword("admin");
		bean.setName("admin");
		bean.setRole("admin");

//		userService.insertUser(bean);
//		userService.deleteUser(bean);

//		UserBean user = userService.getUser(bean);
//		if (user != null) {
//			System.out.println(user.getName() + "님 환영합니다.");
//		} else {
//			System.out.println("로그인 실패");
//		}
		
		List<UserVO> list = userService.getUserList(bean);
		for (UserVO user : list) {
			System.out.println(user.toString());
		}

		// 5. Spring 컨테이너 종료
		container.close();
	}
}