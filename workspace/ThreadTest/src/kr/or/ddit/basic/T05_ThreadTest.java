package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class T05_ThreadTest {
/*
 * 단일 스레드에서 사용자 입력 처리 예제
 */
	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("아무거나 입력하세요");
		System.out.println("입력한 값은 "+ str+" 입니다.");
		
		for(int i=10; i>=1; i--) {
			System.out.println(i);
			
			try {
				Thread.sleep(1000); //1초동안 잠시멈춘다
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
