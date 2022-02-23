package access.DBconnection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
//don't work
public final class PropertiesUtil {
    private static final Properties PROPERTIES = new Properties();

    static
    {
        ConnectionProperties();
    }

    public static String get(String key) {
       return PROPERTIES.getProperty("key");
    }

    private static void ConnectionProperties() {
        try(InputStream inputStream =  PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
