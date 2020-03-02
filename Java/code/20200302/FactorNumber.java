import java.util.Scanner;

public class FactorNumber {
    public static void main(String[] args){
//        int num = 0;
//            Scanner in = new Scanner(System.in);
//            System.out.println("숫자를 입력하시오");
//            num = in.nextInt();
//
//            for(int i = 1; i<=num; i++){
//                if( (num / i) * i == num ){
//                    System.out.println(i + " ");
//                }
//        }

        Integer obj = Integer.valueOf(100);
        System.out.println(obj + " value1");
        int num = obj.intValue();
        int num2 = 100;
        System.out.println(num + " value2");
        if (obj.equals(num)){
            System.out.println("같습니다.");
        }

    }
}