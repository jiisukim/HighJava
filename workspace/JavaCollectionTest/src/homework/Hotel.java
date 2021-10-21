package homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Hotel {
	Scanner scan = new Scanner(System.in);
	Map<Integer,HotelInfo> guest= new HashMap<Integer,HotelInfo>(); //String은 key의 타입 value는  class의 타입
	public static void main(String[] args) {
		new Hotel().hotelStart();
	}

	public void displayMenu() {
		System.out.println("*******************************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
		System.out.println("*******************************************");
		System.out.println("메뉴선택 : ");
	}
	
	public void hotelStart() {
		 //입력용 스	트림 객체 생성
		try {
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("d:/D_Other/hotel.txt")));
			Object obj = null;
			obj = ois.readObject();
			//읽어온 데이터를 원래의 객체형으로 변환한 후 사용한다.
			guest =(Map<Integer,HotelInfo>) obj;
			
			 ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		while (true) {
			displayMenu();
			int input = scan.nextInt();
			switch (input) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				checkRoom();
				break;
			case 4:
				try {
					ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("d:/D_Other/hotel.txt")));

					// 쓰기 작업
					oos.writeObject(guest);
						
					oos.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("**************************");
				System.out.println("      　　　호텔 문을 닫았습니다.");
				System.out.println("**************************");
				System.exit(0);
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}// switch 끝
		}//while 끝
	}
	
	private void checkRoom() {
		System.out.println("방번호\t투숙객");
		Set<Integer> keySet= guest.keySet();
		if(keySet.size()==0) {
			System.out.println("모든방이 비어있습니다.");
		}else {
			Iterator<Integer> it = keySet.iterator();
			int cnt = 0;
			while(it.hasNext()) {
				cnt++;
				Integer roomNum = it.next();
				HotelInfo h = guest.get(roomNum);
				System.out.println(h.getRoomNum()+"\t"+h.getName());
			}
		}
		
	}

	private void checkOut() {
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.println("방번호 입력 >> ");
		int roomNum = scan.nextInt();
		if(guest.remove(roomNum)==null) {
			System.out.println(roomNum+"방에는 체크인한 사람이 없습니다.");
		}else {
			System.out.println("체크아웃 되었습니다.");
		}
		
	}

	private void checkIn() {
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 >> ");
		int roomNum = scan.nextInt();
		scan.nextLine();
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력>>  ");
		String name = scan.nextLine();
		if(guest.get(roomNum) !=null) {
			System.out.println(roomNum +"번 방은 이미 예약된 방입니다.");
			return; //메서드 종료
		}
		guest.put(roomNum,new HotelInfo(roomNum,name));
		System.out.println(roomNum+"번 방 "+name+"씨 이름으로 체크인되었습니다.");

		
	}
	
}
class HotelInfo implements Serializable{
	private int roomNum;
	private String name;
	
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HotelInfo(int roomNum, String name) {
		super();
		this.roomNum = roomNum;
		this.name = name;
	}
	@Override
	public String toString() {
		return "HotelInfo [roomNum=" + roomNum + ", name=" + name + "]";
	}
	
}

