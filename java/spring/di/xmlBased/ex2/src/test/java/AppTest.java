/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import beans.BeanOne;
import beans.BeanThree;
import beans.BeanTwo;
import beans.IBeanWorker;
import lombok.val;
import msgs.IMessageService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import serv.IService;

import static org.junit.Assert.*;

public class AppTest {
    @Test public void test1(){
        val ctx = new ClassPathXmlApplicationContext("classpath:/conf/beans.xml");
        val b1 = ctx.getBean("b1");
        val b2 = ctx.getBean("b2");
        ((BeanOne)b1).doTheWork();
        ((BeanTwo)b2).doTheWork();
        ctx.destroy();
    }

    @Test public void test2(){
        val ctx = new ClassPathXmlApplicationContext("classpath:/conf/beans.xml");
        val b1 = ctx.getBean("b1", IBeanWorker.class);
        val b2 = ctx.getBean("b2", IBeanWorker.class);
        b1.doTheWork();
        b2.doTheWork();
        ctx.destroy();
    }

    @Test
    public void test3(){
        val ctx = new ClassPathXmlApplicationContext("classpath:/conf/beans.xml", "classpath:/conf/msgs.xml");
        val b1 = ctx.getBean("b1", IBeanWorker.class);
        val b2 = ctx.getBean("b2", IBeanWorker.class);
        b1.doTheWork();
        b2.doTheWork();
        val ms1 = ctx.getBean("ms1", IMessageService.class);
        val ms2 = ctx.getBean("ms2", IMessageService.class);
        assertEquals(ms1.getMessage(), "message1");
        assertEquals(ms2.getMessage(), "message2");
        ctx.close();
    }

    @Test
    public void importTest(){
        val ctx = new ClassPathXmlApplicationContext("conf/serv.xml");
        val b1 = ctx.getBean("b1", IBeanWorker.class);
        val b2 = ctx.getBean("b2", IBeanWorker.class);
        b1.doTheWork();
        b2.doTheWork();
        val ms1 = ctx.getBean("ms1", IMessageService.class);
        val ms2 = ctx.getBean("ms2", IMessageService.class);
        assertEquals(ms1.getMessage(), "message1");
        assertEquals(ms2.getMessage(), "message2");

        val serv1 = ctx.getBean("serv1", IService.class);
        val serv2 = ctx.getBean("serv2", IService.class);
        assertEquals(1, serv1.serve());
        assertEquals(2, serv2.serve());
        ctx.close();
    }

    @Test
    public void aliasTest(){
        val ctx = new ClassPathXmlApplicationContext("conf/serv.xml");
        val b2 =ctx.getBean("secondBean");
        ((BeanTwo)b2).doTheWork();
        ctx.close();
    }

    @Test
    public void aliasTest1(){
        val ctx = new ClassPathXmlApplicationContext("conf/serv.xml");
        val b2 =ctx.getBean("primaryBean");
        ((BeanOne)b2).doTheWork();
        ctx.close();
    }

    @Test
    public void innerClassBean(){
       val ctx = new ClassPathXmlApplicationContext("conf/beans.xml");
       val bi = ctx.getBean("bi");
       assertTrue(bi instanceof BeanOne.InnerBean);
        ((IBeanWorker)bi).doTheWork();
       ctx.close();
    }

    @Test
    public void staticMethodFactory(){
        val ctx = new ClassPathXmlApplicationContext("conf/beans.xml");
        val bi = ctx.getBean("bs");
        assertTrue(bi instanceof BeanTwo.BeanTwoStatic);
        ((IBeanWorker)bi).doTheWork();
        ctx.close();
    }

    @Test
    public void beanFactoryMethod(){
        val ctx = new ClassPathXmlApplicationContext("conf/msgs.xml");
        val mfm = ctx.getBean("mfm", IMessageService.class);
        assertEquals("factory method message", mfm.getMessage());

        ctx.close();
    }

    @Test
    public void cnstrArgs(){
        val ctx=  new ClassPathXmlApplicationContext("conf/msgs.xml");
        val mcomp = ctx.getBean("mcomp", IMessageService.class);
        assertEquals("message1message2", mcomp.getMessage());
        ctx.close();
    }

    @Test
    public void cnstrArgs1(){
        val ctx=  new ClassPathXmlApplicationContext("conf/msgs.xml");
        val mcomp = ctx.getBean("mcust", IMessageService.class);
        assertEquals("0pref:msg1pref:msg", mcomp.getMessage());
        ctx.close();
    }

    @Test
    public void setters(){
        val ctx = new ClassPathXmlApplicationContext("conf/beans.xml");
        val b3 = ctx.getBean(BeanThree.class);
        b3.doTheWork();
        ctx.close();
    }

    @Test
    public void javaUtilPropertiesAsProperty(){
        val ctx= new ClassPathXmlApplicationContext("conf/beans.xml") ;
        val bprop = ctx.getBean("bprop", IBeanWorker.class);
        bprop.doTheWork();
        ctx.close();
    }
}

