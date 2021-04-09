package helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private final String PROPERTY_FILE_PATH = "src/test/resources/config.properties";
    private final Properties properties;

    private static ConfigFileReader configFileReader = null;

    private ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(PROPERTY_FILE_PATH));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + PROPERTY_FILE_PATH);
        }
    }

    public static ConfigFileReader getConfigFileReader() {
        if (configFileReader == null) {
            configFileReader = new ConfigFileReader();
        }
        return configFileReader;
    }

    public String getBaseUrl() {
        String url = properties.getProperty("baseUrl");
        if (url != null) {
            return url;
        } else {
            throw new RuntimeException("url is not specified in the configuration.properties file.");
        }
    }
}
