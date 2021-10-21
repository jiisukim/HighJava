package kr.or.ddit.basic;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) throws UnknownHostException {
		//InetAddress 클래스 => ip 주소를 다루기 위한 클래스
		
		// getByName()메서드는 www.naver.com 또는 SEM-PC등과 같은 머신이름이나 IP주소를 파라미터를
		// 이용하여 유효한 InetAddress 객체를 제공한다.
		// IP주소 자체를 넣으면 주소 구성자체의 유효성 정도만 체크함
		
		//naver 사이트의 ip정보 가져오기
		InetAddress naverIp = InetAddress.getByName("www.naver.com");
		System.out.println("Host Name =>" + naverIp.getHostName());
		System.out.println("Host Address => " + naverIp.getHostAddress());
		
		
		// 자기 자신 컴퓨터의 IP정보 보기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터의 HOst Name =>" + localIp.getHostName());
		System.out.println("내 컴퓨터의 Host Address =>" + localIp.getHostAddress());
		System.out.println();
		//ip 주소가 여러개인 호스트의 정보 가져오기
		InetAddress[] naverIps = InetAddress.getAllByName("www.naver.com");
		for(InetAddress nIp : naverIps) {
			System.out.println(nIp.toString());
		}
	}
	
	
}
