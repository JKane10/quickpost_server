package MessagingService.Common.Utilities;

import MessagingService.MessagingService;

import java.io.IOException;
import java.util.Properties;

public class QPUtils {

    private static Properties prop;

    public static String getProp(String propName){
        String rtn = null;
        if(prop == null){
            try {
                //todo this is failing
                prop.load(MessagingService.class.getClassLoader().getResourceAsStream(Constants.propertiesFile));
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
