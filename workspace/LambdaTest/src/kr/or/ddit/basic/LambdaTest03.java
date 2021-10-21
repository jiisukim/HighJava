//package kr.or.ddit.basic;
//
//public class LambdaTest03 {
//	static int stVar = 9;
//	private String name = "aaa";
//	
//	public void testMethod(final int temp) {
//		final int localVar = 50;
//		int kor = 100;
//	/*
//	 * 람다식 내부에서 사용되는 지역변수는 모드 final 이어야 한다.
//	 * 보통은 final을 붙이지 않으면 컴파일러가 자동으로 붙여준다.
//	 * 단, 지역변수 값을 변경하는 식이 있을 경우 자동으로 final을 붙여주지 않는다.
//	 */
//	temp = 500;
//	localVar = 2000;
//	kor = 400;
//	
//	LamdaTest01 lt = 
//			()->{
//				System.out.println();
//			};
//	}
//	public static void main(String[] args) {
//		new LambdaTest03().testMethod(200);
//		
//
//	}
//
//}
