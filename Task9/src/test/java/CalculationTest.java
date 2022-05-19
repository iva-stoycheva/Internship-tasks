import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTest {
    @Test
    public void givenSimpleMathExpression_whenCallEvaluateMethod_thenSuccess() {
        String binaryExpression = "(b.10+b.11)*b.100-b.10=?";
        MathExpression_mXparser.evaluate(binaryExpression);
    }
}
