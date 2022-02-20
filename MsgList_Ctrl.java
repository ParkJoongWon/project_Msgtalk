package banana;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MsgList_Ctrl {
	
	private MsgListDAO msgListDao = null;
	public MsgListDAO getMsgListDao() { return msgListDao; }
	public void setMsgListDao(MsgListDAO msgListDao) { this.msgListDao = msgListDao; }
	
	// http://localhost:8080/project_main/roomlist.link
	@RequestMapping("/roomlist.link")
	public ModelAndView roomlist(@ModelAttribute MsgListVO vo, HttpSession session) throws Exception {
		Object roomNo = session.getAttribute("roomNo");
		System.out.println(roomNo);
		
		Object roomPW = session.getAttribute("roomPW");
		System.out.println(roomPW);
		
		Object userPassword = session.getAttribute("userPassword");
		//System.out.println(userPassword);
		
		ModelAndView mnv = new ModelAndView();
		
		if( userPassword.equals("1111") ) {
			mnv.setViewName("MsgRoom_list1111");
			mnv.addObject("talkroom", msgListDao.findAll());
			return mnv;
		}
		else if( userPassword.equals("2222") || userPassword.equals("3333") ) {
			mnv.setViewName("MsgRoom_list2222");
			mnv.addObject("talkroom", msgListDao.findAll());
			return mnv;
		}
		else {
			mnv.setViewName("Msg_loginGo");
			return mnv;
		}
	}
	
	/*
	@RequestMapping("/add2room.link")
	public String addroom(@RequestParam(value="roomNo",required=false) String roomNo, HttpSession session) throws Exception {
		session.setAttribute("roomNo", roomNo);
		return "redirect:list.link";
	}
	*/

	@RequestMapping("/addroom.link")
	public String addroom(@ModelAttribute MsgListVO vo, HttpServletRequest request) throws Exception {
		String roomNo = request.getParameter("roomNo");
		vo.setRoomNo(roomNo);
		//String roomPW = request.getParameter("roomPW");
		//vo.setRoomNo(roomPW);
		
		msgListDao.createRoom( vo, request );
		msgListDao.insertRoom( vo, request );
		return "redirect:roomlist.link";
	}
	
	@RequestMapping("/delroom.link")
	public String delroom(@RequestParam(value="roomNo",required=false) String roomNo) throws Exception {
		
		MsgListDAO dao = new MsgListDAO_Spring();
		
		MsgListVO po = new MsgListVO();
		po.setRoomNo(roomNo);
		dao.findByRoomNo(po);
		dao.deleteRoom(po);
		dao.dropRoom(po);
		
		return "redirect:roomlist.link";
	}
}
