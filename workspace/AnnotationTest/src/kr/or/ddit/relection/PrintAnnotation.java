package kr.or.ddit.relection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public @interface PrintAnnotation {      //annotation 정의 : @+ anntation이름
	/*
	 * Annotations에 대하여...
	 * 프로그램 소스코드 안에 다른 프로그램을 위한 정보를 미리 약속된 형식으로 포함 시킨것.
	 * 주석처럼 프로그래밍 언어에 영향을 미치지 않으면서도 다른 프로그램에세게 유용한 정보를 제공함
	 * 
	 * 종류 : 1. 표준애너테이션(주로 컴파일러에게 유용한 정보를 제공하기 위한 애너테이션)
	 *		2. 메타 에너테이션(에너테이션을 위한 에너테이션, 즉 애너테이션을 정의할 때 사용하는 애너 테이션)
	 *
	 *애너테이션 타입 정의하기
	 * @interface 애너테이션 이름{
	 * 	요소타입 타입요소 이름(); 		//반환값이  있고 매개변수는 없는 추상메서드의 형태
	 * 	...
	 * }
	 * 
	 * 애너테이션 요소의 규칙
	 * 1. 요소의 타입은 기본형,String,enum, annotation, class만 허용된다.
	 * 2. ()안에 매개변수를 선언한다.
	 * 3. 예외를 선언할 수 없다.
	 * 4. 요소의 타입에 타입 매개변수를 사용할 수 없다.
	 */

 	@Target(ElementType.METHOD)//annotation이 적용가능한 대상을 지정함
 	@Retention(RetentionPolicy.RUNTIME) //유지 기간 정함 (기본 값 : CLASS) //RUNTIME이 가장 오래 살아있음
 	public @interface printAnnotation{
 		int id = 100;	//상수 선언가능  static final int id = 100;
 	}
 	String value() default "-"; //
 	int count() default 20;

}
