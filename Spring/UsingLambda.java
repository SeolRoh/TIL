package lambda;

public class UsingLambda {
	public static void main(String[] args) {
		// Thread ����
		// 1. �������� ���
		Thread t1 = new Thread(new MyRunnable());
		t1.setName("�Ѹ�");
		t1.start();

		// 2. Thread Ŭ���� ����
		// annonymous Inner Class =�͸�Ŭ���� , ���� �̸��� ���� Ŭ����=>�θ��̸����
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		});
		t2.setName("�浿");
		t2.start();
		
		// 2. Lambda �� ���·� Thread Ŭ���� ����
		// run method���� �����Ѱ��� ȭ��ǥ������ �����ش�. ����.
		Thread t3 = new Thread( () -> System.out.println(Thread.currentThread().getName()));
		t3.setName("�ڹ�");
		t3.start();
	}
}

//memory ���鿡�� ���� �ʴ�. ��ȸ���̶� �Ź� ������ �Ѵ�.
class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}