package beans;

import lombok.Data;
import lombok.NonNull;

@Data
public class BeanThree implements IBeanWorker{
    public BeanThree(){}

    @NonNull
    private BeanOne beanOne;

    @NonNull
    private BeanTwo beanTwo;

    @NonNull
    private String message;


    @Override
    public void doTheWork() {
        beanOne.doTheWork();
        beanTwo.doTheWork();
        System.out.println(message);
    }
}
