import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        //(2 + 3) * 4 - 2 = ?
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String line = str.substring(0, str.indexOf("="));
        double result = MathExpression.evaluate(line);
        System.out.println(result);
    }
}
