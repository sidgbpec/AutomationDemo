package config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties prop;

    public ReadConfig() {
       File src=new File("./Configurations/config.properties");
        try
        {
            FileInputStream fis=new FileInputStream(src);
            prop= new Properties();
            prop.load(fis);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public String getApplicationurl()
    {
        return prop.getProperty("applicationURL");
    }
    
    public String getUserGeneratorURL()
    {
        return prop.getProperty("userGeneratorURL");
    }
 }
