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
		//MyDate.java�� �ؽ��ڵ� Override �߰��� ��� //2040
		
		MyDate date2 = new MyDate(2020,4,24);
		System.out.println(date2);
		System.out.println(date2.hashCode());//943010986
		//MyDate.java�� �ؽ��ڵ� Override �߰��� ��� //2040
		
		MyDate date3 = new MyDate(2020,4,25);
		System.out.println(date3);
		System.out.println(date3.hashCode());//1807837413
		//MyDate.java�� �ؽ��ڵ� Override �߰��� ��� //2041
		
		//�ּҺ�
		System.out.println(date1 == date2); 
		//false
		System.out.println(date1.equals(date2));
		//Equals �޼��� override�� false //�� true
				
		//hashset - *�ߺ��� ������� ����*�߿� 
		//�׷��뵵 set.forEach�� �ߺ��Ǵ� date1��date2�� ����̵Ǿ���.
		//������ �ؽ��ڵ� Override ���� �ʾұ� ����.
		Set<MyDate> set = new HashSet<MyDate>();
		set.add(date1);
		set.add(date2);
		set.add(date3);
		
		set.forEach(date -> System.out.println(date));
		//MyDate.java�� �ؽ��ڵ� Override �߰��� ��� 
				//MyDate [year=2020, month=4, day=24]
				//MyDate [year=2020, month=4, day=24]
				//MyDate [year=2020, month=4, day=25]
		//MyDate.java�� �ؽ��ڵ� Override �߰��� ��� 
				//MyDate [year=2020, month=4, day=24]
				//MyDate [year=2020, month=4, day=25]
		
		String str1 = "hello";
		String str2 = new String("hello");
		
		System.out.println(str1 == str2);//false
		System.out.println(str1.equals(str2));//true
	}

}
