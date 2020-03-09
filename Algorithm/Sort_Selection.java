public class Sort_Selection {
    public static void printArray(int[] Array){
        for (int data:Array         ) {
            System.out.print(data+ " ");
        }
    }
    public static void tempArray(int x, int y){
        int temp;
        temp = x;
        x = y;
        y = x;
    }
    public static void main(String[] args) {
        int[] Array = {3,5,4,2,1};
        int temp = 0;
        for(int i = 0; i < Array.length; i++){
            for(int j = i+1; j <Array.length; j++){
                if(Array[i] > Array[j]){
                    //tempArray(Array[i],Array[j]);
                    temp = Array[i];
                    Array[i] = Array[j];
                    Array[j] = temp;
                }
            }
        }

        printArray(Array);
    }
}
