package banana;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;

import banana.MsgDAO;
import banana.MsgDAO_Spring;
import banana.MsgVO;

@Controller
public class Msg_Ctrl {
	
	private MsgDAO msgDao = null;
	public MsgDAO getMsgDao() { return msgDao; }
	public void setMsgDao(MsgDAO msgDao) { this.msgDao = msgDao; }
	
	// http://localhost:8080/project_main/list.link
	@RequestMapping("/list.link")
	public ModelAndView list(@RequestParam(value="roomNo",required=false) String roomNo, @ModelAttribute MsgVO vo, HttpSession session) throws Exception {
		//Object roomNo = session.getAttribute("roomNo");
		session.setAttribute("roomNo", roomNo);
		//System.out.println(roomNo);
		
		Object userPassword = session.getAttribute("userPassword");
		//System.out.println(userPassword);
		
		ModelAndView mnv = new ModelAndView();
		
		if( userPassword.equals("1111") ) {
			mnv.setViewName("Msg_list111");
			mnv.addObject("talk", msgDao.findAll(vo));
			return mnv;
		}
		else if( userPassword.equals("2222") ) {
			mnv.setViewName("Msg_list222");
			mnv.addObject("talk", msgDao.findAll(vo));
			return mnv;
		}
		else if( userPassword.equals("3333") ) {
			mnv.setViewName("Msg_list333");
			mnv.addObject("talk", msgDao.findAll(vo));
			return mnv;
		}
		else {
			mnv.setViewName("Msg_login");
			return mnv;
		}
		
	}
	
	@RequestMapping("/add111.link")
	public String add111(@ModelAttribute MsgVO vo, HttpServletRequest request) throws Exception {
		MultipartRequest mpr = new MultipartRequest(request, Util.upload(), 1024*1024*16, null, null);
		
		String content = mpr.getParameter("content");
		
		String roomNo = mpr.getParameter("roomNo");
		vo.setRoomNo(roomNo);
		vo.setUsername("apple");
		vo.setShowip(Util.getRemoteAddr(request));
		vo.setContent(content);
		String ofn = mpr.getOriginalFileName("apple");
		
		if( (content == null || content.equals("")) && (ofn == null || ofn.equals("")) ) {
			return "redirect:list.link?ecode=invalid_content&roomNo="+vo.getRoomNo();
		}
		
		if( ofn == null ) {
			ofn = "null";
		}
		if( ofn != "null" && ofn != null ) {
			File file = mpr.getFile("apple");
			String fsn = UUID.randomUUID().toString();
			
			file.renameTo(new File( Util.upload() + fsn ));
			vo.setOfn(ofn);
			vo.setFsn(fsn);
		}
		
		msgDao.add( vo );
		return "redirect:list.link?roomNo="+ vo.getRoomNo();
	}
	
	@RequestMapping("/add222.link")
	public String add222(@ModelAttribute MsgVO vo, HttpServletRequest request) throws Exception {
		
		MultipartRequest mpr = new MultipartRequest(request, Util.upload(), 1024*1024*16, null, null);
		
		String content = mpr.getParameter("content");
		
		String roomNo = mpr.getParameter("roomNo");
		vo.setRoomNo(roomNo);
		vo.setUsername("banana");
		vo.setShowip(Util.getRemoteAddr(request));
		vo.setContent(content);
		String ofn = mpr.getOriginalFileName("apple");
		
		if( (content == null || content.equals("")) && (ofn == null || ofn.equals("")) ) {
			return "redirect:list.link?ecode=invalid_content&roomNo="+vo.getRoomNo();
		}
		
		if( ofn == null ) {
			ofn = "null";
		}
		if( ofn != "null" && ofn != null ) {
			File file = mpr.getFile("apple");
			String fsn = UUID.randomUUID().toString();
			if( fsn != null ) {
				file.renameTo(new File( Util.upload() + fsn ));
			}
			vo.setOfn(ofn);
			vo.setFsn(fsn);
		}
		
		msgDao.add( vo );
		return "redirect:list.link?roomNo=" + vo.getRoomNo();
	}
	
	@RequestMapping("/del2.link")
	public String del2(@RequestParam(value="no",required=false) String no, @RequestParam(value="roomNo",required=false) String roomNo) throws Exception {
		
		MsgDAO dao = new MsgDAO_Spring();
		
		MsgVO po = new MsgVO();
		po.setNo(Integer.parseInt(no));
		po.setRoomNo(roomNo);
		dao.findByNo(po);
		dao.delByNo(po);
		
		return "redirect:list.link?roomNo=" + po.getRoomNo();
	}
	
	@RequestMapping("/login.link")
	public String login(HttpSession session) throws Exception {
		if(session.getAttribute("userID") != null) {
			session.removeAttribute("userID");
		}
		return "Msg_login";
	}
	
	@RequestMapping("/login2.link")
	public String login2( @RequestParam(value="userID",required=false) String userID, @RequestParam(value="userPassword",required=false) String userPassword, HttpSession session ) throws Exception {
		session.setAttribute("userPassword", userPassword);
		if( userID.equals("test") && userPassword.equals("1111") ) {
			return "redirect:roomlist.link";
		}
		else if( userID.equals("test") && userPassword.equals("2222") ) {
			return "redirect:roomlist.link";
		}
		else if( userID.equals("test") && userPassword.equals("3333") ) {
			return "redirect:roomlist.link";
		}
		else {
			return "redirect:roomlist.link";
		}	
	}
	
	@RequestMapping("/down.link")
	public void down( @RequestParam("fsn") String fsn, @RequestParam("ofn") String ofn, HttpServletResponse response ) throws Exception {
		if( fsn == null ) {
			fsn = "";
		}
		InputStream in = new FileInputStream( Util.upload() + fsn );
		
		ofn = new String(ofn.getBytes("utf-8"), "iso-8859-1");
		
		response.setContentType("application/octet");
		response.setHeader("content-disposition", "attachment;filename=" + ofn);
		
		OutputStream out = response.getOutputStream();
		int len = 0;
		byte[] buf = new byte[1024];
		
		while( (len = in.read(buf)) != -1 ) {
			out.write(buf, 0, len);
			out.flush();
		}
		out.close();
		in.close();
	}
}
