package kr.ac.mju.VEntity;

import kr.ac.mju.Entity;

public class GangjwaInwon extends Entity {
	//번호, 학생이름, 학생 아이디
	private int num;
	private String name;
	private String userID;
	private int score;
	private String grade;
	
	public int getNum() {return num;}
	public void setNum(int num) {this.num = num;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getUserID() {return userID;}
	public void setUserID(String userID) {this.userID = userID;}
	public int getScore() {return score;}
	public void setScore(int score) {this.score = score;}
	public String getGrade() {return grade;}
	public void setGrade(String grade) {this.grade = grade;}
	
}
