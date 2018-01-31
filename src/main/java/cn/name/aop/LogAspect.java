package cn.name.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Nominal on 2017/12/29 0029.
 * 微博：@李明易DY
 */
@Component
@Aspect  //切面
public class LogAspect {

    //切入点
    @Pointcut(value="execution(public * cn.name.service.*.*(..))")
    public void myPointCut() {

    }

    //前置增强
    @Before(value="execution(public * cn.name.dao.*.*(..))")
    public void myBefore(JoinPoint joinPoint) {
        System.out.println("前置增强");
        System.out.println(joinPoint.getSignature()+"方法被调用");
    }

    //后置增强
    @After(value="myPointCut()")
    public void myAfter(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature());
        System.out.println("后置增强");
    }

    //环绕增强
    @Around(value="myPointCut()")
    public void timeAround(ProceedingJoinPoint pJoinPoint) throws Throwable{
        long beginTime = System.nanoTime();
        Object object = pJoinPoint.proceed();
        long endTime = System.nanoTime();
        System.out.println("运行时间为:"+(float)(endTime-beginTime)/1000000000.0+"秒");
    }
}
