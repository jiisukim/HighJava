package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T04_ListSortTest {

	public static void main(String[] args) {
		List<Member> memList = new ArrayList<Member>();
		memList.add(new Member(1,"홍길동","010-1111-1111"));
		memList.add(new Member(5,"변학도","010-1111-2222"));
		memList.add(new Member(9,"성춘향","010-1111-3333"));
		memList.add(new Member(3,"이순신","010-1111-4444"));
		memList.add(new Member(6,"강감찬","010-1111-5555"));
		memList.add(new Member(2,"일지매","010-1111-6666"));
		
		System.out.println("정렬전");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("--------------------------------");
		
		Collections.sort(memList); //정렬하기  //comparable 객체 자체에 정렬 기준부여
		System.out.println("이름의 오름차순으로 정렬 후....");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("--------------------------------");
		
		//외부 정렬 기준을 이용한 정렬하기
		Collections.sort(memList,new SortNumDesc());
		System.out.println("번호의 내림차순으로 정렬 후....");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("--------------------------------");
	}

}

class Member implements Comparable<Member>{

	private int num; // 번호
	private String name; // 이름
	private String tel; //전화번호
	

	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	// 이름을 기준으로 오름차순 정렬이 되도록 설정한다.
	@Override
	public int compareTo(Member mem) {
	
		return this.getName().compareTo(mem.getName());
	}	
	
	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

	
}
/**
 * 정렬 기준의 외부선언을 위해서는 comparator 인터페이스를 구현하면 된다.
 * Member의 번호(num)의 내림차순으로 정렬하기
 * @author PC-18
 *
 */
class SortNumDesc implements Comparator<Member>{

	@Override
	public int compare(Member mem1, Member mem2) {
		/*
		if(mem1.getNum() > mem2.getNum()) {
			return -1;
		}else if(mem1.getNum()==mem2.getNum()) {
			return 0;
		}else {
			return 1;
		}
		*/
		
		// Wrapper 클래스에서 제공하는 메서드를 이용하는 방법1
//		return Integer.compare(mem1.getNum(), mem2.getNum()) * -1;
		// Wrapper 클래스에서 제공하는 메서드를 이용하는 방법2
		return new Integer(mem1.getNum()).compareTo(mem2.getNum())* -1;
		
		// 과제 
		// 학번 :String 타입  //학번 : comparable //총점 : comparator
		
	}
	
}