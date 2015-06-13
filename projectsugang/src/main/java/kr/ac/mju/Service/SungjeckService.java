package kr.ac.mju.Service;

import java.sql.SQLException;
import java.util.Vector;

import kr.ac.mju.DAO.DBDAO;
import kr.ac.mju.VEntity.SugangSungjeck;
import kr.ac.mju.VEntity.Sungjeckinput;

import org.springframework.stereotype.Service;

@Service//autowired로 한것을 받아주기위한것.
public class SungjeckService {

	public void input(Sungjeckinput sungjeckinput) throws SQLException {
		DBDAO dao = new DBDAO();
		dao.updateSungjeck(sungjeckinput.getGangjwaID(), sungjeckinput.getUserID(), sungjeckinput.getGrade());
		
	}

	public Sungjeckinput doo(String userID, String gangjwaID, String grade) {
		Sungjeckinput sungjeckinput = new Sungjeckinput();
		sungjeckinput.setGangjwaID(gangjwaID);
		sungjeckinput.setGrade(grade);
		sungjeckinput.setUserID(userID);
		return sungjeckinput;
	}

	public Vector<SugangSungjeck> sungjecklist(String userID) throws SQLException {
		DBDAO db = new DBDAO();
		Vector<SugangSungjeck> sungjecklist = new Vector<SugangSungjeck>();
		sungjecklist = db.selectsungjeck(userID);
		return sungjecklist;
	}
	

	/*
	public Vector<GangjwaShow> Ggangjwalist(String userID) throws SQLException {
		DBDAO db = new DBDAO();
		Vector<GangjwaShow> gangjwalist = new Vector<GangjwaShow>();
		
		gangjwalist = db.selectwhere(userID);
		
		return gangjwalist;
	}
	*/

}
