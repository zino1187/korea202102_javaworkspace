package app0528.json.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

//다루고자 하는 데이터를 스트링으로 코드내에 두려고 하지말고, 외부의 파일로 존재시켜서, 그 파일을 프로그램으로 읽을수만 있다면
//스트링을 일일이 변수에 담지 않고도 데이터를 처리할 수 있다..
public class JsonBasic3 {
	FileReader reader; //파일을 대상으로 한 문자기반 스트림
	BufferedReader buffr;
	
	public JsonBasic3() {
		try {
			buffr = new BufferedReader( reader= new FileReader(""));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new JsonBasic3();
	}

}
