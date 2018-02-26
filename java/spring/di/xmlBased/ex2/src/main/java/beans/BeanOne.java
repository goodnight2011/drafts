package beans;

public class BeanOne implements IBeanWorker{
    public void doTheWork(){
        System.out.println("this is bean1");
    }

    public static class InnerBean implements IBeanWorker{

        @Override
        public void doTheWork() {
           System.out.println("inner bean");
        }
    }
}
