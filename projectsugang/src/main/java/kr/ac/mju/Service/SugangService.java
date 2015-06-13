package kr.ac.mju.Service;

import java.sql.SQLException;
import java.util.Vector;

import kr.ac.mju.Sugang;
import kr.ac.mju.User;
import kr.ac.mju.DAO.DBDAO;
import kr.ac.mju.VEntity.GangjwaShow;
import kr.ac.mju.VEntity.SugangShow;

import org.springframework.stereotype.Service;

@Service//autowired로 한것을 받아주기위한것.
public class SugangService {

	public Vector<User> showlist(String userID) throws ClassNotFoundException, SQLException {
		DBDAO db = new DBDAO();
		Vector<User> users = new Vector<User>();
		users = (Vector<User>)db.select("user");
		return users;
	}

	public Vector<GangjwaShow> gangjwalist(String userID) throws SQLException {
		DBDAO db = new DBDAO();
		Vector<GangjwaShow> gangjwalist = new Vector<GangjwaShow>();
		
		gangjwalist = db.select();
		
		return gangjwalist;
	}
	
	public Sugang sugangset(String gangjwaID, String userID){
		Sugang sugang = new Sugang();
		sugang.setUserID(userID);
		sugang.setGangjwaID(gangjwaID);
		return sugang;
	}

	public void sugangsincheong(Sugang sugang) throws SQLException {
		DBDAO db = new DBDAO();
		db.insert("sugang", sugang.getGangjwaID(), sugang.getUserID(), null, null, null, null, null, null);
		
	}
	

	public Vector<SugangShow> Suganglist(String userID) throws SQLException {
		DBDAO db = new DBDAO();
		Vector<SugangShow> suganglist = new Vector<SugangShow>();
		
		suganglist = db.selectSuwhere(userID);
		return suganglist;
	}

}
