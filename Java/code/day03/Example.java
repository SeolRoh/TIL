package day02;
import java.lang.*;

public class Example {
    public static void main(String[] args) {
        String hello = "Hello";
        String world = "world";
        String name = "Hello";
        String newName = new String("Hello");

        System.out.println(name + "/" + name.length());
        System.out.println(newName + "/" + newName.length());
        System.out.println(hello == name);
        System.out.println(name == newName);
        System.out.println(name.equals(newName)); // 내용이 같은가 비교하는 메소드

        name =  null;
        System.out.println(name);
        System.out.println(name.length());
    }
}
