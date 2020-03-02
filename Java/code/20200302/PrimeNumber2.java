import java.util.Scanner;

public class PrimeNumber2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        boolean isPrime = true;

        for(int i = 2; i <= input; i++){
            for(int j = 2; j < i ; j++){
                if(i % j == 0) {
                    isPrime = false;
                }
            }
            if(isPrime == false){
                isPrime = true;
            } else // if( isPrime == true)
                System.out.print(i+ " ");
        }
    }
}
