import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InfixToPostfixTest {
    @Test
    public void convert_InfixGiven_ShouldShowPostfix() {
        String exp = "2 * 13 / 3";
        assertEquals("2  13 * 3/", InfixToPostfix.convert(exp));
    }

    @Test
    public void convert_WrongInfixGiven_ShouldThrowAndCatchException() {
        String exp = "2 13 3 * ,";
        assertThrows(IllegalArgumentException.class, () -> InfixToPostfix.convert(exp));
    }
}
