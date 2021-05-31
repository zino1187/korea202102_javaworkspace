package app0531.xml;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//파싱 대상이 되는 XML문서의 모든 노드를 만날때마다, 개발자가 이벤트를 통해 정보를 
//전달해주는 핸들러 객체 정의, 개발자는 핸들러가 발생시키는 이벤트에 따라 원하는 파싱 관련 작업을
//진행할 수 있다..
public class MyHandler extends DefaultHandler{
	//각 노드를 만날때마다 호출되는 메서드를 재정의해보자!!!
	public void startDocument() throws SAXException {
		System.out.println("문서의 시작입니다");
	}

	public void endDocument() throws SAXException {
		System.out.println("문서의 끝입니다");
	}
}







