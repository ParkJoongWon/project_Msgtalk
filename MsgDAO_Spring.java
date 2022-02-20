package banana;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MsgDAO_Spring implements MsgDAO {
	
	private JdbcTemplate jdbcTemplate = null;
	public JdbcTemplate getJdbcTemplate() { return jdbcTemplate; }
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

	@Override
	public List<MsgVO> findAll(MsgVO pvo) throws Exception {
		RowMapper<MsgVO> rowMapper = new RowMapper<MsgVO>() {
			@Override
			public MsgVO mapRow(ResultSet rs, int count) throws SQLException {
				MsgVO vo = new MsgVO();
				vo.setBoxColor(rs.getString("boxColor"));
				vo.setRoomNo(rs.getString("roomNo"));
				vo.setNo(rs.getInt("no"));
				vo.setUsername(rs.getString("username"));
				vo.setContent(rs.getString("content"));
				vo.setPostdate(rs.getString("postdate"));
				vo.setShowip(rs.getString("showip"));
				vo.setOfn(rs.getString("ofn"));
				vo.setFsn(rs.getString("fsn"));
				return vo;
			}
		};
		List<MsgVO> ls = jdbcTemplate.query("SELECT * FROM msg_T_"+pvo.getRoomNo()+" ORDER BY no ASC", rowMapper);
		
		return ls;
	}
	
	
	
	@Override
	public int add(MsgVO pvo) throws Exception {
		int uc = 0;
		Connection conn = null;
		Statement stmt = null;
		try {
			if( pvo.getContent() != "" ) {
				Class.forName("org.mariadb.jdbc.Driver");
				
				conn = DriverManager.getConnection("jdbc:mariadb://183.111.242.21:3306/pukyung20","pukyung20","pukyung00!!1");
				stmt = conn.createStatement();
				
				String sql = "INSERT INTO msg_T_"+pvo.getRoomNo()+" VALUES ( '#"+Util.alterColor(pvo.getShowip())+"', '"+pvo.getRoomNo()+"', default, '"+ pvo.getUsername() +"', '"+ Util.han(pvo.getContent()) +"', NOW(), '"+ pvo.getShowip() +"', '"+Util.han(pvo.getOfn())+"', '"+Util.han(pvo.getFsn())+"')";
				uc = stmt.executeUpdate(sql);
			}
		}
		catch(Exception e) { 
			e.printStackTrace();
			throw e; 
		}
		finally {
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
		return uc;
	}
	
	
	
	@Override
	public MsgVO findByNo(MsgVO pvo) throws Exception {
		MsgVO vo = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://183.111.242.21:3306/pukyung20","pukyung20","pukyung00!!1");
			stmt = conn.prepareStatement("SELECT * FROM msg_T_"+pvo.getRoomNo()+" WHERE no = ?");
			stmt.setInt( 1, pvo.getNo() );
			rs = stmt.executeQuery();
			
			if( rs.next() ) {
				vo = new MsgVO();
				vo.setBoxColor(rs.getString("boxColor"));
				vo.setRoomNo(rs.getString("roomNo"));
				vo.setNo(rs.getInt("no"));
				vo.setUsername(rs.getString("username"));
				vo.setContent(rs.getString("content"));
				vo.setPostdate(rs.getString("postdate"));
				vo.setShowip(rs.getString("showip"));
				vo.setOfn(rs.getString("ofn"));
				vo.setFsn(rs.getString("fsn"));
			}
		}
		catch( Exception e ) {
			throw e; 
		}
		finally {
			if( rs != null ) rs.close();
			if( stmt != null ) stmt.close();
			if( conn != null ) conn.close();
		}
		return vo;
	}
	
	@Override
	public int delByNo(MsgVO pvo) throws Exception {
		int uc = 0;
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://183.111.242.21:3306/pukyung20","pukyung20","pukyung00!!1");
			stmt = conn.createStatement();
			String sql = "DELETE FROM msg_T_"+pvo.getRoomNo()+" WHERE no = " + pvo.getNo();
			uc = stmt.executeUpdate(sql);
		}
		catch( Exception e ) { throw e; }
		finally {
			if( stmt != null ) stmt.close();
			if( conn != null ) conn.close();
		}
		return uc;
	}
}