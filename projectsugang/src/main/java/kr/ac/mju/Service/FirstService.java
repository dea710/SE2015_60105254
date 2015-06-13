package kr.ac.mju.Service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import kr.ac.mju.DAO.DBDAO;

@Service
public class FirstService {
	public void createDB() throws SQLException{
		DBDAO db = new DBDAO();
		db.createAccount();
		db.createDatabase();
		db.createTable();
	}
}
