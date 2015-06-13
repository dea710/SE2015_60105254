package kr.ac.mju.DAO;
/*
CREATE TABLE `projectsogong`.`gangjwa`(
`gangjwaid` VARCHAR(45) NOT NULL,
`name` VARCHAR(45),
`time` VARCHAR(45),
`userid` VARCHAR(45),
`inwon` INT(3),
`hackjum` INT(2),
`openyear` INT(4),
`ngrade` INT(2),
PRIMARY KEY (`gangjwaid`)
);

CREATE TABLE `projectsogong`.`sugang`(
`sugangid` INT(11) NOT NULL AUTO_INCREMENT,
`userid` VARCHAR(45) NOT NULL,
`gangjwaid` VARCHAR(45) NOT NULL,
PRIMARY KEY (`sugangid`)
);

CREATE TABLE `projectsogong`.`sungjeck`(
`sungjeckid` INT(11) NOT NULL AUTO_INCREMENT,
`gangjwaid` VARCHAR(45) NOT NULL,
`userid` VARCHAR(45) NOT NULL,
`grade` VARCHAR(45) NOT NULL DEFAULT 'N',
PRIMARY KEY (`sungjeckid`)
);

CREATE TABLE `projectsogong`.`user`(
`userid` VARCHAR(45) NOT NULL,
`password` VARCHAR(45),
`name` VARCHAR(45),
`grade` VARCHAR(45),
PRIMARY KEY (`userid`)
);
 */
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import kr.ac.mju.Entity;
import kr.ac.mju.User;
import kr.ac.mju.VEntity.GangjwaInwon;
import kr.ac.mju.VEntity.GangjwaShow;
import kr.ac.mju.VEntity.SugangShow;
import kr.ac.mju.VEntity.SugangSungjeck;

