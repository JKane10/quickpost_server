package MessagingService.Common.Utilities;

import MessagingService.MessagingService;

import java.io.IOException;
import java.util.Properties;

public class QPUtils {

    public static Properties prop;

    public static String getProp(String propName){
        String rtn = null;
        if(prop == null){
            try {
                prop.load(MessagingService.class.getClassLoader().getResourceAsStream(Constants.propertiesFile));
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        } else {
            rtn = prop.getProperty(propName);
        }
        return rtn;
    }

}