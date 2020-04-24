package lambda;

import java.util.HashSet;
import java.util.Set;

import jdbc.user.vo.MyDate;

public class MyDateHashCodeTest {
	public static void main(String[] args) {
		MyDate date1 = new MyDate(2020,4,24);
		System.out.println(date1);
		//Hashcode value print
		System.out.println(date1.hashCode());//697960108
		//MyDate.java에 해쉬코드 Override 추가후 결과 //2040
		
		MyDate date2 = new MyDate(2020,4,24);
		System.out.println(date2);
		System.out.println(date2.hashCode());//943010986
		//MyDate.java에 해쉬코드 Override 추가후 결과 //2040
		
		MyDate date3 = new MyDate(2020,4,25);
		System.out.println(date3);
		System.out.println(date3.hashCode());//1807837413
		//MyDate.java에 해쉬코드 Override 추가후 결과 //2041
		
		//주소비교
		System.out.println(date1 == date2); 
		//false
		System.out.println(date1.equals(date2));
		//Equals 메서드 override전 false //후 true
				
		//hashset - *중복을 허용하지 않음*중요 
		//그런대도 set.forEach시 중복되는 date1과date2가 출력이되었다.
		//원인은 해쉬코드 Override 하지 않았기 때문.
		Set<MyDate> set = new HashSet<MyDate>();
		set.add(date1);
		set.add(date2);
		set.add(date3);
		
		set.forEach(date -> System.out.println(date));
		//MyDate.java에 해쉬코드 Override 추가전 결과 
				//MyDate [year=2020, month=4, day=24]
				//MyDate [year=2020, month=4, day=24]
				//MyDate [year=2020, month=4, day=25]
		//MyDate.java에 해쉬코드 Override 추가후 결과 
				//MyDate [year=2020, month=4, day=24]
				//MyDate [year=2020, month=4, day=25]
		
		String str1 = "hello";
		String str2 = new String("hello");
		
		System.out.println(str1 == str2);//false
		System.out.println(str1.equals(str2));//true
	}

}
