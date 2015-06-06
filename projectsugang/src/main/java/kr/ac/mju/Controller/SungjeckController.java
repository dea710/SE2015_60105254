package kr.ac.mju.Controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.Service.SungjeckService;
import kr.ac.mju.VEntity.SugangSungjeck;
import kr.ac.mju.VEntity.Sungjeckinput;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SungjeckController {
	private static final Logger logger = LoggerFactory.getLogger(SungjeckController.class);
	@Autowired//변수만 선언하면 자동으로 객체 생성함.
	private SungjeckService service;
	
	@RequestMapping(value = "/SungjeckController/Sungjeck.hshow", method = RequestMethod.POST)//get인지 post인지.
	public String show(HttpServletRequest request) throws UnsupportedEncodingException, SQLException{
		request.setCharacterEncoding("utf-8");
		String userID = request.getParameter("userID");
		Vector<SugangSungjeck> sugangsungjeck = new Vector<SugangSungjeck>();
		sugangsungjeck = service.sungjecklist(userID);

		request.getSession().setAttribute("list", sugangsungjeck);
		
		return "sungjeckHshow";
	}
	
	@RequestMapping(value = "/SungjeckController/Sungjeck.input", method = RequestMethod.POST)//get인지 post인지.
	public String input(HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		String userID = request.getParameter("userID");
		String gangjwaID = request.getParameter("gangjwaID");
		String userName = request.getParameter("userName");
		request.getSession().setAttribute("userID", userID);
		request.getSession().setAttribute("gangjwaID", gangjwaID);
		request.getSession().setAttribute("userName", userName);
		return "sungjeckinput";
	}
	
	@RequestMapping(value = "/SungjeckController/Sungjeck.do", method = RequestMethod.POST)//get인지 post인지.
	public String sungjeckDo(HttpServletRequest request) throws UnsupportedEncodingException, SQLException{
		request.setCharacterEncoding("utf-8");
		String userID = request.getParameter("userID");
		String gangjwaID = request.getParameter("gangjwaID");
		int score = Integer.parseInt(request.getParameter("score"));
		String grade = request.getParameter("grade");
		Sungjeckinput sungjeckinput = service.doo(userID, gangjwaID, score, grade);
		service.input(sungjeckinput);
		request.getSession().setAttribute("result", "성적 입력 완료");
		return "result";
	}
}
