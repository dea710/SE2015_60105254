package kr.ac.mju.Controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.Service.FirstService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class FirstController {
	private static final Logger logger = LoggerFactory.getLogger(FirstController.class);
	@Autowired//변수만 선언하면 자동으로 객체 생성함.
	private FirstService service;

	@RequestMapping(value = "/FirstController/first", method = RequestMethod.GET)
	public String first() {
		return "first";//web page address
	}
	
	@RequestMapping(value = "/FirstController/createDB", method = RequestMethod.GET)
	public String join(HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		service.createDB();
		request.getSession().setAttribute("result", "필요 데이터베이스 설정 완료");
		return "result";//web page address
	}
}
