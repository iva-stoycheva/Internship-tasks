import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MathExpression {
    public static double evaluate(String str) {
        Expression expression = new ExpressionBuilder(str).build();
        return expression.evaluate();
    }
}
