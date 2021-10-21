package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class T04_byteArrayIOTest {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9,};
		byte[] outSrc = null;
		//stream ==> 대부분 byte 기반
		byte[] temp = new byte[4];
		
		ByteArrayInputStream bais = new  ByteArrayInputStream(inSrc);
		ByteArrayOutputStream baos = new  ByteArrayOutputStream();
		
		try {
//			available() => 읽어올 수 있는 byte 수 반환
			while(bais.available() > 0) {
//				//temp 배열의 크기만큼 읽어와 temp배열에 저장한다
//				bais.read(temp);
//				//tempp 배열의 내용을 출력한다.
//				baos.write(temp);
				
				//실제 읽어온 byte 수를 반환한다.
				int len = bais.read(temp);
				//temp 배열의 내용중에서 0번재부터 len개수만큼 출력한다.
				baos.write(temp,0,len);
				System.out.println("temp : "+ Arrays.toString(temp));
			}
			System.out.println();
			outSrc = baos.toByteArray();
			System.out.println("inSrc =>"+Arrays.toString(outSrc));
			
			bais.close();
			baos.close();
			
		}catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
		}
		
		
	}
}
