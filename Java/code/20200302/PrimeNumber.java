import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        for(int i = 2; i <= input ; i++){
            if ( i == 2){
                System.out.print(i + " ");
                continue;
            }
            for (int j = 2; j <= i ; j++){
                if(i % j == 0) {
                    if(i != j){
                        break;
                    }
                    else if (i == j) {
                        System.out.print(j + " ");
                    }
                }
            }
        }

    }
}
