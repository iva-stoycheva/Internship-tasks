import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        int firstNumber, secondNumber;
        int sum, difference, product;
        float quotient;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your first number: ");
        firstNumber = scanner.nextInt();

        System.out.println("Now enter your second number: ");
        secondNumber = scanner.nextInt();

        /*//first way
        //addition
        sum = firstNumber + secondNumber;
        System.out.println("Addition: " + sum);

        //subtraction
        difference = firstNumber - secondNumber;
        System.out.println("Subtraction: " + difference);

        //multiplication
        product = firstNumber * secondNumber;
        System.out.println("Multiplication: " + product);

        //division
        quotient = (float)firstNumber / secondNumber;
        System.out.println("Division: " + quotient);

        //second way
        int choice;
        System.out.println();
        System.out.println("Choices: ");
        System.out.println("0. Exit");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println();

        while(true) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    sum = firstNumber + secondNumber;
                    System.out.println("Addition: " + sum);
                    break;
                case 2:
                    difference = firstNumber - secondNumber;
                    System.out.println("Subtraction: " + difference);
                    break;
                case 3:
                    product = firstNumber * secondNumber;
                    System.out.println("Multiplication: " + product);
                    break;
                case 4:
                    quotient = (float)firstNumber / secondNumber;
                    System.out.println("Division: " + quotient);
                    break;
                default:
                    System.out.println("You have entered invalid number!!!");
            }
        }

        //third way
        System.out.println("Addition: " + Integer.sum(firstNumber, secondNumber));
        System.out.println("Subtraction: " + Math.subtractExact(firstNumber, secondNumber));
        System.out.println("Multiplication: " + Math.multiplyExact(firstNumber, secondNumber));
        System.out.println("Division: " + Math.floorDiv(firstNumber, secondNumber));*/

        //forth way
        System.out.println("Addition: " + sum(firstNumber, secondNumber));
        System.out.println("Subtraction: " + difference(firstNumber, secondNumber));
        System.out.println("Multiplication: " + product(firstNumber, secondNumber));
        System.out.println("Division: " + quotient(firstNumber, secondNumber));
    }
    //addition
    public static int sum(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }
    //subtraction
    public static int difference(int firstNumber, int secondNumber){
        return firstNumber - secondNumber;
    }
    //multiplication
    public static int product(int firstNumber, int secondNumber){
        return firstNumber * secondNumber;
    }
    //division
    public static float quotient(int firstNumber, int secondNumber){
        return (float)firstNumber / secondNumber;
    }
}
