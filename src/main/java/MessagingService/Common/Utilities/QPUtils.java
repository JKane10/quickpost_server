package MessagingService.Common.Utilities;

import MessagingService.MessagingService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class QPUtils {

    private static Properties prop;
    private static InputStream input;

    public static String getProp(String propName){
        String rtn = null;
        if(prop == null){
            try {
                prop = new Properties();
                input = new FileInputStream(Constants.propertiesFile);
                prop.load(input);
                rtn = prop.getProperty(propName);
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        } else {
            rtn = prop.getProperty(propName);
        }
        return rtn;
    }
}
