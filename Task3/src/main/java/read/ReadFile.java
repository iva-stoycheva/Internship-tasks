package read;

import java.io.*;

public class ReadFile {
    public void read(String inputFile) throws IOException {
        File file = new File(inputFile);
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null)
                System.out.println(line);
        }
    }
}
