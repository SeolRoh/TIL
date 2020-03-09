// O^2

public class Sort_Bubble {
    public static void printArray(int[] array) {
        for (int data: array         ) {
            System.out.print(data + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {5,1,4,2,3};
        int temp=0;
        for(int i=0; i<array.length - 1; i++){
            for(int j=0; j < array.length - 1 ; j++){
                if(array[j]>array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        printArray(array);
    }
}