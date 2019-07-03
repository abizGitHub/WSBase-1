package util;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * Created with IntelliJ IDEA.
 * User: Abiz
 * Date: 9/15/18
 * Time: 1:01 AM
 * To change this template use File | Settings | File Templates.
 */

public class AppConfig {
    private static AppConfig applicationConfiguration;
    private static Configuration config;
    private static String path;

    public static Configuration getConfig() {
        if (applicationConfiguration == null)
            applicationConfiguration = new AppConfig();
        return config;
    }

    public static void Refresh() {
        applicationConfiguration = new AppConfig();
    }

    private AppConfig() {
        if (path == null)
            path = "./config.txt";
        if (path != null) {
            try {
                config = new PropertiesConfiguration(path);
            } catch (ConfigurationException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(AppConfig.getConfig().getString(""));
    }

    public static String filePath() {
        return getConfig().getString("filePath");
    }

    public static String getPath() {
        return path;
    }

    public static boolean disconnect() {
        return getConfig().getBoolean("disconnect");
    }

    public static String getImagePath() {
        return getConfig().getString("imagePath");
    }
}

