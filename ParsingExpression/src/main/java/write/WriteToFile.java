package write;

import java.io.*;
import java.util.Stack;

public class WriteToFile {
    public void write(String inputFile) throws IOException {
        File file = new File(inputFile);
        String line;
        String finalString = "";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {

            while ((line = bufferedReader.readLine()) != null) {
                finalString = line;
                StringBuffer sb = new StringBuffer(finalString);
                sb.deleteCharAt(sb.length() - 1);
                finalString = sb.toString();

                char[] tokens = finalString.toCharArray();
                Stack<Integer> values = new Stack<Integer>();
                Stack<Character> ops = new Stack<Character>();

                Tokens.tokensToStack(tokens, values, ops);

                while (!ops.empty()) {
                    values.push(Operation.applyOp(ops.pop(), values.pop(), values.pop()));
                    bufferedWriter.append(finalString + values.pop() + "\n");
                }
            }
        }
    }
}
