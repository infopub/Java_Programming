package ch10.ex2;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest{
	public static void main(String[] args){

		Map map = new HashMap();
		
		map.put(1, new Integer(100));
		map.put("second","Hello World!!");
		map.put("third",new MyStudent());
		map.put("fourth",null ); //HaspMap은 null을 허용한다.
		
		//Integer i =map.get(1); //에러 발생
		Integer i = (Integer)map.get(1);
		//String str=map.get("second");  //에러발생
		String str=(String)map.get("second");  
		
		System.out.println(i);
		System.out.println(str);
		
		MyStudent st=(MyStudent)map.get("third");
		System.out.println(st); //overriding 된 toString()메소드를 호출한다.
		System.out.println( map.get("third")); //자동으로 형변환을 해준다.
		System.out.println(map.get("fourth"));
	}
}

