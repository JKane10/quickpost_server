package MessagingService.Services.Common;

import MessagingService.Common.Utilities.Constants;
import MessagingService.Common.Utilities.QPUtils;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class QPConnection {

    private static MongoClient client;
    private static DB db;

    public QPConnection(){
        //singleton
    }

    public DB getInstance(){
        if(client == null){
            try {
                client = new MongoClient(new MongoClientURI(QPUtils.getProp(Constants.mongoServerKey)));
                db = client.getDB(QPUtils.getProp(Constants.mongoDBKey));
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return db;
    }

    public DBCollection getCollection(String collectionName){
        //todo collection not found check
        return db.getCollection(collectionName);
    }
}
