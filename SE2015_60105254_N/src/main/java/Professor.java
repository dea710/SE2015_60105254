
public class Professor {
	private String name;
	private Lecture lecture;
	
	public Professor(){
		
	}
	public Professor(String name){
		this.name = name;
	}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public void addLecutre(Lecture lecture) {
		// TODO Auto-generated method stub
		this.lecture = lecture;
	}
	public void showLecture() {
		// TODO Auto-generated method stub
		System.out.println(lecture.getName());
		
	}
	
}
