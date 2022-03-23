package write;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WriteToFile {

    public static final String OUTPUT_FILE_FORMAT = "%d %s %d = %.2f\n";

    public void write(String inputFile) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(inputFile));
        File file = new File(inputFile);

        try (FileWriter fileWriter = new FileWriter(file, true)) {
            for (String line : lines) {
                String[] splitElements = line.split(" ");
                int firstNum = Integer.parseInt(splitElements[0]);
                String operation = splitElements[1];
                int secondNum = Integer.parseInt(splitElements[2]);

                float result;
                switch (operation) {
                    case "+":
                        result = firstNum + secondNum;
                        break;
                    case "-":
                        result = firstNum - secondNum;
                        break;
                    case "*":
                        result = firstNum * secondNum;
                        break;
                    case "/":
                        result = (float) firstNum / secondNum;
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown operation");
                }
                fileWriter.append(String.format(OUTPUT_FILE_FORMAT, firstNum, operation, secondNum, result));
            }
        }
    }
}
    /*public void write(String inputFile) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(inputFile));
        File file=new File(inputFile);
        String newLine=null;
        String finalResult=null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");
        try (FileWriter fileWriter=new FileWriter(file, true)) {
            for (String line : lines) {
                newLine=line.substring(0, line.length()-3);
                try {
                    Object result = engine.eval(newLine);
                    finalResult = newLine + "= " + result;
                }
                catch (ScriptException e) {
                    e.printStackTrace();
                }
                fileWriter.append(finalResult + "\n");
            }
        }*/
