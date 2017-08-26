package MessagingService.Models;

public class Message {

    private String id;

    private String msg;

    private String user;

    private String timeStamp;

    public Message(){

    }

    public Message(String msg, String user, String timeStamp){
        this.msg = msg;
        this.user = user;
        this.timeStamp = timeStamp;
    }

    /**
     * GETTERS
     **/

    public String getMsg() {
        return msg;
    }

    public String getUser() {
        return user;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * GETTERS
     **/

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
