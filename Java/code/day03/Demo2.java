package day02;

public class Demo2 {
    public static void main(String[] args) {
//        int[] intArray; // int intArray[];
//        double[] doubleArray; // double doubleArray[];
//        String[] strArray; // String strArray[];
//
//        int[] scores = {1, 2, 3, 4, 5, 6, 7};
//        System.out.println(scores.length);
//
//        System.out.println(scores[0]);
//        System.out.println(scores[6]);
//
//        String[] names = {"A", "BB", "CCC", "DDDD", "EEEEE"};
//        System.out.println(names.length);
//        System.out.println(names[1]);
//        names[4]="JAVA";
//        System.out.println(names[4]);

        String[] names = new String[]{"A", "BB", "CCC", "DDDD", "EEEEE"};

        int[] scores;
        scores = new int[]{1, 2, 3, 4, 5, 6, 7};

        String[] animals = new String[5];

        System.out.println(animals.length);
        animals[4] = "cat";
        animals[3] = "dog";

        for(int i=0; i<animals.length;i++){
            System.out.println(animals[i]);
        }

        for(String a : animals){
            System.out.println(a);
        }

        double[] d = new double[5];
        d[0] = 0.0;
        d[1] = 3.14f;
        d[2] = 100;
        d[3] = 20_200_000_000L;
        d[4] = 'A';

        for(double _d:d){
            System.out.println(_d);
        }
    }
}
