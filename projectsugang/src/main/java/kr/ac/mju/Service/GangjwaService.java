package kr.ac.mju.Service;

import java.sql.SQLException;
import java.util.Vector;

import kr.ac.mju.Gangjwa;
import kr.ac.mju.DAO.DBDAO;
import kr.ac.mju.VEntity.GangjwaInwon;
import kr.ac.mju.VEntity.GangjwaShow;
import kr.ac.mju.VEntity.UserInfo;

import org.springframework.stereotype.Service;

@Service//autowired로 한것을 받아주기위한것.
public class GangjwaService {
	
	public UserInfo userinf(String userID, String username){
		UserInfo userinfo = new UserInfo();
		userinfo.setID(userID);
		userinfo.setName(username);
		return userinfo;
	}
	public Gangjwa gangjwa(String gangjwaID,String name, String classs, String time, String userID, int inwon){
		Gangjwa gangjwa = new Gangjwa();
		gangjwa.setGangjwaID(gangjwaID);
		gangjwa.setName(name);
		gangjwa.setClasss(classs);
		gangjwa.setTime(time);
		gangjwa.setUserID(userID);
		gangjwa.setInwon(inwon);
		return gangjwa;
	}

	public void gangjwagaeseol(Gangjwa gangjwa) throws SQLException{
		DBDAO db = new DBDAO();
		String inwon = Integer.toString(gangjwa.getInwon());
		db.insert("gangjwa", gangjwa.getGangjwaID(), gangjwa.getName(), gangjwa.getClasss(), gangjwa.getTime(), gangjwa.getUserID(), inwon);
	}
	

	
	public Vector<GangjwaShow> Ggangjwalist(String userID) throws SQLException {
		DBDAO db = new DBDAO();
		Vector<GangjwaShow> gangjwalist = new Vector<GangjwaShow>();
		
		gangjwalist = db.selectwhere(userID);
		
		return gangjwalist;
	}
	
	public Vector<GangjwaInwon> inwonlist(String gangjwaID) throws SQLException{
		DBDAO db = new DBDAO();
		Vector<GangjwaInwon> inwonlist = new Vector<GangjwaInwon>();
		inwonlist = db.selectInwhere(gangjwaID);
		
		return inwonlist;
	}

}
