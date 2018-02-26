package serv;

import lombok.NonNull;
import msgs.IMessageService;

public class CompositeService implements IMessageService {

    private final IMessageService ms1;
    private final IMessageService ms2;

    public CompositeService(@NonNull IMessageService ms1, @NonNull IMessageService ms2){
       this.ms1 = ms1;
       this.ms2 = ms2;
    }
    @Override
    public String getMessage() {
        return ms1.getMessage() + ms2.getMessage();
    }
}
