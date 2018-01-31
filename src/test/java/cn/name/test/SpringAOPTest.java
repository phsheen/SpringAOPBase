package cn.name.test;

import cn.name.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Nominal on 2018/1/3 0003.
 * 微博：@李明易DY
 */
@Component
public class SpringAOPTest {
    @Autowired
    private  RegisterService registerService;
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"classpath:applicationContext.xml"});
        SpringAOPTest rService = ctx.getBean(SpringAOPTest.class);
        rService.testR();
        ((ClassPathXmlApplicationContext) ctx).close();
    }
    public void testR(){
        registerService.doRegister("你的名字");
    }
}
