package db.mysql;
class TestApp{
	public static void main(String[] args){
		/*
		1.사용하려는 DB에 맞는 드라이버 로드(클래스 로드)
		    Class.forName("원하는 클래스명")
		2.DB접속 
		3.쿼리문 수행
		4.DB관련 객체 해제
		*/
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 로드 성공!!");
		}catch(ClassNotFoundException e){
			e.printStackTrace(); //개발자가 원인을 분석하기 위한 출력
			System.out.println("드라이버를 찾을 수 없습니다ㅜㅜ");//유저를 위한 친절한 메시지
		}

	}
}
