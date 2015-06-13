package kr.ac.mju.VEntity;

import kr.ac.mju.Entity;

public class SugangShow extends Entity{
	private String gangjwaID;
	private String name;
	private String time;
	private int hackjum;
	public String getGangjwaID() {return gangjwaID;}
	public void setGangjwaID(String gangjwaID) {this.gangjwaID = gangjwaID;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getTime() {return time;}
	public void setTime(String time) {this.time = time;}
	public int getHackjum() {return hackjum;}
	public void setHackjum(int hackjum) {this.hackjum = hackjum;}
}
