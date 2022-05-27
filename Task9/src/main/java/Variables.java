import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Variables {
    public static Map<String, Float> read() throws IOException, NumberFormatException{
        Properties properties = new Properties();
        properties.load(new FileReader("calculator.properties"));

        HashMap<String, Float> variablesMap = new HashMap<String, Float>();
        for (int i=0; i<10; i++) {
            String name = System.getProperty("VAR_NAME_" + i);
            String value = System.getProperty("VAR_VALUE_" + i);
            if (name != null && value != null) {
                properties.setProperty(name, value);
            }

            name = System.getenv("VAR_NAME_" + i);
            value = System.getenv("VAR_VALUE_" + i);
            if (name != null && value != null) {
                properties.setProperty(name, value);
            }

            name = properties.getProperty("VAR_NAME_" + i);
            value = properties.getProperty("VAR_VALUE_" + i);
            if (name != null && value != null) {
                variablesMap.put(name, Float.parseFloat(value));
            }
        }

        return variablesMap;
    }
}
