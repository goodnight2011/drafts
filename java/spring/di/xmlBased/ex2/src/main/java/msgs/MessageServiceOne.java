package msgs;

public class MessageServiceOne implements IMessageService {

    @Override
    public String getMessage() {
        return "message1";
    }

    public IMessageService createService(){

       return new IMessageService() {
           @Override
           public String getMessage() {
               return "factory method message";
           }
       };
    }
}
