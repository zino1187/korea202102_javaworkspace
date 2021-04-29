package bank;

//계좌를 정의해본다!!
//자바는, 클래스간 서로 사용이 가능하므로 보안상 뜻하지 않았던 문제가 발생
//할수있기 때문에 이를 보완하기 위해 접근제한자로 보안처리를 지원한다.. 
//자바의 보안 처리는 다음과 같이 총 4단계로 구성된다..
/* 
	(공개)        상속관계 or 같은패키지       같은 패키지만      나의 멤버만 접근가능
	public          < protected       <      default         < private 

*/
public class Account{
	String bankName="기업은행";
	String master="배트맨";
	private int balance=5000; //멤버 메서드만 이 변수를 접근할 수 있다..
	String num="084-45678-01";

	//데이터에 대한 직접 접근을 막았으나, 선의의 사용자도 사용하지 못하게 되었으므
	//로, 선의의 사용자가 접근할 수 있는 어떤 장치를 마련해주자!!!
	public void setBalance(int balance){
		this.balance=balance;
	}

	//값을 반환받아 갈 수 있는 메서드 정의 (return 이 있는 메서드) 
	public int getBalance(){
		return balance;
	}
}