package banana;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface MsgListDAO {
	public List<MsgListVO> findAll() throws Exception;
	public int createRoom(MsgListVO pvo, HttpServletRequest request) throws Exception;
	public int insertRoom(MsgListVO pvo, HttpServletRequest request) throws Exception;
	public MsgListVO findByRoomNo(MsgListVO pvo) throws Exception;
	public int deleteRoom(MsgListVO pvo) throws Exception;
	public int dropRoom(MsgListVO pvo) throws Exception;
}
