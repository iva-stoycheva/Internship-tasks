import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.Map;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){
        try {
            System.out.println("Enter math expression to be calculated: ");
            String mathExpression = "";
            Scanner scanner = new Scanner(System.in);
            mathExpression = scanner.nextLine();
            String onlyOperandsAndOperators = mathExpression.substring(0, mathExpression.indexOf("="));
            Expression expression1 = new ExpressionBuilder(onlyOperandsAndOperators).build();
            System.out.println("Result: " + expression1.evaluate());

            System.out.println("Enter expression with unknown variables: ");
            String calculationEngine = scanner.nextLine();
            String onlyOperandsAndOperatorsWithUnknownVariable = calculationEngine.substring(0, calculationEngine.indexOf("="));

            Map<String, Float> variables = Variables.read();
            var variableEntries = variables.entrySet();
            Expression expression2 = new ExpressionBuilder(onlyOperandsAndOperatorsWithUnknownVariable)
                    .variables("x", "y", "z", "k")
                    .build();
            for (Map.Entry<String, Float> variableEntry : variableEntries) {
                variableEntry.setValue(variableEntry.getValue());
                expression2.setVariable(variableEntry.getKey(), variableEntry.getValue());
            }

            System.out.println(variableEntries);
            System.out.println("Result: " + expression2.evaluate());

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
