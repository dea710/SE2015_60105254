package kr.ac.mju;

import java.io.Serializable;
import java.util.Scanner;

public class Entity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public void read(Scanner scanner){};
	public void write(String filename){}
	public void insert() {};
	public String selectwhere(String sql, String value){
		return sql;};
}
