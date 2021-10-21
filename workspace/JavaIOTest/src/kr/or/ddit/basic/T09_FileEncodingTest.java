package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class T09_FileEncodingTest {
	/*
	 * 인코딩 방식
	 * 한글  인코딩 방식은 크게 	UTf8과 EUC-KR 방식 두가지로 나뉜다.
	 * 원래 한글 윈도우는 CP949방식을 사용 했는데, 윈도우를 개발한 마이크로 소프트에서 EUC-KR방식에서 확장 하였기 때문에 MS949라고도 부른다
	 * 한글 windows 메모장에서 이야기하는 ANSI 인코딩이란 , CP949(code Page 949)를 말한다
	 * 
	 * - MS949 => 윈도우의 기본 한글 인코딩 방식
	 * - UTF-8 = > 유니코드 UTF-8인코딩 방식(영문자 및 숫자 : 1byte, 한글 :  3byte) => 가변적
	 * - US-ASCII => 영문 전용 인코딩 방식
	 * 
	 * * 유니코드(Unicode)
	 * 서로다른 문자 인코딩을 사용하는 컴퓨터 간의 문서교환에 어려움을 겪게 되고, 이런 문제점을 해결하기 위해 전 세계의 모든 문자를 하나의 통일된 문자집합(Charset)으로 표현함
	 */
	
	public static void main(String[] args) {
		// 파일 인코딩을 이용하여 읽어오기
		FileInputStream fis = null;
		InputStreamReader isr = null;
		
		try {
			/*
			 * FileInputStream 갹체를 생성한 후 이 객체를 매개변수로 받는 InputStreamReader 객체를 생성한다.
			 * 
			 */
			fis = new FileInputStream("d:/D_Other/test_UTF-8.txt");
			isr = new InputStreamReader(fis, "UTF-8");
			
			int c;
			while((c=isr.read()) != -1) {
				System.out.print((char)c);
			}
			System.out.println();
			System.out.println("출력 끝....");
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				isr.close();	//보조스트림만 닫아도 된다.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
