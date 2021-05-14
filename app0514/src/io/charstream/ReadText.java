package io.charstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadText {
	FileInputStream fis;
	
	public ReadText() {
		try {
			fis = new FileInputStream("D:\\workspace\\korea202102_javaworkspace\\app0514\\res\\diary.txt");
			int data=-1;
			
			data = fis.read(); //T
			System.out.print((char)data);
			data = fis.read(); //o
			System.out.print((char)data);
			data = fis.read(); //d
			System.out.print((char)data);
			data = fis.read(); //a
			System.out.print((char)data);
			data = fis.read(); //y
			System.out.print((char)data);
			
			data = fis.read(); //은 ???? 제대로 나오나????
			System.out.print((char)data);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new ReadText();
	}
}
