class substractionableCalculator extends Calculator{
        int substract(){
        return left - right;
    }
}
public class Calculator {
    int left;
    int right;

    void setOperands (int left, int right){
        this.left = left;
        this.right = right;
    }
    int add (){
        return left + right ;
    }


    public static void main(String[] args) {
        int result;

        Calculator a1 = new Calculator();
        a1.setOperands(10,20);
        result = a1.add();

        System.out.println(result);

        substractionableCalculator a1 = new substractionableCalculator();
        a1.setOperands(30,40);
        result = a1.add();
        System.out.println(result);
        result = a1.substract();
        System.out.println(result);
    }
}
