import java.util.Scanner;
public class PrimeNumber3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        int lineNumber = 1;
        int count = 0;
        for(int i = 2; i< input ; i++){
            boolean isPrime = true;
            for (int j = 2 ; j < i ; j++){
                if( i % j == 0 ){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime == true){
                System.out.print(i + " ");
                count++;
            }

            if (lineNumber == count) {
                System.out.println();
                count = 0;
                lineNumber++;
            }

        }
    }
}
