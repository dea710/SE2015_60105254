package kr.ac.mju.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

import kr.ac.mju.Entity;
import kr.ac.mju.User;
import kr.ac.mju.VEntity.GangjwaInwon;
import kr.ac.mju.VEntity.GangjwaShow;
import kr.ac.mju.VEntity.SugangShow;
import kr.ac.mju.VEntity.SugangSungjeck;

public class DAO implements IDAO{
	private Scanner scanner;
	public DAO(){}
	public Entity read(Entity entity){
		entity.read(scanner);
		return entity;
	}
	public void write(Entity entity, String filename){
		entity.write(filename);
	}
	@Override
	public void connect(String name){
		try {
			this.scanner = new Scanner (new File(name));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void disconnect() {
		this.scanner.close();
	}
	@Override
	public boolean hasNext() {
		return this.scanner.hasNext();
	}
	@Override
	public Vector<User> select(String table) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void insert(String table, String value1, String value2,
			String value3, String value4, String value5, String value6)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Entity selectwhere(String table, String value) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Vector<GangjwaShow> select() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Vector<GangjwaShow> selectwhere(String ID) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Vector<SugangShow> selectSuwhere(String ID) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Vector<GangjwaInwon> selectInwhere(String gangjwaID)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateSungjeck(String gangjwaID, String userID, int score,
			String grade) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Vector<SugangSungjeck> selectsungjeck(String userID) {
		// TODO Auto-generated method stub
		return null;
	}
}
