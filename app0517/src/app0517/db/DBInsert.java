package app0517.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Mysql DB에 레코드 넣어보기!!
//자바언어로 데이터베이스를 연동하는 기술을 가리켜 JDBC라 하며
//java.sql 패키지에서 대부분의 api를 제공해준다..
public class DBInsert {

	public static void main(String[] args) {
		//모든~~DB작업 수행은 절차가 동일하다 
		//1) DB접속 
		String url="jdbc:mysql://localhost:3306/javase";
		String user="root";
		String pass="1234";
		
		try {
			//아래의 코드에서 처럼, DriverManager에 의해 접속이 성공된 경우에만, 
			//접속 정보를 가진 Connection 객체가 반환된다..따라서 접속에 실패한 경우는?
			//Connection 객체가 반환되지 않으므로, null로 초기화된다..
			Connection con=DriverManager.getConnection(url, user, pass);
			if(con ==null) {
				System.out.println("접속실패");
			}else {
				System.out.println("접속성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//2) 쿼리 수행 
		//3) 접속끊기
		

	}

}
