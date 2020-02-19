package day02;

import java.util.*;

public class Ramdom {
    public static void main(String[] args) {
        // 로또
        // 1~45사이의 6개의 번호를 입력
        // 자동으로 로또 당첨 번호를 6개 생성 (1~45, 중복X)
        // 로또 당첨 번호와 사용자가 입력한 번호를 비교하여,
        // 몇개의 숫자가 일치하는 지 출력

        Scanner in = new Scanner(System.in);
        int [] Array = new int[6];
        double[] value = new double[6];
        int cnt = 0;

        for(int i=0; i<Array.length; i++){
            Array[i] = in.nextInt();
        }

        System.out.print("입력한 값:");

        for (int array: Array) {
            System.out.print(array + "\t");
        }

        System.out.println();

        Random r = new Random();
        int intVal = r.nextInt(45);
        for(int i=0; i<6; i++){
            value[i] = (int)(Math.random()*100)%45 +1 ;
            System.out.print(value[i]);
            System.out.print("\t");
        }

//        Arrays.sort(Array);

        // 같은거 비교
        for(int i=0 ; i<Array.length; i++){
            for(int j =0; j<value.length;j++){
                if (Array[i] == value[j]){
                    cnt+= 1 ;

                }
            }
        }


        System.out.println("\n 일치하는 숫자 개수 : " + cnt);

    }
}
