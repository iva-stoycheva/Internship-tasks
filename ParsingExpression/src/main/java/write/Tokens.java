package write;

import java.util.Stack;

public class Tokens {
    public static void tokensToStack(char[] tokens, Stack<Integer> values, Stack<Character> ops) {
        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i] == ' ')
                continue;

            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer sbuf = new StringBuffer();

                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                    sbuf.append(tokens[i++]);
                }

                values.push(Integer.parseInt(sbuf.toString()));

            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {

                while (!ops.empty()) {
                    values.push(Operation.applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(tokens[i]);
            }
        }
    }
}
