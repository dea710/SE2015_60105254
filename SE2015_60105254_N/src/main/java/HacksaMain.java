import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HacksaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Professor professor = new Professor("choi");
		//Lecture lecture1 = new Lecture("소프트웨어 공학");
		
		ApplicationContext factory = new ClassPathXmlApplicationContext(new String[]{
				"applicationContext.xml"
				}
		);
		
		//class를 Xml에서 가져왔다. 즉 외부프로그램과 연결된셈이다.
		//각각의 class와 소스코드를 연결하지않고 프로그래밍 하는것이다. 포터블하다. class와 class사이의 연결을 끊는다.
		Professor professor = (Professor)factory.getBean("professor");
		Lecture lecture2 = (Lecture)factory.getBean("lecture2");
		//student를 만든다.
		//lecture2.addStudent(111); 이런식으로 만들어라 
		
		professor.addLecutre(lecture2);
		professor.showLecture();
		
		

	}

}
