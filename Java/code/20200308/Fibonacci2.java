import java.util.Scanner;
// 1 1 2 3 5
public class Fibonacci2 {
    public int Func (int input) {
        int sum;

        if(input == 1 || input == 2){
            System.out.println("input : "+ input+ " / sum = " + 1);
            return 1;
        }
        else if(input > 2) {
            // Func(2) Func(1)
            sum= Func(input - 1) + Func(input - 2);
            System.out.println("input : " + input + " sum = "+ sum );
            return sum;
        }
        return 0;
    }

// F(5) = F(4) + F(3) -> F(3) + F(2) + F(3) -> F(2) + F(1) + F(2) + F(3)
    // F(1) + F(0) + F(1) + F(2) + F(3)
    // F(1) + F(0) + F(1) + F(2) + F(1) + F(0) + F(1) =5
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Fibonacci2 fibo = new Fibonacci2();
        int input = in.nextInt();
        int num = fibo.Func(input );
        System.out.println("result : " + num);
    }
}