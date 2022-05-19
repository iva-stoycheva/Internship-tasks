import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.mXparser;

public class MathExpression_mXparser {
    public static void evaluate(String str) {
        Expression expression = new Expression(str);
        mXparser.consolePrintln(expression.calculate());
    }
}
