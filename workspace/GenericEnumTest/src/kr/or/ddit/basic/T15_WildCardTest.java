package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T15_WildCardTest {
/*
 *	와일드 카드 선언방법 (? <--이 표시가 와일드카드)
 *
 *	<? extends T> : 와일드카드의 상한 제한. T와 그 자손들만 가능
 *	<? super T>	  : 와일드카드의 하한 제한. T와 그 조상들만 가능
 *	<?>			  : 모든 타입 가능 <? extends Object>와 동일 
 */
	
	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox();	//과일상자
		FruitBox<Apple> appleBox = new FruitBox();	//사과상자
		FruitBox<? extends Fruit>fruitBox2 = new FruitBox<Fruit>();
		
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
//		appleBox.add(new Grape());
		Juicer.makeJuice(fruitBox);
		Juicer.makeJuice(appleBox);
	}
	
}
class Juicer{
//	static <T extends Fruit>void makeJuice(FruitBox<T> box) {
	static void makeJuice(FruitBox<? extends Fruit> box) {
		String fruitListStr = ""; //과일목록
		
		int cnt = 0;
		for(Fruit f : box.getFruitList()) {
			if(cnt ==0) {
				fruitListStr += f;
			}else {
				fruitListStr += "," + f;
			}
			cnt++;
		}
		System.out.println(fruitListStr + "=> 쥬스 완성!");
		
	}
}
class Fruit{
	private String name; // 과일이름
	public Fruit(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "과일("+ name + ")";
	}
}

class Apple extends Fruit{
	public Apple() {
		super("사과");
	}
}

class Grape extends Fruit{
	public Grape() {
		super("포도");
	}	
}

//과일상자
class FruitBox<T>{
	private List<T> fruitList;
	public FruitBox() {
		fruitList = new ArrayList<T>();
	}
	public List<T> getFruitList() {
		return fruitList;
	}
	public void setFruitList(List<T> fruitList) {
		this.fruitList = fruitList;
	}
	public void add(T fruit) {
		fruitList.add(fruit);
	}
	
}