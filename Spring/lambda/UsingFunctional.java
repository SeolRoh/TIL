package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class UsingFunctional {
	public static void main(String[] args) {
		//Interface Iterable<T>
		List<String> list = new ArrayList<>(); 
		list.add("java");
		list.add("scalar");
		list.add("python");
		
		for(String value : list) {
			System.out.println(value);
		}
		
		list.forEach(new Consumer<String>() {
			@Override
			public void accept(String value) {
				// TODO Auto-generated method stub
				System.out.println(value);
			}
		});
		
		list.forEach(val -> System.out.println(val));
		//void accept(T t)
		//method Reference
		list.forEach(System.out::println);
		
		List<Student> stuList = List.of(new Student(100,"ȫ�浿"),
				new Student(200,"�Ѹ�"),
				new Student(300,"���"));
		
		//1.
		stuList.forEach(new Consumer<Student>() {
			public void accept(Student stu) {
				System.out.print(stu);
			}
		});
		System.out.println();
		System.out.println("----------------------------");
		//2.
		stuList.forEach(stu -> System.out.print(stu));
		System.out.println();
		System.out.println("----------------------------");
		//3.
		stuList.forEach(System.out::print);
		System.out.println();
		System.out.println("----------------------------");
		
		//
		List<Student> stuList2 = List.of(new Student(10,"�ڹ�"),
				new Student(20,"��Ʋ��"),
				new Student(30,"��Į��"));
		
		//List -> Stream ��ȯ
		//�л���ȣ 20���� ū �л� �̸��� List<String> �� ����Ͻÿ�!!
		Stream<Student> stream = stuList2.stream();
		//java.util.stream �ƱԸ�Ʈ�� T�� ������ Boolean
		stuList2.stream() //Stream<Student>
				//boolean		test(T t)
				.filter(stu -> stu.getId() >= 20)
				.forEach(System.out::print);
		System.out.println();
		System.out.println("----------------------------");
		stuList2.stream() //Stream<Student>
		//boolean		test(T t)
		.filter(stu -> stu.getId() >= 20)
		.map(stu -> stu.getName())
		.forEach(System.out::print);
	}
}

class Student{
	private int id;
	private String name;
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}
