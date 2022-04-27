import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.io.*;

public class ProjectApplication {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");
        String line;
        String str;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile, false))) {

            while ((line = bufferedReader.readLine()) != null) {
                str=line.substring(0, line.indexOf("="));

                Expression expression = new ExpressionBuilder(str).build();
                double result = expression.evaluate();

                bufferedWriter.append(line.replace("?", result + "\n"));
            }
        }
    }
}