package app0517.stream.character;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*문자기반 스트림을 학습하면서, 동시에 보다 효율적으로 데이터를 처리하는 법에 대해 알아보자! */
public class FileReadApp {
	FileReader reader;
	File file;
	String path="D:\\workspace\\korea202102_javaworkspace\\app0517\\res\\자바13일차.txt";
	
	public FileReadApp() {
		try {
			reader = new FileReader(file = new File(path)); //파일을 대상으로 빨대를 꽂음!!
			int data=-1;
			while(true) {
				data=reader.read(); // read a byte가 아니라 read single character(문자)
				if(data==-1)break; //파일의 끝을 만나면 -1 반환하므로, 반복문 멈추기!!
				System.out.print((char)data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void main(String[] args) {
		new FileReadApp();
	}
}
