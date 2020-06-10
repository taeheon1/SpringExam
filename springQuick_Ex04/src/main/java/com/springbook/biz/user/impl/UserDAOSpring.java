package com.springbook.biz.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserBean;

@Repository
public class UserDAOSpring {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// SQL 명령어들
	private final String USER_INSERT = "INSERT INTO users(id, password, name, role) VALUES (?, ?, ?, ?)";
	private final String USER_UPDATE = "UPDATE users SET password = ?, role = ? WHERE id = ?";
	private final String USER_DELETE = "DELETE FROM users WHERE id = ?";
	private final String USER_GET = "SELECT * FROM users WHERE id = ? AND password = ?";
	private final String USER_LIST = "SELECT * FROM users";

	// CRUD 기능의 메소드 구현
	// 회원 등록
	public void insertUser(UserBean bean) {
		System.out.println("===> JDBC로 insertUser() 기능 처리");
		jdbcTemplate.update(USER_INSERT, bean.getId(), bean.getPassword(), bean.getName(), bean.getRole());
	}

	// 회원 수정
	public void updateUser(UserBean bean) {
		System.out.println("===> JDBC로 updateUser() 기능 처리");
		jdbcTemplate.update(USER_UPDATE, bean.getPassword(), bean.getRole(), bean.getId());
	}

	// 회원 삭제
	public void deleteUser(UserBean bean) {
		System.out.println("===> JDBC로 deleteUser() 기능 처리");
		jdbcTemplate.update(USER_DELETE, bean.getId());
	}

	// 회원 정보 조회
	public UserBean getUser(UserBean bean) {
		System.out.println("===> JDBC로 getUser() 기능 처리");
		Object[] args = { bean.getId(), bean.getPassword() };

		return jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());
	}

	// 회원 목록 조회
	public List<UserBean> getUserList(UserBean bean) {
		System.out.println("===> JDBC로 getUserList() 기능 처리");

		return jdbcTemplate.query(USER_LIST, new UserRowMapper());
	}

	class UserRowMapper implements RowMapper<UserBean> {

		public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserBean user = new UserBean();
			user.setId(rs.getString("ID"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setName(rs.getString("NAME"));
			user.setRole(rs.getString("ROLE"));

			return user;
		}

	}
}