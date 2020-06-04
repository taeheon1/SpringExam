package board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import board.dto.BoardDto;

public class BoardDaoImpl implements BoardDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<BoardDto> list() {
		String sql = "SELECT * FROM tblspringboard ORDER BY seq DESC";
		List<BoardDto> result = new ArrayList<BoardDto>();
		RowMapper<BoardDto> mapper = new RowMapper<BoardDto>() {
			public BoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardDto dto = new BoardDto();
				dto.setSeq(rs.getInt("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setPassword(rs.getString("password"));
				dto.setHitcount(rs.getInt("hitcount"));
				return dto;
			}
		};
		result = jdbcTemplate.query(sql, mapper);

		return result;
	}

	@Override
	public BoardDto findBySeq(int seq) {
		String sql = "select * from tblspringboard where seq=?";
		BoardDto dto = (BoardDto) jdbcTemplate.query(sql, new BoardPreparedStatementSetterForPrimaryKey(seq),
				new UserResultSetExtractor());
		return dto;
	}

	// 쿼리문 파라미터에 값을 매칭시키는 내부 클래스
	private class BoardPreparedStatementSetterForPrimaryKey implements PreparedStatementSetter {
		private Integer seq;

		public BoardPreparedStatementSetterForPrimaryKey(Integer seq) {
			super();
			this.seq = seq;
		}

		@Override
		public void setValues(PreparedStatement ps) throws SQLException {
			ps.setInt(1, seq);
		}
	}

	private class UserResultSetExtractor implements ResultSetExtractor {
		@Override
		public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
			// 직접 하나 하나 처리해야 함. RowMapper 는 스프링이 반복해서 처리해줌.
			if (rs.next()) {
				BoardDto dto = new BoardDto();
				dto.setSeq(rs.getInt("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setPassword(rs.getString("password"));
				dto.setHitcount(rs.getInt("hitcount"));
				return dto;
			}
			throw new DataRetrievalFailureException("해당 객체를 찾을 수 없음");
		}
	}

	@Override
	public void insert(BoardDto dto) {
		String sql = "insert into tblspringboard ( seq, title, content,writer, regdate, hitcount, password) "
				+ " values (seq_tblspringboard.nextval, ?, ?, ?, sysdate, 0, '1234')";
		jdbcTemplate.update(sql,
				new BoardPreparedStatementSetterForInsert(dto.getTitle(), dto.getContent(), dto.getWriter()));
	}

	private class BoardPreparedStatementSetterForInsert implements PreparedStatementSetter {
		private String title;
		private String content;
		private String writer;

		public BoardPreparedStatementSetterForInsert(String title, String content, String writer) {
			super();
			this.title = title;
			this.content = content;
			this.writer = writer;
		}

		public void setValues(PreparedStatement ps) throws SQLException {
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setString(3, writer);
		}
	}

	public void update(BoardDto dto) {
		String sql = "update tblspringboard set title=? , content=? where seq=?";
		Object[] val = new Object[] { dto.getTitle(), dto.getContent(), dto.getSeq() };
		jdbcTemplate.update(sql, val);
	}

	public void delete(int seq) {
		String sql = "delete from tblspringboard where seq=?";
		Object[] val = new Object[] { seq };
		jdbcTemplate.update(sql, val);
	}
}
