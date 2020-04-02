public class Calculator {
    int left;
    int right;

    void method (int left, int right){
        this.left = left;
        this.right = right;
    }
    int add (){
        return left + right ;
    }

    public static void main(String[] args) {
        int result;

        Calculator a1 = new Calculator();
        a1.method(10,20);
        result = a1.add();

        System.out.println(result);
    }
}
