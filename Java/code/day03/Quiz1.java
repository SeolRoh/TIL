package day02;

import java.util.Arrays;

public class Quiz1 {
    public static void main(String[] args) {
        //1.성적처리
        // -5명 사용자(국어,영어, 수학)
        // -String[] names = {"이도원", "홍길동", ...}
        // int[] kors = {100, 90, ...}
        // int[] engs = {100, 90, ...}
        // int[] mats = {100, 90, ...}
        // -개별 학생의 성적과 평균을 구하고, 성적으로 정렬
        // (총점이 높은 순으로 정렬)

        String[] names = {"이도원", "홍길동", "노설", "제임스", "톰"};
        int[] kors = {100, 90, 80, 70, 60};
        int[] engs = {100, 90, 80, 70, 60};
        int[] mats = {100, 90, 80, 70, 60};
        int[] sum = new int[names.length];
        int[] avg = new int[names.length];

        for (int i=0; i<names.length;i++ ) {
            sum[i] = kors[i] + engs[i] + mats[i];
            avg[i] = sum[i]/names.length;
        }

        Arrays.sort(sum);
        for (int array : sum) {
            System.out.println(array);
        }




    }
}
