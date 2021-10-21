package kr.or.ddit.basic;

import java.util.Arrays;

public class T06_WildCartTest {
	// 모든 과정 수강정보 조회
	public static void listCourseInfo(Course<?> course) {  //Course<?> == Course<? extends Object>같은말임
		System.out.println(course.getName() + " 수강생: "+ Arrays.toString(course.getStudents()));
	}
	public static void listStudentcourseInfo(Course<? extends Student> course) { //수강정보 조회 //student랑 HighStudent올 수 있음  //상한 제한(Student위로 못가게 제한)
		System.out.println(course.getName()+ " 수강생"+Arrays.toString(course.getStudents()));
	}
	public static void listWorkerCourseInfo(Course<? super Worker> course) {	//직장인 과정 수강정보 	//Worker자신 포함 Worker의 부모  // 하한 제한(Worker아래로 못가게 제한)
		System.out.println(course.getName()+ " 수강생"+Arrays.toString(course.getStudents()));
	}
	public static void main(String[] args) {
		Course<Person> personCourse = new Course<>("일반인과정",5);
		personCourse.add(new Person("일반인1"));
		personCourse.add(new Worker("직장인1"));
		personCourse.add(new Student("학생1"));
		personCourse.add(new HighStudent("고등학생1"));
		
		Course<Worker> workerCourse = new Course<>("직장인과정",5);
		workerCourse.add(new Worker("직장인1"));
		
		Course<Student> studentCourse = new Course<>("학생과정",5);
		studentCourse.add(new Student("학생1"));
		studentCourse.add(new HighStudent("고등학생1"));
		
		Course<HighStudent> highStudentCourse = new Course("고등학생",5);
		highStudentCourse.add(new HighStudent("고등학생1"));
		
		listCourseInfo(personCourse);
		listCourseInfo(workerCourse);
		listCourseInfo(studentCourse);
		listCourseInfo(highStudentCourse);
		System.out.println("--------------------------------------------------");
//		listStudentcourseInfo(personCourse);
//		listStudentcourseInfo(workerCourse);
		listStudentcourseInfo(studentCourse);
		listStudentcourseInfo(highStudentCourse);
		System.out.println("--------------------------------------------------");
		listWorkerCourseInfo(personCourse);
		listWorkerCourseInfo(workerCourse);
//		listWorkerCourseInfo(studentCourse);
//		listWorkerCourseInfo(highStudentCourse);
		
	}

}

class Person{
	String name;

	public Person(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "이름"+name;
	}
	
}


class Worker extends Person{
	public Worker(String name) {
		super(name);
	}
	
}

class Student extends Person{
	public Student(String name) {
		super(name);
	}
		
}
class HighStudent extends Student{
	public HighStudent(String name) {
		super(name);
	}
}

class Course<T>{
	private String name; //과정명
	private T[] students; //수강생
	public Course(String name,int capacity) { //capacity : 몇명까지 받을것인가  
		this.name=name;//타입파라미터로 배열 생성시 오브젝트 배열을 생성 후, 타입 파라미터 배열로캐스팅처리 해야함
		
		//제너릭 배열 생성 실패(new 연산자는 생성할 객체의 타입이 정확히 정의되어야 사용가능)
//		students = new T[capacity];
		students=(T[])(new Object[capacity]);
	}
	public String getName() {
		return name;
	}
	public T[] getStudents() {
		return students;
	}
	public void add(T t) {
		for(int i=0; i<students.length; i++) {
			if(students[i]==null) { 	//아직 등록되지 않은 자리인지 확인
				students[i]= t;
				break;
			}
		}
	}
}



