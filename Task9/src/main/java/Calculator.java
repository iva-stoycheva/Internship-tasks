import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.io.IOException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter math expression to be calculated: ");
        String mathExpression = "";
        Scanner scanner = new Scanner(System.in);
        mathExpression = scanner.nextLine();
        String onlyOperandsAndOperators = mathExpression.substring(0, mathExpression.indexOf("="));
        Expression expression1 = new ExpressionBuilder(onlyOperandsAndOperators).build();
        System.out.println("Result: " + expression1.evaluate());

        String calculationEngine = System.getenv("expression");
        System.out.println(calculationEngine);
        String onlyOperandsAndOperatorsForProperty = calculationEngine.substring(0, calculationEngine.indexOf("="));

        String num1, num2, num3, num4;
        System.out.println("Enter x: ");
        num1=scanner.nextLine();
        System.setProperty("x", num1);
        System.out.println("Enter y: ");
        num2=scanner.nextLine();
        System.setProperty("x", num2);
        System.out.println("Enter z: ");
        num3=scanner.nextLine();
        System.setProperty("x", num3);
        System.out.println("Enter k: ");
        num4=scanner.nextLine();
        System.setProperty("x", num4);

        Expression expression2 = new ExpressionBuilder(onlyOperandsAndOperatorsForProperty)
                .variables("x", "y", "z", "k")
                .build()
                .setVariable("x", Double.parseDouble(num1))
                .setVariable("y", Double.parseDouble(num2))
                .setVariable("z", Double.parseDouble(num3))
                .setVariable("k", Double.parseDouble(num4));

        double result2 = expression2.evaluate();
        System.out.println("Result with input values and system properties: " + result2);

        Expression expression3 = new ExpressionBuilder(onlyOperandsAndOperatorsForProperty)
                .variables("x", "y", "z", "k")
                .build()
                .setVariable("x", Double.parseDouble(System.getenv("x")))
                .setVariable("y", Double.parseDouble(System.getenv("y")))
                .setVariable("z", Double.parseDouble(System.getenv("z")))
                .setVariable("k", Double.parseDouble(System.getenv("k")));

        Properties_KeyValue.print("calculator.properties");

        double result3 = expression3.evaluate();
        System.out.println("Result with environment variables: " + result3);
    }
}
