import java.util.Stack;

public class InfixToPostfix {
    public static boolean getPrecedence(char firstOperator, char secondOperator) {
        int value1 = 0, value2 = 0;

        if (firstOperator == '-' || firstOperator == '+') {
            value1 = 1;
        } else if (firstOperator == '*' || firstOperator == '/') {
            value1 = 2;
        }

        if (secondOperator == '-' || secondOperator == '+') {
            value2 = 1;
        } else if (secondOperator == '*' || secondOperator == '/') {
            value2 = 2;
        }

        return (value1 < value2) ? false : true;
    }

    public static String convert(String infixExp) {
        String postFix = "";
        Stack<Character> stack = new Stack<>();
        char character;

        for (int i = 0; i < infixExp.length(); i++) {
            character = infixExp.charAt(i);

            if (character == '*' || character == '-' || character == '/' || character == '+') {
                while (!stack.empty() && getPrecedence(stack.peek(), character)) {
                    postFix += stack.pop();
                }
                stack.push(character);
            } else {
                postFix += character;
            }
        }
        while (!stack.empty()) {
            postFix += stack.pop();
        }
        return postFix;
    }
}