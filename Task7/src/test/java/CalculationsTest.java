import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculationsTest {
    @Test
    public void calculateRPN_PostfixGiven_ShouldShowCalculationsResult() {
        String[] tokens = new String[] {"2", "3", "*", "1", "-"};
        assertEquals(5, Calculations.evaluateRPN(tokens));
    }

    @Test
    public void calculateRPN_WrongPostfixGiven_ShouldThrowAndCatchException() {
        String[] tokens = new String[] {"2", "3", "^", "1", "-"};
        assertThrows(NumberFormatException.class, () -> Calculations.evaluateRPN(tokens));
    }
}