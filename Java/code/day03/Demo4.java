package day02;

public class Demo4 {
    public static void main(String[] args) {
        String[] strArray = new String[3];
        //stack                     heap
        //      strArray ------>    [0][1][2]
        //                              (0:null, 1:null, 2:null)
        //strArray[0]  --->>        "JAVA"
        //strArray[1]  --->>        new String ("JAVA")
        //strArray[2]  --->>        new String ("JAVA")

        strArray[0] = "JAVA 1.8";
        strArray[1] = "JAVA 1.12";
        strArray[2] = new String("JAVA 1.13");

        String[] newArray = new String[3];
        System.arraycopy(strArray, 0,newArray,0,strArray.length);
        // strArray의 0번째를 newArray 0번째로 복사할 예정이고 개수는 strArray의 개수 만큼
        for(String str: newArray) {
            System.out.println(str);
        }

        // String[] names = new String[22];

//        System.out.println(strArray[0] == strArray[1]);
//        System.out.println(strArray[0] == strArray[2]);
//        System.out.println(strArray[0].equals(strArray[2]));
    }
}
