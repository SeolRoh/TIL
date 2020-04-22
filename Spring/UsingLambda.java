package lambda;

public class UsingLambda {
	public static void main(String[] args) {
		// Thread 생성
		// 1. 고전적인 방법
		Thread t1 = new Thread(new MyRunnable());
		t1.setName("둘리");
		t1.start();

		// 2. Thread 클래스 생성
		// annonymous Inner Class =익명클래스 , 본인 이름이 없는 클래스=>부모이름사용
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		});
		t2.setName("길동");
		t2.start();
		
		// 2. Lambda 식 형태로 Thread 클래스 생성
		// run method에서 구현한것을 화살표쪽으로 보내준다. 간단.
		Thread t3 = new Thread( () -> System.out.println(Thread.currentThread().getName()));
		t3.setName("자바");
		t3.start();
	}
}

//memory 측면에서 좋지 않다. 일회성이라 매번 만들어야 한다.
class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}