import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Properties_KeyValue {
    public static void print(String filename) throws IOException {
        Map<String, String> properties = new HashMap<>();

        try (InputStream stream = new FileInputStream(filename))
        {
            Properties prop = new Properties() {
                @Override
                public synchronized Object put(Object key, Object value) {
                    return properties.put(key.toString(), value.toString());
                }
            };
            prop.load(stream);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties);
    }
}
