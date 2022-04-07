import java.io.*;

public class ProjectApplication {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");
        String line;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile, false))) {

            while ((line = bufferedReader.readLine()) != null) {

                String[] strArray = InfixToPostfix.convert(line.substring(0, line.indexOf("="))).split("\\s+");

                int result = Calculations.evaluateRPN(strArray);

                bufferedWriter.append(line.replace("?", result + "\n"));
            }
        }
        inputFile.renameTo(new File("inputNew.txt"));
        outputFile.renameTo(new File("input.txt"));
    }
}