package MessagingService.Controllers;

import MessagingService.Models.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagingController {

    @RequestMapping("/testEndPoint")
    public Message testMessage(@RequestParam(value="msg") String msg,
                               @RequestParam(value="user") String user,
                               @RequestParam(value="timeStamp") String timeStamp){
        return new Message(msg, user, timeStamp);
    }

    @RequestMapping("/test")
    public String test(){
        System.out.println("test method called");
        return "test";
    }
}
