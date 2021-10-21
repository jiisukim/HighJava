package kr.or.ddit.basic;

/*
 * 3명의 스레드가 각각 알파벳 대문자를 출력하는데 출력을 끝낸 순서대로 결과를 나타내는 프로그램을 작성하기
 * 
 */

public class T11_DisplayCharacterTest {
	static String strRank ="";  //순위저장용 변수
	
	public static void main(String[] args) {
		Thread[] disChars = new DisplayCharacter[] {
				new DisplayCharacter("홍길동"),
				new DisplayCharacter("일지매"),
				new DisplayCharacter("변학도")
		};
		for (Thread th : disChars) {
			th.start();
		}
		for (Thread th : disChars) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("경기 끝...");
		System.out.println("--------------------------");
		System.out.println();
		System.out.println("경기결과");
		System.out.println("순위 : "+strRank);
	}
}


//영어 대문자를 출력하는 스레드 클래스
class DisplayCharacter extends Thread{
	private String name;
	
	//생성자
	public DisplayCharacter(String name) {
		this.name=name;
	}
	@Override
	public void run() {
		for(char ch='A'; ch<='Z';ch++) {
			System.out.println(name + "의 출력문자 : "+ ch);
			
			try {
				//sleep()메서드의 값을 200~500사이의 난수로한다.
				Thread.sleep((int)(Math.random()*301+200));
			}catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
			System.out.println(name+"출력 끝....");
			T11_DisplayCharacterTest.strRank +=name + " ";
		
	}
}
/*
 * 
10마리의 말들이 경주하는 경마 프로그램 작성하기

말은 Horse라는 이름의 클래스로 구성하고,
이 클래스는 말이름(String), 등수(int)를 멤버변수로 갖는다.
그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는
기능이 있다.( Comparable 인터페이스 구현)

경기 구간은 1~50구간으로 되어 있다.

경기 중 중간중간에 각 말들의 위치를 >로 나타내시오.
예)
1번말 --->------------------------------------
2번말 ----->----------------------------------
...

경기가 끝나면 등수를 기준으로 정렬하여 출력한다.



 */