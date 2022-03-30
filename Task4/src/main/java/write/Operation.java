package write;

public class Operation {
    public static int apply(char operation, int number2, int number1) {
        switch (operation) {
            case '+': return number1 + number2;
            case '-': return number1 - number2;
            case '*': return number1 * number2;
            case '/':
                if (number2 == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return number1 / number2;
        }
        return 0;
    }
}