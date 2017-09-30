package MessagingService.Controllers;

import MessagingService.Models.Message;
import MessagingService.Services.Common.QPConnection;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class MessagingController extends BaseController {

    @RequestMapping(method=RequestMethod.POST, value="/postMessage")
    public Message postMessage(@RequestBody Message msg){
        msg.setReceivedTimeStamp(LocalDateTime.now().toString());
        QPConnection.getInstance().writeMessage(msg);
        return msg;
    }

    @RequestMapping("/getMessages")
    public String getMessages(){
        return QPConnection.getInstance().getMessages().toString();
    }
}
