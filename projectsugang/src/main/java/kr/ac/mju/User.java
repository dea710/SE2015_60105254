package kr.ac.mju;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;

public class User extends Entity implements Serializable{
	private String ID;
	private String password;
	private String name;
	private String grade;
	
	public String getID() {return ID;}
	public void setID(String iD) {ID = iD;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public String getGrade() {return grade;}
	public void setGrade(String grade) {this.grade = grade;}
	
	public void write(String filename){
		try {
			/*
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(filename),"UTF-8");
			out.write(this.getID() + " " + this.getPassword() + " " + this.getName() + " " + this.getGrade());
			out.close();
			*/
			
			File f = new File(filename);
			FileWriter fw;
			fw = new FileWriter(f,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println(this.getID() + " " + this.getPassword() + " " + this.getName() + " " + this.getGrade());
			bw.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void read(Scanner scanner){
		ID = scanner.next();
		password = scanner.next();
		name = scanner.next();
		grade = scanner.next();
	};
	public String selectwhere(String sql, String value){
		String wheresql = sql + "userid = '" + value + "';";
		
		return wheresql;
	};
}
