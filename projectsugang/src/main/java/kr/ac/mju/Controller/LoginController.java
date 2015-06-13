package kr.ac.mju.Controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.User;
import kr.ac.mju.Service.LoginService;
import kr.ac.mju.VEntity.LoginInfo;
import kr.ac.mju.VEntity.UserInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired//변수만 선언하면 자동으로 객체 생성함.
	private LoginService service;
	@RequestMapping(value = "/LoginController/login.do", method = RequestMethod.POST)//get인지 post인지.
	public String login(HttpServletRequest request) throws UnsupportedEncodingException, ClassNotFoundException, SQLException{//web서버로 throws함.
		request.setCharacterEncoding("utf-8");
		LoginInfo logininfo = new LoginInfo();
		logininfo.setID(request.getParameter("userID"));
		logininfo.setPassword(request.getParameter("userPassword"));
		
		//String userID = request.getParameter("userID"); //class name = 함수이름 의 형태이다.
		//String userPassword = request.getParameter("userPassword");//jsp랑 같아야한다.
		
		//service생성 즉 control생성
		UserInfo userinfo = service.login(logininfo.getID(), logininfo.getPassword());
		LoginInfo mainlog = service.loginin(logininfo.getID(), logininfo.getPassword());
		//console에 뜨는 방법
		
		User user = service.logindb(logininfo.getID());
		if(user != null){//아이디가 있다면
			if(user.getPassword().equals(logininfo.getPassword())){//암호가맞다면
				if(user.getGrade().equals("h")){//학생이면
					request.getSession().setAttribute("userSession", user);
					request.getSession().setAttribute("result", user.getName());
					return "loginH";
				}else if(user.getGrade().equals("g")){//교수이면
					request.getSession().setAttribute("userSession", user);
					request.getSession().setAttribute("result", user.getName());
					return "loginG";
				}else{
					request.getSession().setAttribute("userSession", user);
					request.getSession().setAttribute("result", user.getName());
					return "loginA";
				}
			}
			logger.info("로그인 실패: password missmatch");
			return "redirect:/";
		}

		logger.info("로그인 실패: id missmatch");
		
		/*
		DAO dao = new DAO();
		LoginInfo logincheck = new LoginInfo();
		//중복체크
		User check = new User();
		dao.connect("userData.txt");
		while(dao.hasNext()){
			check = (User) dao.read(check);
			
			logger.info("read(check) : " + check.getID() + check.getPassword() + check.getName() + check.getGrade());
			
			logincheck.setID(check.getID());
			logincheck.setPassword(check.getPassword());
			logincheck.setGrade(check.getGrade());
			
			//logger.info("userinfo : " + userinfo.getID() + userinfo.getName());
			//logger.info("logininfo : " + logininfo.getID() + logininfo.getPassword() + logininfo.getGrade());
			logger.info("logincheck : " + logincheck.getID() + logincheck.getPassword() + logincheck.getGrade());
			logger.info("검사 (mainlog ID = check ID): " + mainlog.getID() + " = " + check.getID() + " : " + (userinfo.getID()==check.getID()));
			logger.info("검사 (mainlog ID.equles(check ID)): " + mainlog.getID() + " = " + check.getID() + " : " + (logincheck.getID().equals(check.getID())));
			logger.info("검사 (mainlog ID길이 check ID길이): " + mainlog.getID().length() + " = " + check.getID().length());
			if(mainlog.getID() == check.getID()){
				if(mainlog.getPassword() == check.getPassword()){
					logger.info("로그인성공(check) : " + check.getID() + check.getPassword() + check.getName() + check.getGrade());
					
					logger.info("로그인성공(logincheck) : " + logincheck.getID() + logincheck.getPassword() + logincheck.getGrade());
					
					dao.disconnect();
					if(logincheck.getGrade().equals("학생")){
						logger.info("로그인성공(학생) : " + check.getID() + check.getPassword() + check.getName() + check.getGrade());
						request.getSession().setAttribute("userSession", check);
						return "loginG";
					}else if(logincheck.getGrade().equals("교수")){
						logger.info("로그인성공(교수) : " + check.getID() + check.getPassword() + check.getName() + check.getGrade());
						request.getSession().setAttribute("userSession", check);
						return "loginH";
					}else{
						return "redirect:/";
					}
				}else{logger.info("비밀번호 오류 : " + logininfo.getID() + " : " + logincheck.getID());
					dao.disconnect();
					return "redirect:/";
				}
			}else{logger.info("아이디 오류 : " + logininfo.getPassword() + " : " + logincheck.getPassword());
				dao.disconnect();
				//return "redirect:/";//home의 mapping value를 redirect:에 넣는다.
				return "redirect:/";
			}
		}
		
		dao.disconnect();
		*/
		//logger.info("로그인 오류 : " + logininfo.getPassword() + " : " + logincheck.getPassword());
		//return "redirect:/";
		return "redirect:/";
	}
	
	@RequestMapping(value = "/LoginController/logout", method = RequestMethod.GET)//get인지 post인지.
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute("userSession");//login할때 섯던 key값을 넘겨줌
		return "redirect:/";//home으로 가는 방법 즉 home의 매핑 value를 redirect로 해서 준다.
	}
}
