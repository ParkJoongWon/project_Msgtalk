package banana;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MsgListDAO_Spring implements MsgListDAO {
	
	private JdbcTemplate jdbcTemplate = null;
	public JdbcTemplate getJdbcTemplate() { return jdbcTemplate; }
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }
	
	// sql.txt 에 msg_List_T 의 sql 문이 있습니다.
	@Override
	public List<MsgListVO> findAll() throws Exception {
		RowMapper<MsgListVO> rowMapper = new RowMapper<MsgListVO>() {
			@Override
			public MsgListVO mapRow(ResultSet rs, int count) throws SQLException {
				MsgListVO vo = new MsgListVO();
				vo.setRoomNo(rs.getString("roomNo"));
				vo.setCreatedate(rs.getString("createdate"));
				return vo;
			}
		};
		List<MsgListVO> ls = jdbcTemplate.query("SELECT * FROM msg_List_T ORDER BY createdate DESC", rowMapper);
		
		return ls;
	}
	
	@Override
	public int createRoom(MsgListVO pvo, HttpServletRequest request) throws Exception {
		int uc = 0;
		Connection conn = null;
		Statement stmt = null;
		String roomNo = request.getParameter("roomNo");
		try {
			if( pvo.getRoomNo() != "" ) {
				Class.forName("org.mariadb.jdbc.Driver");
				
				//System.out.println(roomNo);
				
				conn = DriverManager.getConnection("jdbc:mariadb://183.111.242.21:3306/pukyung20","pukyung20","pukyung00!!1");
				stmt = conn.createStatement();
				
				String sql = "CREATE TABLE msg_T_"+pvo.getRoomNo()+" (";
					sql+= "boxColor VARCHAR(20) NULL,";
					sql+= "roomNo VARCHAR(100) NOT NULL,";
					sql+= "no INT NOT NULL AUTO_INCREMENT,";
					sql+= "username VARCHAR(100) NOT NULL,";
					sql+= "content VARCHAR(500) NOT NULL,";
					sql+= "postdate DATETIME NOT NULL,";
					sql+= "showip VARCHAR(20) NULL,";
					sql+= "ofn VARCHAR(500) NULL,";
					sql+= "fsn VARCHAR(500) NULL,";
					sql+= "PRIMARY KEY(no)";
					//sql+= "FOREIGN KEY (roomNo) REFERENCES msg_List_T (roomNo) ";
					sql+= ");";
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
	public int insertRoom(MsgListVO pvo, HttpServletRequest request) throws Exception {
		int uc = 0;
		Connection conn = null;
		Statement stmt = null;
		String roomNo = request.getParameter("roomNo");
		try {
			if( pvo.getRoomNo() != "" ) {
				Class.forName("org.mariadb.jdbc.Driver");
				
				//System.out.println(roomNo);
				
				conn = DriverManager.getConnection("jdbc:mariadb://183.111.242.21:3306/pukyung20","pukyung20","pukyung00!!1");
				stmt = conn.createStatement();
				
				String sql = "INSERT INTO msg_List_T VALUES ( '"+pvo.getRoomNo()+"', NOW() );";
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
	public MsgListVO findByRoomNo(MsgListVO pvo) throws Exception {
		MsgListVO vo = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://183.111.242.21:3306/pukyung20","pukyung20","pukyung00!!1");
			stmt = conn.prepareStatement("SELECT * FROM msg_List_T WHERE roomNo = ?");
			stmt.setString( 1, pvo.getRoomNo() );
			rs = stmt.executeQuery();
			
			if( rs.next() ) {
				vo = new MsgListVO();
				vo.setRoomNo(rs.getString("roomNo"));
				vo.setCreatedate(rs.getString("createdate"));
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
	public int deleteRoom(MsgListVO pvo) throws Exception {
		int uc = 0;
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://183.111.242.21:3306/pukyung20","pukyung20","pukyung00!!1");
			stmt = conn.createStatement();
			String sql = "DELETE FROM msg_List_T WHERE roomNo='" + pvo.getRoomNo() + "'";
			uc = stmt.executeUpdate(sql);
		}
		catch( Exception e ) { throw e; }
		finally {
			if( stmt != null ) stmt.close();
			if( conn != null ) conn.close();
		}
		return uc;
	}
	
	@Override
	public int dropRoom(MsgListVO pvo) throws Exception {
		int uc = 0;
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://183.111.242.21:3306/pukyung20","pukyung20","pukyung00!!1");
			stmt = conn.createStatement();
			String sql = "DROP TABLE msg_T_"+pvo.getRoomNo()+";";
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
