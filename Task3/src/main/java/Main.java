import read.ReadFile;
import write.WriteToFile;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ReadFile file = new ReadFile();
        file.read("input.txt");

        WriteToFile file1 = new WriteToFile();
        file1.write("input.txt");
    }
}