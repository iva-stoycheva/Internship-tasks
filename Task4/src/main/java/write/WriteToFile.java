package write;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class WriteToFile {
    public void write(String inputFile) throws IOException {
        File file = new File(inputFile);
        String line;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {

            while ((line = bufferedReader.readLine()) != null) {

                line = line.substring(0, line.length() - 3);

                StringTokenizer stringTokenizer = new StringTokenizer(line, "\\ |\\=|\\?");
                Stack<Integer> values = new Stack<Integer>();
                Stack<Character> ops = new Stack<Character>();

                bufferedWriter.append(line + " = " + Tokens.convertToStack(stringTokenizer, values, ops) + "\n");
            }
        }
    }
}

