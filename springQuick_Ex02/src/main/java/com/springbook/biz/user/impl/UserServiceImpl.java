package com.springbook.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAOSpring userDAO;

	@Override
	public void insertUser(UserVO bean) {
		userDAO.insertUser(bean);
		userDAO.insertUser(bean);
	}

	@Override
	public void updateUser(UserVO bean) {
		userDAO.updateUser(bean);
	}

	@Override
	public void deleteUser(UserVO bean) {
		userDAO.deleteUser(bean);
	}

	public UserVO getUser(UserVO bean) {
		return userDAO.getUser(bean);
	}

	@Override
	public List<UserVO> getUserList(UserVO bean) {
		return userDAO.getUserList(bean);
	}

}