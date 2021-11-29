package entity;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class CM {
    private static final Properties prop = new Properties();

    static {
        InputStream io = CM.class.getClassLoader().getResourceAsStream("confect.properties");
        try {
            prop.load(io);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProp(String key) {
        return prop.getProperty(key);
    }
}