public class DBDAO implements IDAO{
	private final static String DB = "daesung";
	private final static String URL = "jdbc:mysql://localhost:3306/" + DB;//database이름
	private final static String ID = "PDS";//mysql아이디 = Account
	private final static String PASSWORD = "mju12345";//mysql암호
	private final static String ROOTPASS = "deasql";
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL, ID, PASSWORD);
	}
	private void closeConnection(Connection connection, Statement statement, ResultSet resultSet) throws SQLException{
		if(connection == null){
			return;
		}
		connection.close();
		statement.close();
		resultSet.close();
	}

	@Override
	public void insert(String table, String value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		connection = getConnection();
		String datainSQL = null;
		if(table.equals("user")){
			//userid(10), password(10), name(10), class(10)
			datainSQL = "insert into user(userid, password, name, grade) values('"+ value1 +"','"+ value2 +"','"+ value3 +"','"+ value4 + "');";
		}else if(table.equals("sugang")){
			//sugangid varchar(10) primary key,userid varchar(10)
			datainSQL = "insert into sugang(gangjwaid, userid) values('"+ value1 +"','"+ value2 + "');";
			
			String sungjecknullSQL = "insert into sungjeck(gangjwaid, userid) values('" + value1 + "', '" + value2 + "');";
			statement = connection.prepareStatement(sungjecknullSQL);
			statement.executeUpdate();
			statement.close();
		}else if(table.equals("gangjwa")){
			//gangjwaid varchar(10) primary key,name varchar(10),class varchar(10),time varchar(20),userid varchar(10), inwon int(3)
			datainSQL = "insert into gangjwa(gangjwaid, name, time, userid, inwon, hackjum, openyear, ngrade) values('"+ value1 +"','"+ value2 +"','"+ value3 +"','"+ value4 +"','"+ value5 +"','"+ value6 +"','"+ value7 +"','"+ value8 +"');";
		}else if(table.equals("sungjeck")){
			datainSQL = "insert into sungjeck(gangjwaid, userid, grade) values('" + value1 + "', '" + value2 + "', '" + value3 + "');";
		}
		
		statement = connection.prepareStatement(datainSQL);
		statement.executeUpdate();
		statement.close();
		connection.close();
	}

	@Override
	public Vector<User> select(String table) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "select * from " + table + ";";
		connection = getConnection();
		statement = connection.prepareStatement(sql);//쿼리문을 보낼준비(미리써둔 것을 준비해둠)
		resultSet = statement.executeQuery(sql);
		
		User user = null;
		
		if(table.equals("user")){
			//userid(10), password(10), name(10), grade(10)
			Vector<User> users = new Vector<User>();
			while(resultSet.next()){//여러개의 값이 나올수 있으니 값만큼 반복
				String id = resultSet.getString("userid");
				String password = resultSet.getString("password");
				String name = resultSet.getString("name");
				user = new User();
				user.setID(id);
				user.setName(name);
				user.setPassword(password);
				users.add(user);
			}
			return users;
		}else if(table.equals("sugang")){
			//sugangid varchar(10) primary key,userid varchar(10)
			while(resultSet.next()){//여러개의 값이 나올수 있으니 값만큼 반복
				String id = resultSet.getString("id");
				String password = resultSet.getString("password");
				String name = resultSet.getString("name");
				user = new User();
				user.setID(id);
				user.setName(name);
				user.setPassword(password);
			}
		}else if(table.equals("gangjwa")){
			//gangjwaid varchar(10) primary key,name varchar(10),class varchar(10),time varchar(20),userid varchar(10), inwon int(3)
			while(resultSet.next()){//여러개의 값이 나올수 있으니 값만큼 반복
				String id = resultSet.getString("id");
				String password = resultSet.getString("password");
				String name = resultSet.getString("name");
				user = new User();
				user.setID(id);
				user.setName(name);
				user.setPassword(password);
			}
		}

		closeConnection(connection, statement, resultSet);
		return null;
	}
	@Override
	public Entity selectwhere(String table, String value) throws SQLException {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "select * from " + table + " where ";
		connection = getConnection();
		
		
		//User user = null;
		
		if(table.equals("user")){
			//userid(10), password(10), name(10), grade(10)
			User user = new User();
			String wheresql = user.selectwhere(sql, value);
			statement = connection.prepareStatement(wheresql);//쿼리문을 보낼준비(미리써둔 것을 준비해둠)
			resultSet = statement.executeQuery(wheresql);
			while(resultSet.next()){//여러개의 값이 나올수 있으니 값만큼 반복
				String id = resultSet.getString("userid");
				String password = resultSet.getString("password");
				String name = resultSet.getString("name");
				String grade = resultSet.getString("grade");
				user.setID(id);
				user.setName(name);
				user.setPassword(password);
				user.setGrade(grade);
				return user;
			}
		}

		closeConnection(connection, statement, resultSet);
		return null;
	}
	
	@Override
	public Vector<GangjwaShow> select() throws SQLException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "select gangjwa.gangjwaid, gangjwa.name, user.name, gangjwa.time, gangjwa.inwon, gangjwa.openyear, gangjwa.hackjum, gangjwa.ngrade from " + DB + ".gangjwa, " + DB + ".user where gangjwa.userid = user.userid;";
		connection = getConnection();
		statement = connection.prepareStatement(sql);//쿼리문을 보낼준비(미리써둔 것을 준비해둠)
		resultSet = statement.executeQuery(sql);
		
		GangjwaShow gangjwa;
		Vector<GangjwaShow> gangjwalist = new Vector<GangjwaShow>();
		while(resultSet.next()){//여러개의 값이 나올수 있으니 값만큼 반복
			String gangjwaID = resultSet.getString("gangjwa.gangjwaid");
			String Gname = resultSet.getString("gangjwa.name");
			String Uname = resultSet.getString("user.name");
			String time = resultSet.getString("gangjwa.time");
			int inwon = Integer.parseInt(resultSet.getString("gangjwa.inwon"));
			int openyear = Integer.parseInt(resultSet.getString("gangjwa.openyear"));
			int hackjum = Integer.parseInt(resultSet.getString("gangjwa.hackjum"));
			int ngrade = Integer.parseInt(resultSet.getString("gangjwa.ngrade"));
			gangjwa = new GangjwaShow();
			gangjwa.setGangjwaID(gangjwaID);
			gangjwa.setGangjwaname(Gname);
			gangjwa.setUsername(Uname);
			gangjwa.setTime(time);
			gangjwa.setInwon(inwon);
			gangjwa.setOpenyear(openyear);
			gangjwa.setHackjum(hackjum);
			gangjwa.setNgrade(ngrade);
			gangjwalist.add(gangjwa);
		}

		closeConnection(connection, statement, resultSet);
		return gangjwalist;
	}
	
	@Override
	public Vector<GangjwaShow> selectwhere(String ID) throws SQLException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "select gangjwa.gangjwaid, gangjwa.name, user.name, gangjwa.time, gangjwa.openyear, gangjwa.hackjum, gangjwa.ngrade, gangjwa.inwon from " + DB + ".gangjwa, " + DB + ".user where gangjwa.userid = user.userid and user.userid = '" + ID + "';";
		connection = getConnection();
		statement = connection.prepareStatement(sql);//쿼리문을 보낼준비(미리써둔 것을 준비해둠)
		resultSet = statement.executeQuery(sql);
		
		GangjwaShow gangjwa;
		Vector<GangjwaShow> gangjwalist = new Vector<GangjwaShow>();
		while(resultSet.next()){//여러개의 값이 나올수 있으니 값만큼 반복
			String gangjwaID = resultSet.getString("gangjwa.gangjwaid");
			String Gname = resultSet.getString("gangjwa.name");
			String Uname = resultSet.getString("user.name");
			String time = resultSet.getString("gangjwa.time");
			int inwon = Integer.parseInt(resultSet.getString("gangjwa.inwon"));
			int openyear = Integer.parseInt(resultSet.getString("gangjwa.openyear"));
			int hackjum = Integer.parseInt(resultSet.getString("gangjwa.hackjum"));
			int ngrade = Integer.parseInt(resultSet.getString("gangjwa.ngrade"));
			gangjwa = new GangjwaShow();
			gangjwa.setGangjwaID(gangjwaID);
			gangjwa.setGangjwaname(Gname);
			gangjwa.setUsername(Uname);
			gangjwa.setTime(time);
			gangjwa.setInwon(inwon);
			gangjwa.setOpenyear(openyear);
			gangjwa.setHackjum(hackjum);
			gangjwa.setNgrade(ngrade);
			gangjwalist.add(gangjwa);
		}

		closeConnection(connection, statement, resultSet);
		return gangjwalist;
	}
	
	@Override
	public Vector<SugangShow> selectSuwhere(String ID) throws SQLException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "select sugang.gangjwaid, gangjwa.NAME, gangjwa.hackjum, gangjwa.time from " + DB + ".sugang, " + DB + ".user, " + DB + ".gangjwa where sugang.userid = user.userid and gangjwa.gangjwaid = sugang.gangjwaid and user.userid = '" + ID + "';";
		connection = getConnection();
		statement = connection.prepareStatement(sql);//쿼리문을 보낼준비(미리써둔 것을 준비해둠)
		resultSet = statement.executeQuery(sql);
		
		SugangShow sugang;
		Vector<SugangShow> suganglist = new Vector<SugangShow>();
		while(resultSet.next()){//여러개의 값이 나올수 있으니 값만큼 반복
			String gangjwaID = resultSet.getString("sugang.gangjwaid");
			String Gname = resultSet.getString("gangjwa.NAME");
			String time = resultSet.getString("gangjwa.time");
			int hackjum = Integer.parseInt(resultSet.getString("gangjwa.hackjum"));
			sugang = new SugangShow();
			sugang.setGangjwaID(gangjwaID);
			sugang.setName(Gname);
			sugang.setHackjum(hackjum);
			sugang.setTime(time);
			suganglist.add(sugang);
		}

		closeConnection(connection, statement, resultSet);
		return suganglist;
	}
	
	@Override
	public Vector<GangjwaInwon> selectInwhere(String gangjwaID) throws SQLException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "select h.name, sungjeck.userid, grade from " + DB + ".sungjeck, (select name, sugang.userid from " + DB + ".sugang, " + DB + ".user where sugang.userid = user.userid and gangjwaid = '" + gangjwaID + "') h where sungjeck.userid = h.userid;";
		connection = getConnection();
		statement = connection.prepareStatement(sql);//쿼리문을 보낼준비(미리써둔 것을 준비해둠)
		resultSet = statement.executeQuery(sql);
		
		GangjwaInwon inwon;
		Vector<GangjwaInwon> inwonlist = new Vector<GangjwaInwon>();
		int num = 0;
		while(resultSet.next()){//여러개의 값이 나올수 있으니 값만큼 반복
			num++;
			String name = resultSet.getString("h.name");
			String id = resultSet.getString("sungjeck.userid");
			String grade = resultSet.getString("grade");
			inwon = new GangjwaInwon();
			inwon.setName(name);
			inwon.setUserID(id);
			inwon.setNum(num);
			if(grade.equals("N")){
				inwon.setGrade("미입력 상태");
			}else{
				inwon.setGrade(grade);
			}
			inwonlist.add(inwon);
		}

		closeConnection(connection, statement, resultSet);
		return inwonlist;
	}
	
	@Override
	public Vector<SugangSungjeck> selectsungjeck(String userID) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "select gangjwa.name, gangjwa.gangjwaid, sugangs.grade from " + DB + ".gangjwa, (SELECT sungjeck.gangjwaid, sungjeck.grade, sungjeck.userid FROM " + DB + ".sungjeck, " + DB + ".sugang where sungjeck.userid = sugang.userid and sungjeck.gangjwaid = sugang.gangjwaid) sugangs where sugangs.gangjwaid = gangjwa.gangjwaid and sugangs.userid = '" + userID + "';";
		connection = getConnection();
		statement = connection.prepareStatement(sql);//쿼리문을 보낼준비(미리써둔 것을 준비해둠)
		resultSet = statement.executeQuery(sql);
		
		SugangSungjeck sungjeck;
		Vector<SugangSungjeck> sungjecklist = new Vector<SugangSungjeck>();
		while(resultSet.next()){//여러개의 값이 나올수 있으니 값만큼 반복
			//gangjwa.name, gangjwa.gangjwaid, sugangs.grade
			String gangjwaName = resultSet.getString("gangjwa.name");
			String gangjwaID = resultSet.getString("gangjwa.gangjwaid");
			String grade = resultSet.getString("sugangs.grade");
			sungjeck = new SugangSungjeck();
			sungjeck.setGangjwaID(gangjwaID);
			sungjeck.setGangjwaName(gangjwaName);
			if(grade.equals("N")){
				sungjeck.setGrade("교수님께서 아직 입력하지 않았습니다.");
			}else{
				sungjeck.setGrade(grade);
			}
			sungjecklist.add(sungjeck);
		}

		closeConnection(connection, statement, resultSet);
		return sungjecklist;
	}
	
	@Override
	public void updateSungjeck(String gangjwaID, String userID, String grade) throws SQLException{
		Connection connection = null;
		PreparedStatement statement = null;
		connection = getConnection();
		String updateSQL = "update " + DB + ".sungjeck set grade = '" + grade + "' where gangjwaid = '" + gangjwaID + "' and userid = '" + userID + "';";
		statement = connection.prepareStatement(updateSQL);
		statement.executeUpdate();
		statement.close();
		connection.close();
	}

	@Override
	public Entity read(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void write(Entity entity, String filename) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void connect(String name) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
	}
	
	public void createAccount() throws SQLException{
		Connection connection = null; //연결소켓
		PreparedStatement statement = null; //명령어 소켓 -> sql문
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306","root",ROOTPASS);//관리자 계정 위치, 관리자 아이디, 암호
		String accountSQL = "grant all privileges on *.* to " + ID + "@localhost identified by '" + PASSWORD + "' with grant option";//db에 날릴 쿼리부분 권한부여 부분이다.
		statement = connection.prepareStatement(accountSQL);//  준비단계
		statement.executeUpdate();//select문이 아니면 Update문이다.(ResultSet이 필요가 없는 부분) // 실행단계
		statement.close();
		connection.close();
	}
	
	public void createDatabase() throws SQLException{
		Connection connection = null;
		PreparedStatement statement = null;
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306",ID,PASSWORD);
		String dbSQL = "create database " + DB;
		statement = connection.prepareStatement(dbSQL);
		statement.executeUpdate();
		statement.close();
		connection.close();
	}
	public void createTable() throws SQLException{
		Connection connection = null;
		PreparedStatement statement = null;
		connection = getConnection();
		String tableSQL = "CREATE TABLE gangjwa(gangjwaid VARCHAR(45) NOT NULL PRIMARY KEY, name VARCHAR(45), time VARCHAR(45), userid VARCHAR(45), inwon INT(3), hackjum INT(2), openyear INT(4), ngrade INT(2) );";
		statement = connection.prepareStatement(tableSQL);
		statement.executeUpdate();
		tableSQL = "CREATE TABLE sugang(sugangid INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, userid VARCHAR(45) NOT NULL, gangjwaid VARCHAR(45) NOT NULL);";
		statement = connection.prepareStatement(tableSQL);
		statement.executeUpdate();
		tableSQL = "CREATE TABLE sungjeck(sungjeckid INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, gangjwaid VARCHAR(45) NOT NULL, userid VARCHAR(45) NOT NULL, grade VARCHAR(45) NOT NULL DEFAULT 'N' );";
		statement = connection.prepareStatement(tableSQL);
		statement.executeUpdate();
		tableSQL = "CREATE TABLE user(userid VARCHAR(45) NOT NULL PRIMARY KEY, password VARCHAR(45), name VARCHAR(45), grade VARCHAR(45) );";
		statement = connection.prepareStatement(tableSQL);
		statement.executeUpdate();
		statement.close();
		connection.close();
	}

}
