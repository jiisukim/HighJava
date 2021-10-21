package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentsList {
	public static void main(String[] args) {
		/*
		 * 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다.
			  생성자는 학번, 이름, 국어, 영어, 수학 점수만 매개변수로 받아서 처리한다.
			  이 Student객체들은 List에 저장하여 관리한다.
			  
			  List에 저장된 데이터들을 학번의 오름차순으로 정렬하여 출력하는 부분과
			  총점의 역순으로 정렬하는 부분을 프로그램 하시오.
			  (총점이 같으면 학번의 내림차순으로 정렬되도록 한다.)
			  (학번 정렬기준은 Student클래스 자체에서 제공하도록 하고,
			   총점 정렬기준은 외부클래스에서 제공하도록 한다.)
		 */
		List<Students> stuList = new ArrayList<Students>();
		stuList.add(new Students("20151026","김지수",85,65,95));
		stuList.add(new Students("20151022","변학도",80,30,70));
		stuList.add(new Students("20511234","이석호",75,70,90));
		stuList.add(new Students("20152114","이순신",50,60,70));
		for(int i = 0; i<stuList.size(); i++) { 	//랭킹
			for(int j=0; j<stuList.size(); j++) {
				if(i==j) {
					continue;
				}
				if(stuList.get(i).getSum()>stuList.get(j).getSum()) {
					stuList.get(j).rank();
				}
			}
		}
		System.out.println("학번 오름차순 정렬");
		Collections.sort(stuList);
		for(Students stu :stuList ) {
			System.out.println(stu);
		}
		System.out.println("-----------------------------------------------------------------------");

		Collections.sort(stuList,new SortSumDesc());
		System.out.println("총점의 내림차순으로 정렬 후....");
		for(Students mem : stuList) {
			System.out.println(mem);
		}
		System.out.println("-----------------------------------------------------------------------");
		
	}

}

class Students implements Comparable<Students>{
	private String stuNum; //학번
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private int rank=1;
	
	public Students(String stuNum, String name, int kor,int eng, int math) {		//생성자
		super();
		this.stuNum = stuNum;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum= kor+eng+math;
		}
	public void rank() {
		this.rank = this.rank+1;
	}
	public int getSum() {
		return sum;
	}
	public String toString() {
		return "Students [학번=" + stuNum + ", 이름=" + name + ", 국어=" + kor +
				", 영어=" + eng + ", 수학=" + math +", 총점=" + sum + ",등수=" + rank +"]";
	}
	
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	@Override
	public int compareTo(Students stu) {
		return this.getStuNum().compareTo(stu.getStuNum());
	}	
}


class SortSumDesc implements Comparator<Students>{
	@Override
	public int compare(Students stu1, Students stu2) {
		int sort = Integer.compare((stu1.getSum()),stu2.getSum());
		if(sort ==0) {
			return stu1.compareTo(stu2)*-1;
		}else {
			return new Integer(stu1.getSum()).compareTo(stu2.getSum())* -1;
		}
	}
	
}