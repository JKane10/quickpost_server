package MessagingService.Services.PostMessage.Converters;

import MessagingService.Models.Message;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class PostMessageConverter {

    public static DBObject convert(Message msg){
        //todo this is sloppy, find a better, more general way to convert server objects to db objects
        DBObject dbMsg = new BasicDBObject()
                .append("msg", msg.getMsg())
                .append("user", msg.getUser())
                .append("sentTS", msg.getSentTimeStamp())
                .append("receivedTS", msg.getReceivedTimeStamp());

        return dbMsg;
    }

}
