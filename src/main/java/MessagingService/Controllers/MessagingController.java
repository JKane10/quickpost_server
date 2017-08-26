package MessagingService.Controllers;

import MessagingService.Models.Message;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MessagingController extends BaseController {

    @RequestMapping(method=RequestMethod.POST, value="/postMessage")
    public Message postMessage(@RequestBody Message msg){
        msg.setReceivedTimeStamp(LocalDateTime.now().toString());
        return msg;
    }

    @RequestMapping("/getMessages")
    public List<Message> getMessages(){
        return new ArrayList<Message>();//todo place holder
    }
}
