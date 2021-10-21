package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
public class FileCopy {
    
    public static void main(String[] args) {
        //원본 파일경로
        String FilePath = "d:/D_Other/Tulips.jpg";
        //복사될 파일경로
        String copyFilePath = "d:/D_Other/복사본_Tulips.jpg";
        
        //파일객체생성
        File oriFile = new File(FilePath);
        //복사파일객체생성
        File copyFile = new File(copyFilePath);
        
        try {
            
            FileInputStream fis = new FileInputStream(oriFile); //읽을파일
            FileOutputStream fos = new FileOutputStream(copyFile); //복사할파일
            
            int fileByte = 0; 
            // fis.read()가 -1 이면 파일을 다 읽은것
            while((fileByte = fis.read()) != -1) {
                fos.write(fileByte);
            }
            //자원사용종료
            fis.close();
            fos.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 