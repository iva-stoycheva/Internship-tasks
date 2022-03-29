package write;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WriteToFile {

    public static final String OUTPUT_FILE_FORMAT = "%d %s %d = %.2f\n";

    public void write(String ouputFileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(ouputFileName));
        File file = new File(ouputFileName);
        try (FileWriter fileWriter = new FileWriter(file, true)){
            for (String line : lines) {
                String[] splitElements = line.split(" ");
                int firstNum = Integer.parseInt(splitElements[0]);
                String operation = splitElements[1];
                int secondNum = Integer.parseInt(splitElements[2]);

                float result = Operation.apply(firstNum, operation, secondNum);
                fileWriter.append(String.format(OUTPUT_FILE_FORMAT, firstNum, operation, secondNum, result));
            }
        }
    }
}
