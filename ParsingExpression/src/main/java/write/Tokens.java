package write;

import java.util.Stack;
import java.util.StringTokenizer;

public class Tokens {
    public static void convertToStack(StringTokenizer stringTokenizer, Stack<Integer> values, Stack<Character> ops) {
        while (stringTokenizer.hasMoreTokens()) {
            String str = stringTokenizer.nextToken();
            if (str.matches("\\d+")) {
                values.push(Integer.parseInt(str));
            }
            else {
                ops.push(str.charAt(0));
            }
        }
    }
}





