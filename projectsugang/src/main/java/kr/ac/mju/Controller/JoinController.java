package kr.ac.mju.Controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.User;
import kr.ac.mju.DAO.DBDAO;
import kr.ac.mju.Service.JoinService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class JoinController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired//변수만 선언하면 자동으로 객체 생성함.
	private JoinService service;

	@RequestMapping(value = "/JoinController/join", method = RequestMethod.GET)//get인지 post인지.
	public String join(HttpServletRequest request){
		return "./join";//home으로 가는 방법 즉 home의 매핑 value를 redirect로 해서 준다.
	}
	
	@RequestMapping(value = "/JoinController/join.do", method = RequestMethod.POST)//get인지 post인지.
	public String joindo(HttpServletRequest request) throws UnsupportedEncodingException, SQLException{
		request.setCharacterEncoding("utf-8");
		User user = service.user(request.getParameter("userID"), request.getParameter("Password"), request.getParameter("name"), request.getParameter("grade"));
		/*
		DAO dao = new DAO();
		request.getSession().setAttribute("result", "가입성공");
		dao.write(user, "userData.txt");
		*/
		DBDAO dao = new DBDAO();
		dao.insert("user", user.getID(), user.getPassword(), user.getName(), user.getGrade(), null, null);
		request.getSession().setAttribute("result", "가입성공");
		return "result";//home으로 가는 방법 즉 home의 매핑 value를 redirect로 해서 준다.
	}
	
	@RequestMapping(value = "/JoinController/login", method = RequestMethod.GET)//get인지 post인지.
	public String login(HttpServletRequest request){
		return "redirect:/";//home으로 가는 방법 즉 home의 매핑 value를 redirect로 해서 준다.
	}
}
