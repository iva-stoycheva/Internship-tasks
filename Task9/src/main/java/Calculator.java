import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Еnter math expression in binary, octal, decimal or hexadecimal: ");
            String str = scanner.nextLine();
            String line = str.substring(0, str.indexOf("="));

            String calculationEngine = System.getenv("calculationEngine");
            if (calculationEngine.equals("rpn")) {
                String[] strArray = InfixToPostfix.convert(line).split("\\s+");
                int result = RPN.evaluateRPN(strArray);
                System.out.println(result);
            }
            else if (calculationEngine.equals("mXparser")){
                MathExpression_mXparser.evaluate(line);
            }
            else {
                System.out.println("Unknown calculation engine: " + calculationEngine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
