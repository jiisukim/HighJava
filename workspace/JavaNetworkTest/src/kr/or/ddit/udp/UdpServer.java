package kr.or.ddit.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UdpServer {
	private DatagramSocket socket;
	
	//프로그램 시작
	public void start() throws IOException {

		//포트 8888번을 사용하는 소켓을 생성힌다
		socket = new DatagramSocket(8888);
		DatagramPacket inPacket, outPacket;
		
		byte[] inMsg = new byte[1]; 	//패킷을 수신하기 위한 바이트 배열
		byte[] outMsg; 					//패킷 송신을 위한 바이트 배열
		
		while(true) {
			//데이터를 수신하기 위한 패킷을 생성한다.
			inPacket = new DatagramPacket(inMsg, inMsg.length);
			
			System.out.println("패킷 수신 대기중 ...");
			
			//패킷을 통해 데이터를 수신 한다.
			socket.receive(inPacket);
			
			System.out.println("패킷 수신 완료.");
			
			//수신한 패킷으로 부터 client의 IP주소와 port번호를 얻는다
			InetAddress address = inPacket.getAddress();
			int port = inPacket.getPort();
			
			// 서버의 현재 시간을 시분초 형태로 반환한다.
			SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
			String time = sdf.format(new Date());
			outMsg = time.getBytes(); //시간 문자열을 byte 배열로 반환
			
			//패킷을 생성해서  client에게 전송한다.
			outPacket = new DatagramPacket(outMsg, outMsg.length,address,port);
			socket.send(outPacket); //전송시작
		}
	}
	public static void main(String[] args) throws IOException {
		new UdpServer().start();
	}
	
}
