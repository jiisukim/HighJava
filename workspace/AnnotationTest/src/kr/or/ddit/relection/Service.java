package kr.or.ddit.relection;

public class Service {
	@PrintAnnotation
	public void method1() {
		System.out.println("메서드1에서 출력되었습니다.");
	}
	@PrintAnnotation(value="%") // value는  (value="%") == ("%")로 생략해서 표현가능 // 하지만 (value="#",count=30)같이 다른 타입요소랑 같이 쓸때는 value를 같이 써줘야함
	public void method2() {
		System.out.println("메서드2에서 출력되었습니다.");
	}
	@PrintAnnotation(value="#",count=30)
	public void method3() {
		System.out.println("메서드3에서 출력되었습니다.");
	}
}
