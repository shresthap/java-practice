package practice;

/**
 * Created by pshrestha on 12/7/2016.
 */
public class Fibonacci {

    public static void mani(String[] args) {
        int number = 7;
        System.out.println("\n\nFibonacci series upto " + number + " numbers : ");

        for(int i = 0 ; i < number; i++){
            System.out.print(fibonacciIterative(i) + " " );
        }
    }

    public static int fibonacciRecursion(int number){
        if(number <= 1 ){
            return number;
        } else {
            return fibonacciRecursion(number-1) + fibonacciRecursion(number-2);
        }
    }

    public static int fibonacciIterative(int number){
        if(number <= 1 ){
            return number;
        }
        int fib01 = 0, fib02 = 1, fibonacci = 1;
        for(int i = 2; i <= number; i++){
            fibonacci = fib01 + fib02;
            fib01 = fib02;
            fib02 = fibonacci;
        }
        return fibonacci;
    }
}
