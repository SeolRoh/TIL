package day02;

public class Demo5 {
    public static void main(String[] args) {
        int             a           =           10;
        Member          mem1        =       new Member("Java",10);
        //위, 인스턴스화 (mem1 => 인스턴스, 객체)
        Member mem2 = new Member("C++",20);
        Member mem3 = new Member("Python");

        mem1.age = 10;
        mem1.name = "Java";
        mem1.displayInfo(); // Java의 나이가 10살입니다.

        mem2.age = 20;
        mem2.name = "C++";
        mem2.displayInfo();

        mem3.displayInfo();
    }
}
