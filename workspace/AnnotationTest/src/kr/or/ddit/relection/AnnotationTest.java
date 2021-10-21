package kr.or.ddit.relection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Provider.Service;

import kr.or.ddit.relection.PrintAnnotation.printAnnotation;

public class AnnotationTest {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println(printAnnotation.id);
		
		//reflection 기능을 이용한 메서드 실행하기
		// 선언된 메서드 목록 가져오기
		Method[] declareMethods = Service.class.getDeclaredMethods();
		
		for(Method m : declareMethods) {
			System.out.println(m.getName());
			
			PrintAnnotation printAnno = m.getDeclaredAnnotation(PrintAnnotation.class);
			
			for(int i = 0; i<printAnno.count(); i++) {
				System.out.println(printAnno.value());
			}
			System.out.println(); //줄바꿈
			// m.invoke(new Service());		//invoke :  호출. 실행
			Class<Service> clazz = Service.class;
			
			Service service ;
			try {
				service = (Service) clazz.newInstance(); // 객체생성
				m.invoke(service);
			}catch (InstantiationException e) {
				e.printStackTrace();
			}
		}
	}
	
}
