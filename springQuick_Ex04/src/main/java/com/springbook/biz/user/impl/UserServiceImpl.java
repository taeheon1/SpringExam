package com.springbook.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserBean;
import com.springbook.biz.user.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAOSpring userDAO;

//	public UserServiceImpl() {
//		userDAO = new UserDAO();
//	}

	public void insertUser(UserBean bean) {
		userDAO.insertUser(bean);
		userDAO.insertUser(bean);
	}

	public void updateUser(UserBean bean) {
		userDAO.updateUser(bean);
	}

	public void deleteUser(UserBean bean) {
		userDAO.deleteUser(bean);
	}

	public UserBean getUser(UserBean bean) {
		return userDAO.getUser(bean);
	}

	public List<UserBean> getUserList(UserBean bean) {
		return userDAO.getUserList(bean);
	}

}