package kr.ac.mju.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import kr.ac.mju.User;
import kr.ac.mju.DAO.DBDAO;
import kr.ac.mju.VEntity.LoginInfo;
import kr.ac.mju.VEntity.UserInfo;

import org.springframework.stereotype.Service;

@Service//autowired로 한것을 받아주기위한것.
public class LoginService {

	public UserInfo login(String userID, String userPassword) {
		// dao 호출.
		UserInfo user = new UserInfo();
		user.setID(userID);
		user.setName("name");
		
		return user;
	}
	
	public LoginInfo loginin(String userID, String password){
		LoginInfo logininfo = new LoginInfo();
		logininfo.setID(userID);
		logininfo.setPassword(password);
		return logininfo;
	}

	public User logindb(String userID) throws ClassNotFoundException, SQLException {
		DBDAO db = new DBDAO();
		User user = new User();
		user = (User)db.selectwhere("user", userID);
		return user;
	}


}
