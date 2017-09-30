package MessagingService.Services.Common;

import MessagingService.Common.Utilities.Constants;
import MessagingService.Common.Utilities.QPUtils;
import MessagingService.Models.Message;
import MessagingService.Services.PostMessage.Converters.PostMessageConverter;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

public class QPConnection {

    private static QPConnection instance;
    private static MongoClient client;
    private static MongoDatabase db;

    private QPConnection(){
        //singleton
    }

    public static QPConnection getInstance(){
        if(instance == null){
            instance = new QPConnection();
            try {
                client = new MongoClient(new MongoClientURI(QPUtils.getProp(Constants.mongoServerKey)));
                db = client.getDatabase(QPUtils.getProp(Constants.mongoDBKey));
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return instance;
    }

    private MongoCollection<Document> getCollection(String collectionName){
        //todo collection not found check
        return db.getCollection(collectionName);
    }

    //todo this is just hard coded for quick testing...need to build this out more
    public void writeMessage(Message msg){
        MongoCollection dbCon = db.getCollection("messages");
        dbCon.insertOne(PostMessageConverter.convert(msg));
    }

    public JSONArray getMessages(){
        JSONArray jArray = new JSONArray();
        MongoCursor<Document> cursor = db.getCollection("messages").find().iterator();
        while(cursor.hasNext()){
            jArray.put(new JSONObject(cursor.next().toJson()));
        }
        cursor.close();
        return jArray;
    }
}
