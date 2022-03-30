package write;

import read.ReadFile;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class WriteToFile {
    public void write(String inputFile) throws IOException {
        File file = new File(inputFile);
        String line;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {

            while ((line=bufferedReader.readLine()) != null) {

                StringBuffer sb = new StringBuffer(line);
                sb.deleteCharAt(sb.length() - 1);

                StringTokenizer stringTokenizer = new StringTokenizer(line, "\\ |\\=|\\?");

                Stack<Integer> values = new Stack<Integer>();
                Stack<Character> ops = new Stack<Character>();

                Tokens.convertToStack(stringTokenizer, values, ops);

                while (!ops.empty()) {
                    values.push(Operation.apply(ops.pop(), values.pop(), values.pop()));
                    bufferedWriter.append(sb.toString() + values.pop() + "\n");
                }
            }
        }
    }
}


