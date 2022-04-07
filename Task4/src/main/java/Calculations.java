import java.util.Stack;

public class Calculations {
    public static int evaluateRPN(String[] tokens) {
        Stack<Integer> values = new Stack<>();
        String operators = "+-*/";
        for (String token : tokens) {
            if (!operators.contains(token)) {
                values.push(Integer.valueOf(token));
                continue;
            }
            int firstOperand = values.pop();
            int secondOperand = values.pop();
            if (token.equals("+")) {
                values.push(secondOperand + firstOperand);
            } else if (token.equals("-")) {
                values.push(secondOperand - firstOperand);
            } else if (token.equals("*")) {
                values.push(secondOperand * firstOperand);
            } else {
                values.push(secondOperand / firstOperand);
            }
        }
        return values.pop();
    }
}


