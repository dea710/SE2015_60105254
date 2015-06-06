package kr.ac.mju.Controller;

import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.Sugang;
import kr.ac.mju.Service.SugangService;
import kr.ac.mju.VEntity.GangjwaShow;
import kr.ac.mju.VEntity.SugangShow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SugangController {
	private static final Logger logger = LoggerFactory.getLogger(SugangController.class);
	@Autowired//변수만 선언하면 자동으로 객체 생성함.
	private SugangService service;
	
	@RequestMapping(value = "/SugangController/Sugang.go", method = RequestMethod.POST)//get인지 post인지.
	public String join(HttpServletRequest request) throws ClassNotFoundException, SQLException{
		
		Vector<GangjwaShow> gangjwalist;
		String userID = request.getParameter("userID");
		gangjwalist = service.gangjwalist(userID);
		
		request.getSession().setAttribute("list", gangjwalist);
		request.getSession().setAttribute("userID", userID);
		
		return "sugang";//home으로 가는 방법 즉 home의 매핑 value를 redirect로 해서 준다.
	}
	
	@RequestMapping(value = "/SugangController/Sugang.do", method = RequestMethod.POST)//get인지 post인지.
	public String sugangsincheong(HttpServletRequest request) throws ClassNotFoundException, SQLException{
		
		Sugang sugang = new Sugang();
		String userID = request.getParameter("userID");
		String gangjwaID = request.getParameter("gangjwaID");
		sugang = service.sugangset(gangjwaID, userID);
		//gangjwalist = service.gangjwalist(userID);
		service.sugangsincheong(sugang);
		
		//request.getSession().setAttribute("list", gangjwalist);
		
		request.getSession().setAttribute("result", "수강신청성공");
		return "result";//home으로 가는 방법 즉 home의 매핑 value를 redirect로 해서 준다.
	}
	
	@RequestMapping(value = "/SugangController/Sugang.show", method = RequestMethod.POST)//get인지 post인지.
	public String show(HttpServletRequest request) throws ClassNotFoundException, SQLException{
		String userID = request.getParameter("userID");
		Vector<SugangShow> suganglist;
		suganglist = service.Suganglist(userID);
		request.getSession().setAttribute("list", suganglist);
		request.getSession().setAttribute("ID", userID);
		
		return "sugangshow";
	}
}
