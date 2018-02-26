package beans;

public class BeanTwo implements IBeanWorker {
    public void doTheWork(){
        System.out.println("this is bean two");
    }

    public static class BeanTwoStatic implements IBeanWorker{

        @Override
        public void doTheWork() {
           System.out.println("static method factory");
        }
    }
    public static IBeanWorker createWorker(){
       return new BeanTwoStatic();
    }

}
