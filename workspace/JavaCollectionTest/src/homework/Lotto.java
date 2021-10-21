package homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Lotto {
/*
 *  로또를 구매하는 프로그램 작성하기
 
 사용자는 로또를 구매할 때 구매할 금액을 입력하고
 입력한 금액에 맞게 로또번호를 출력한다.
 (단, 로또 한장의 금액은 1000원이고 거스름돈도 계산하여
      출력한다.)

	==========================
         Lotto 프로그램
	--------------------------
	 1. Lotto 구입
	  2. 프로그램 종료
	==========================		 
	메뉴선택 : 1  <-- 입력
			
	 Lotto 구입 시작
		 
	(1000원에 로또번호 하나입니다.)
	금액 입력 : 2500  <-- 입력
			
	행운의 로또번호는 아래와 같습니다.
	로또번호1 : 2,3,4,5,6,7
	로또번호2 : 20,21,22,23,24,25
			
	받은 금액은 2500원이고 거스름돈은 500원입니다.
			
   	 ==========================
         Lotto 프로그램
	--------------------------
	  1. Lotto 구입
	  2. 프로그램 종료
	==========================		 
	메뉴선택 : 2  <-- 입력
		
	감사합니다
 */
	public static void main(String[] args) {
		Scanner a= new Scanner(System.in);
		while (true) {
			System.out.println("==========================");
			System.out.println("     Lotto 프로그램");
			System.out.println("--------------------------");
			System.out.println(" 1. Lotto 구입\n 2. 프로그램 종료");
			System.out.println("==========================");
			System.out.println("메뉴선택");
			int input = Integer.parseInt(a.nextLine());
			switch (input) {
			case 1: new Lotto().buyLotto();
				break;
			case 2:
				System.out.println("감사합니다.");
				System.exit(0);
			}
		}
		
	}
	public void buyLotto() {
		Scanner a= new Scanner(System.in);
		System.out.println("Lotto 구입시작");
		System.out.println("1000원에 로또 하나입니다.");
		System.out.println("금액 입력");
		int input = Integer.parseInt(a.nextLine());
		int change = input%1000;
		int num = input/1000;
		Set hs1 = new HashSet();
		List<Integer> num1 = new ArrayList<Integer>();
		
		System.out.println("행운의 로또번호는 아래와 같습니다.");
		for (int i = 0; i < num; i++) {
			while (hs1.size() < 6) {
				hs1.add((int) (Math.random() * 45 + 1));
				num1 = new ArrayList<Integer>(hs1);
			}
			System.out.print("로또번호");
			System.out.print((i+1)+" : ");
			for(Integer num2 : num1 ) {
				System.out.print(num2+" ");
			}
			hs1.clear();
			System.out.println();
		}
		System.out.println("받은 금액은 "+input+"원이고 거스름돈은 "+change+"입니다.");
		
		
	}
}

