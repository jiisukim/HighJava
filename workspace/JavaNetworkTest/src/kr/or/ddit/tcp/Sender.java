package kr.or.ddit.tcp;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 소켓을 통해서 메시지를 보내는 역할을 담당 
 * @author PC-18
 *
 */
public class Sender extends Thread{
	private Scanner scan;
	private String name;
	private DataOutputStream dos;
	
	public Sender(Socket socket) {
		name ="[" + socket.getInetAddress() + " : " + socket.getLocalPort() + "]";
		scan = new Scanner(System.in);
		
		try {
			dos = new DataOutputStream(socket.getOutputStream());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		while(dos != null) {
			try {
				dos.writeUTF(name + " >>> " + scan.nextLine());
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
