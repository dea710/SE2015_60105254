package kr.ac.mju.Service;

import kr.ac.mju.User;

import org.springframework.stereotype.Service;

@Service//autowired로 한것을 받아주기위한것.
public class JoinService {

	public User user(String userID, String password, String name, String grade) {
		// dao 호출.
		User user = new User();
		user.setID(userID);
		user.setPassword(password);
		user.setName(name);
		user.setGrade(grade);
		
		return user;
	}

}
