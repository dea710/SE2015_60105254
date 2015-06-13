package kr.ac.mju.VEntity;

import kr.ac.mju.Entity;

public class GangjwaShow extends Entity{
	private String gangjwaID;
	private String gangjwaname;
	private String username;
	private String time;
	private int inwon;
	private int openyear;
	private int hackjum;
	private int ngrade;
	
	public String getGangjwaID() {return gangjwaID;}
	public void setGangjwaID(String gangjwaID) {this.gangjwaID = gangjwaID;}
	public String getGangjwaname() {return gangjwaname;}
	public void setGangjwaname(String gangjwaname) {this.gangjwaname = gangjwaname;}
	public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;}
	public String getTime() {return time;}
	public void setTime(String time) {this.time = time;}
	public int getInwon() {return inwon;}
	public void setInwon(int inwon) {this.inwon = inwon;}
	public int getOpenyear() {return openyear;}
	public void setOpenyear(int openyear) {this.openyear = openyear;}
	public int getHackjum() {return hackjum;}
	public void setHackjum(int hackjum) {this.hackjum = hackjum;}
	public int getNgrade() {return ngrade;}
	public void setNgrade(int ngrade) {this.ngrade = ngrade;}

}
