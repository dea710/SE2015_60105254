package kr.ac.mju.DAO;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Vector;

import kr.ac.mju.Entity;
import kr.ac.mju.User;
import kr.ac.mju.VEntity.GangjwaInwon;
import kr.ac.mju.VEntity.GangjwaShow;
import kr.ac.mju.VEntity.SugangShow;
import kr.ac.mju.VEntity.SugangSungjeck;

public interface IDAO {
	public void connect(String name) throws FileNotFoundException;
	public void disconnect();
	public Entity read(Entity entity);
	public void write(Entity entity, String filename);
	public boolean hasNext();
	public Vector<User> select(String table) throws SQLException;
	public Entity selectwhere(String table, String value) throws SQLException;
	public Vector<GangjwaShow> select() throws SQLException;
	public Vector<GangjwaShow> selectwhere(String ID) throws SQLException;
	public Vector<SugangShow> selectSuwhere(String ID) throws SQLException;
	public Vector<GangjwaInwon> selectInwhere(String gangjwaID) throws SQLException;
	public Vector<SugangSungjeck> selectsungjeck(String userID) throws SQLException ;
	public void insert(String table, String value1, String value2, String value3,
			String value4, String value5, String value6, String value7,
			String value8) throws SQLException;
	public void updateSungjeck(String gangjwaID, String userID, String grade)
			throws SQLException;
}
