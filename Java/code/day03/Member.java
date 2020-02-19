package day02;

public class Member {
    //nested class //중첩클래스, 클래스안에 또다른 클래스를 data처럼사용할 수 있도록 한것
//    class VipMember{
//
//    }
//    //field
//    int age =10;
//    String name = "Java";
//    //methods
//    void 메소드이름1(){
//
//    }
//    int 메소드이름2(){
//        return 1;
//    }
    //(optional)constructor method
    //단한번만 실행되고 객체가 만들어진 시점에서 생성된다.
    //만들어지는 시점은 new Member()사용했을 때.

    String name;
    int age;

    //OverLoading ->같은 클래스에서
    //              메소드 이름은 같고, 파라미터의 타입이나 개수가 다름


    Member(String name){
        this.name= name;
    }

    Member(int age){
        this.age= age;
    }

    Member(String name, int age){
        this.name= name;
        this.age = age;
    }

    void displayInfo(){
        System.out.println(
                String.format("이름은 %s이고 나이는 %s 입니다.", name,age )
        );
    }
}
