import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class EvaluateMethodTest {
    @Test
    public void givenSimpleInfixExpression_whenCallEvaluateMethod_thenSuccess() {
        Expression expression = new ExpressionBuilder("14 * 6 / 12").build();
        double result = expression.evaluate();
        Assertions.assertEquals(7, result);
    }

    @Test
    public void givenWrongInfixExpression_whenCallEvaluateMethod_thenThrowAndCatchException() {
        String exp = "14 * 6 , 12";
        assertThrows(IllegalArgumentException.class, () -> InfixToPostfix.convert(exp));
    }
}
