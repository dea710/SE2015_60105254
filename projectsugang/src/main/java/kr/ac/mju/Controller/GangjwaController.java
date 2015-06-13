package kr.ac.mju.Controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.Gangjwa;
import kr.ac.mju.Service.GangjwaService;
import kr.ac.mju.VEntity.GangjwaInwon;
import kr.ac.mju.VEntity.GangjwaShow;
import kr.ac.mju.VEntity.UserInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GangjwaController {
	private static final Logger logger = LoggerFactory.getLogger(GangjwaController.class);
	@Autowired//변수만 선언하면 자동으로 객체 생성함.
	private GangjwaService service;
	@RequestMapping(value = "/GangjwaController/Gangjwa.do", method = RequestMethod.POST)//get인지 post인지.
	public String login(HttpServletRequest request) throws UnsupportedEncodingException, ClassNotFoundException, SQLException{//web서버로 throws함.
		request.setCharacterEncoding("utf-8");
		UserInfo userinfo = new UserInfo();
		userinfo.setID(request.getParameter("userID"));
		Gangjwa gangjwa = new Gangjwa();
		gangjwa = service.gangjwa(request.getParameter("gangjwaID"), request.getParameter("name"), request.getParameter("time"), request.getParameter("userID"), Integer.parseInt(request.getParameter("inwon")), Integer.parseInt(request.getParameter("hackjum")), Integer.parseInt(request.getParameter("openyear")), Integer.parseInt(request.getParameter("ngrade")));
		//service생성 즉 control생성
		service.gangjwagaeseol(gangjwa);
		request.getSession().setAttribute("result", "강좌개설성공");
		//console에 뜨는 방법
		return "result";
	}
	
	@RequestMapping(value = "/GangjwaController/Gangjwa.go", method = RequestMethod.POST)//get인지 post인지.
	public String join(HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		String userID = request.getParameter("userID");
		request.getSession().setAttribute("ID", userID);
		
		return "gangjwa";
	}
	
	@RequestMapping(value = "/GangjwaController/Gangjwa.show", method = RequestMethod.POST)//get인지 post인지.
	public String show(HttpServletRequest request) throws UnsupportedEncodingException, SQLException{
		request.setCharacterEncoding("utf-8");
		String userID = request.getParameter("userID");
		Vector<GangjwaShow> gangjwalist;
		gangjwalist = service.Ggangjwalist(userID);//교수님의 강좌를 꺼내옴.
		request.getSession().setAttribute("list", gangjwalist);
		request.getSession().setAttribute("ID", userID);
		
		return "gangjwashow";
	}
	
	@RequestMapping(value = "/GangjwaController/Gangjwa.inwon", method = RequestMethod.POST)//get인지 post인지.
	public String inwonshow(HttpServletRequest request) throws UnsupportedEncodingException, SQLException{
		request.setCharacterEncoding("utf-8");
		String gangjwaID = request.getParameter("gangjwaID");
		Vector<GangjwaInwon> inwonlist;
		inwonlist = service.inwonlist(gangjwaID);
		request.getSession().setAttribute("list", inwonlist);
		request.getSession().setAttribute("gangjwaID", gangjwaID);
		return "sungjeckGshow";
	}
	
	
}
