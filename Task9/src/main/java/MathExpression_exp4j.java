import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MathExpression_exp4j {
    public static double evaluate(String str) {
        Expression exp = new ExpressionBuilder(str).build();
        return exp.evaluate();
    }
}
