package banana;

import java.util.List;

public interface MsgDAO {
	public List<MsgVO> findAll(MsgVO pvo) throws Exception;
	public int add(MsgVO pvo) throws Exception;
	public MsgVO findByNo(MsgVO pvo) throws Exception;
	public int delByNo(MsgVO pvo) throws Exception;
}
