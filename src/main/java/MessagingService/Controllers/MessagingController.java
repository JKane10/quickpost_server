package MessagingService.Controllers;

import MessagingService.Models.Message;
import MessagingService.Services.Common.QPConnection;
import com.mongodb.DBObject;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MessagingController extends BaseController {

    @RequestMapping(method=RequestMethod.POST, value="/postMessage")
    public Message postMessage(@RequestBody Message msg){
        msg.setReceivedTimeStamp(LocalDateTime.now().toString());
        QPConnection.getInstance().writeMessage(msg);
        return msg;
    }

    @RequestMapping("/getMessages")
    public List<DBObject> getMessages(){
        return QPConnection.getInstance().getMessages();
        //return new ArrayList<Message>();//todo place holder
    }
}
