package write;

import java.util.Stack;
import java.util.StringTokenizer;

public class Tokens {
    public static int evaluate(StringTokenizer stringTokenizer, Stack<Integer> values, Stack<Character> ops) {
        while (stringTokenizer.hasMoreTokens()) {
            String str = stringTokenizer.nextToken();
            if (str.matches("\\d+")) {
                values.push(Integer.parseInt(str));
            }
            else {
                while (!ops.empty()) {
                    values.push(Operation.apply(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(str.charAt(0));
            }
        }
        while(!ops.empty()){
            values.push(Operation.apply(ops.pop(), values.pop(), values.pop()));
        }
        return values.pop();
    }
}





