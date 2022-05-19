import java.util.Stack;

public class RPN {
    public static int evaluate(String[] tokens) {
        Stack<Integer> values = new Stack<>();
        String operators = "+-*/";
        for (String token : tokens) {
            if (!operators.contains(token)) {
                values.push(Integer.valueOf(token));
                continue;
            }

            int firstOperand = values.pop();
            int secondOperand = values.pop();

            switch (token) {
                case "+": {
                    values.push(secondOperand + firstOperand);
                    break;
                }
                case "-": {
                    values.push(secondOperand - firstOperand);
                    break;
                }
                case "*": {
                    values.push(secondOperand * firstOperand);
                    break;
                }
                case "/": {
                    values.push(secondOperand / firstOperand);
                    break;
                }
            }
        }
        return values.pop();
    }
}