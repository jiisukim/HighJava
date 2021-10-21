package kr.or.ddit.basic;

class Util2{
	public static <T extends Number> int compare(T t1,T t2) {  // T타입은 NUMBER를 extends한 타입(Number의 자식)만 가능하다 + Number자체
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		return Double.compare(v1, v2);
	}
}


/** 
 * 제한된 타입 파라미터(Bounded Parameter)
 * @author PC-18
 *
 */
public class T14_GenericMethodTest {
	public static void main(String[] args) {
	int result1 = Util2.compare(10, 20);
	System.out.println(result1);
	
	int result2 = Util2.<Number>compare(3.14,3);
	System.out.println(result2);
	
//	Util.compare("자바", "홍길동");
	}
}
