package MessagingService.Services.Common;

import MessagingService.Common.Utilities.Constants;
import MessagingService.Common.Utilities.QPUtils;
import MessagingService.Models.Message;
import MessagingService.Services.PostMessage.Converters.PostMessageConverter;
import com.mongodb.*;

import java.util.List;

public class QPConnection {

    private static QPConnection instance;
    private static MongoClient client;
    private static DB db;

    private QPConnection(){
        //singleton
    }

    public static QPConnection getInstance(){
        if(instance == null){
            instance = new QPConnection();
            try {
                client = new MongoClient(new MongoClientURI(QPUtils.getProp(Constants.mongoServerKey)));
                db = client.getDB(QPUtils.getProp(Constants.mongoDBKey));
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return instance;
    }

    private DBCollection getCollection(String collectionName){
        //todo collection not found check
        return db.getCollection(collectionName);
    }

    //todo this is just hard coded for quick testing...need to build this out more
    public void writeMessage(Message msg){
        db.getCollection("messages").insert((PostMessageConverter.convert(msg)));
    }

    public List<DBObject> getMessages(){
        DBCursor cursor = db.getCollection("message").find();
        return cursor.toArray();
    }
}
