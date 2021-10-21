package kr.or.ddit.basic;

import java.util.Scanner;

public class BaseBallGame {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		System.out.println("〓〓〓〓〓〓 숫자게임 〓〓〓〓〓〓");
		
		int num1 = (int)(Math.random()*9 +1);
		int num2 = (int)(Math.random()*9 +1);
		int num3 = (int)(Math.random()*9 +1);
		while(num2 ==num1 || num2 == num3 || num3 == num1){
			num1 = (int)(Math.random()*9 +1);
			num2 =(int)(Math.random()*9 +1);		
		}	
//		System.out.print(num1+ " ");
//		System.out.print(num2+ " ");
//		System.out.print(num3+ " ");
		System.out.println();
		
		int fn=0;
		int sn=0;
		int tn=0;
		int stcount = 0;
		int ballcount = 0;
		int outcount = 0;
	
		do{
		System.out.println("첫번째 숫자를 입력해주세요 : ");
		fn = Integer.parseInt(a.nextLine());
		System.out.println("두번째 숫자를 입력해주세요 : ");
		sn = Integer.parseInt(a.nextLine());
		System.out.println("세번째 숫자를 입력해주세요 : ");
		tn = Integer.parseInt(a.nextLine());
		if(fn >=10){
			System.out.println("=== 9이하의 숫자를 다시 입력해주세요 ===");
			continue;
		}else if(sn >=10){
			System.out.println("=== 9이하의 숫자를 다시 입력해주세요 ===");
			continue;
		}else if(tn >= 10){
			System.out.println("=== 9이하의 숫자를 다시 입력해주세요 ===");
			continue;
		}
		if(fn == num1){
			stcount++;
		}else if(fn == num2 ||fn == num3){
			ballcount++;
		}else{
			outcount++;
		}
		if(sn==num2){
			stcount++;
		}else if(sn == num1 || sn == num3){
			ballcount++;
		}else{
			outcount++;
		}
		if(tn == num3){
			stcount++;
		}else if(tn == num1 ||tn ==num2){
			ballcount++;
		}else{
			outcount++;
		}
		System.out.println("〓〓〓   "+ stcount+"S "+ ballcount + "B "+ outcount+"O 입니다 〓〓〓" );
		stcount = 0;
		ballcount = 0;
		outcount = 0;
		}while(fn !=num1 || sn != num2 || tn != num3 );
		System.out.println("★★★★★ 정답입니다. 축하드립니다 ★★★★");

	}

}
