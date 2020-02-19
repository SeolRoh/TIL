package day02;

public class Demo3 {
    public static void main(String[] args) {
//        int [][] scores = new int[2][3];
        int[][] scores = new int [2][];
        scores[0] = new int[2];
        scores[1] = new int[4];
        // 잘보면 배열 데이타안에 배열이 들어감을 알 수 있다.
        //여기서 다형성이라고 다양 뭐 .. 된다.

        scores[0][0] = 100;
        scores[0][1] = 200;
//        scores[0][2] = 300;

        scores[1][0] = 400;
        scores[1][1] = 500;
        scores[1][2] = 600;
        scores[1][3] = 700;

        for(int i=0; i<scores.length;i++){
            for(int j=0; j<scores[i].length;j++){
                System.out.print("["+i+"]["+j+"]="+ scores[i][j]+"\t");
            }
            System.out.println();
        }
//        System.out.println(scores.length);

        for ( int[] row : scores) { // row -> [][] or [][][][][]
            for (int value : row){
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
