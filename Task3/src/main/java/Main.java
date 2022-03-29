import read.ReadFile;
import write.WriteToFile;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ReadFile inputFile = new ReadFile();
        inputFile.read("input.txt");

        WriteToFile outputFile = new WriteToFile();
        outputFile.write("input.txt");
    }
}