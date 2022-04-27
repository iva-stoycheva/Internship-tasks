import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EvaluateMethodTest {
    @Test
    public void givenSimpleInfixExpression_whenCallEvaluateMethod_thenSuccess() {
        Expression expression = new ExpressionBuilder("14 * 6 / 12").build();
        double result = expression.evaluate();
        Assertions.assertEquals(7, result);
    }
}
