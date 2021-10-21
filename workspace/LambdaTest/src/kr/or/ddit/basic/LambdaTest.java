package kr.or.ddit.basic;

@FunctionalInterface
public interface LambdaTest{
	 public void test();
	  
}
//추상메서드가 한개뿐인 인터페이스 -- 함수적 인터페이스
@FunctionalInterface
interface LambdaTestInterface2{
	//반환 값이 없고 매개변수가 있는 추상메서드 선언
	public void test(int a);
}
interface LambdaTestInterface3{
	public int test(int a, int b);
}