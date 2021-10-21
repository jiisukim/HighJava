package homework;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


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
public class HorseRacing {

	static int Rank=1;
	public static void main(String[] args) {
			List<Horse> name = new ArrayList<>();
				name.add(new Horse("1번마"));
				name.add(new Horse("2번마"));
				name.add(new Horse("3번마"));
				name.add(new Horse("4번마"));
				name.add(new Horse("5번마"));
				name.add(new Horse("6번마"));
				name.add(new Horse("7번마"));
				name.add(new Horse("8번마"));
				name.add(new Horse("9번마"));
				name.add(new Horse("10번마"));
			
				for(Horse game: name) {
					game.start();
				}
				for (Horse hs : name) {
					try {
						hs.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				Collections.sort(name);
				System.out.println("경기끝 ....");
				System.out.println("======================================================");
				System.out.println();
				System.out.println(" 경기 결과 ");

				for (Horse horse : name) {
					System.out.println(horse.getHorseName() + " " + horse.getRank() + "등");
				}

	}

}


class Horse extends Thread implements Comparable<Horse>{
	String horseName;
	int rank;
	
	public String getHorseName() {
		return horseName;
	}

	public Horse(String horseName) {
		super();
		this.horseName = horseName;
	}

	

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public int compareTo(Horse hor) {
		if(getRank() > hor.getRank()) {
			return 1;
		}else {
			return -1;
		}
		
	}
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println("\n" + horseName + " : ");
			List<String> loc = new ArrayList<>();
			int temp = i;
			for (int j = 0; j < 50; j++) {
				if (j == temp) {
					loc.add(">");
				}else {
					loc.add("-");
				}
				System.out.print(loc.get(j));
			}

			System.out.println();
			System.out.println();

			try {
				Thread.sleep((int) (Math.random() * 300 +200));
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}

		}
		System.out.println(horseName + " 끝");

		setRank(HorseRacing.Rank);
		HorseRacing.Rank++;
	}
	
}