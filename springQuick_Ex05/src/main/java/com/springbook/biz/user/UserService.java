package com.springbook.biz.user;

import java.util.List;

public interface UserService {
	// CRUD 기능의 메소드 구현
	// 회원 등록
	void insertUser(UserBean bean);

	// 회원 수정
	void updateUser(UserBean bean);

	// 회원 삭제
	void deleteUser(UserBean bean);

	// 회정 정보 조회
	UserBean getUser(UserBean bean);

	// 회원 목록 조회
	List<UserBean> getUserList(UserBean bean);
}