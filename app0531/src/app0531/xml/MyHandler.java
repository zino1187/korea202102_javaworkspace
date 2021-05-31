package app0531.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//파싱 대상이 되는 XML문서의 모든 노드를 만날때마다, 개발자가 이벤트를 통해 정보를 
//전달해주는 핸들러 객체 정의, 개발자는 핸들러가 발생시키는 이벤트에 따라 원하는 파싱 관련 작업을
//진행할 수 있다..
public class MyHandler extends DefaultHandler{
	//파싱을 진행하는 실행부가 지금 어느 태그를 지나치는지를 알수있는 표시 용도의 논리값을 선언 
	boolean isMembers;
	boolean isMember;
	boolean isName;
	boolean isAge;
	boolean isAddr;
	
	//각 노드를 만날때마다 호출되는 메서드를 재정의해보자!!!
	public void startDocument() throws SAXException {
		System.out.println("문서의 시작입니다");
	}

	//시작태그 노드를 만날때 호출되는 메서드
	public void startElement(String uri, String name, String tag, Attributes attributes) throws SAXException {
		System.out.print("<"+tag+">");
		
		
	}
	
	//시작태그와 닫는 태그 사이의 텍스트 노드!!
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data = new String(ch, start, length);
		System.out.print(data);
	}

	public void endElement(String uri, String localName, String tag) throws SAXException {
		System.out.print("</"+tag+">");
	}
	
	public void endDocument() throws SAXException {
		System.out.println("문서의 끝입니다");
	}
}







