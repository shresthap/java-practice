package practice;

/**
 * Created by pshrestha on 12/7/2016.
 */
public class Factorial {

    public static void main(String[] args) {
        int number = 3;
        System.out.println("\n\nFactorial of Number  " + number + ": " + factorialIterative(number));
    }

    public static int factorialRecursive(int number){
        if(number == 0){
            return 1;
        }
        else {
            return number * factorialRecursive(number-1);
        }
    }

    public static int factorialIterative(int number){
//        if(number <= 1){
//            return 1;
//        }
        int factorial = 1;
        for(int i = 1; i <= number; i++){
            factorial = factorial * i;
        }
        return  factorial;
    }
}
