package write;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WriteToFile {
    public void write(String inputFile) throws IOException {
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
        }
    }
}
