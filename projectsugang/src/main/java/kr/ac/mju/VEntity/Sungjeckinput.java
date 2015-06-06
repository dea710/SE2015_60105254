package kr.ac.mju.VEntity;

import kr.ac.mju.Entity;

public class Sungjeckinput extends Entity {
	private String gangjwaID;
	private String userID;
	private int score;
	private String grade;
	
	public String getGangjwaID() {return gangjwaID;}
	public void setGangjwaID(String gangjwaID) {this.gangjwaID = gangjwaID;}
	public String getUserID() {return userID;}
	public void setUserID(String userID) {this.userID = userID;}
	public int getScore() {return score;}
	public void setScore(int score) {this.score = score;}
	public String getGrade() {return grade;}
	public void setGrade(String grade) {this.grade = grade;}
	
}
