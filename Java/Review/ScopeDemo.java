public class ScopeDemo {
    static void a() {
        int i =0;
        // static int i = 0;
        // 클래스 변수로 선언하면 무한 반복이 일어난다.
        // 클래스 변수는 모든 메소드에서 접근이 가능하기 때문이다.
    }

    public static void main(String[] args) {
        for(int i =0 ; i<5; i++){
            a();
            System.out.println(i);
        }
    }
}
