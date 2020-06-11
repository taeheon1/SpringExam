package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.springbook.biz.user.UserBean;
import com.springbook.view.common.JDBCUtil;

public class UserDAO {
	// JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// SQL 명령어들
	private final String USER_INSERT = "INSERT INTO users(id, password, name, role) VALUES (?, ?, ?, ?)";
	private final String USER_UPDATE = "UPDATE users SET password = ?, role = ? WHERE id = ?";
	private final String USER_DELETE = "DELETE FROM users WHERE id = ?";
	private final String USER_GET = "SELECT * FROM users WHERE id = ? AND password = ?";
	private final String USER_LIST = "SELECT * FROM users";

	// CRUD 기능의 메소드 구현
	// 회원 등록
	public void insertUser(UserBean bean) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1, bean.getId());
			stmt.setString(2, bean.getPassword());
			stmt.setString(3, bean.getName());
			stmt.setString(4, bean.getRole());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 회원 수정
	public void updateUser(UserBean bean) {
		System.out.println("===> JDBC로 updateUser() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_UPDATE);
			stmt.setString(1, bean.getPassword());
			stmt.setString(2, bean.getRole());
			stmt.setString(3, bean.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 회원 삭제
	public void deleteUser(UserBean bean) {
		System.out.println("===> JDBC로 deleteUser() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_DELETE);
			stmt.setString(1, bean.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 회원 정보 조회
	public UserBean getUser(UserBean bean) {
		System.out.println("===> JDBC로 getUser() 기능 처리");
		UserBean user = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, bean.getId());
			stmt.setString(2, bean.getPassword());
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new UserBean();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return user;
	}

	// 회원 목록 조회
	public List<UserBean> getUserList(UserBean bean) {
		System.out.println("===> JDBC로 getUserList() 기능 처리");
		List<UserBean> userList = new ArrayList<UserBean>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_LIST);
			rs = stmt.executeQuery();
			while (rs.next()) {
				UserBean user = new UserBean();
				user.setId((rs.getString("ID")));
				user.setName((rs.getString("NAME")));
				user.setRole((rs.getString("ROLE")));
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return userList;
	}
}