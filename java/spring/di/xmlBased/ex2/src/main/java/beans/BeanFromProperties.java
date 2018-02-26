package beans;

import lombok.Setter;

import java.util.Properties;

public class BeanFromProperties implements IBeanWorker {

    @Setter
    Properties props;


    @Override
    public void doTheWork() {
        System.out.println(props.getProperty("bean.prop.name") +":" + props.getProperty("bean.prop.message"));
    }
}
