import java.util.Scanner;
public class Fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //점화식 방법 사용
        int input = in.nextInt();
        int x1= 1; int x2 = 1; int sum = 0;
        for(int i = 0; i < input; i++){
            if(i == 0 || i == 1){
                System.out.print("1 ");
            }else{
                sum = x1 + x2;
                x1 = x2;
                x2 = sum;
                System.out.print(sum+ " ");
            }
        }

    }
}
