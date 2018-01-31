package online.qsx.project.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect // 切面
public class LogAspect {

	// 切入点
	@Pointcut(value = "execution(public * online.qsx.project.service.*.*(..))")
	public void myPointCut() {
	}

	// 前置增强
	@Before(value = "execution(public * online.qsx.project.dao.*.*(..))")
	public void myBefore(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature() + "方法被调用");
	}

	// 环绕增强
	@Around(value = "myPointCut()")
	public void timeAround(ProceedingJoinPoint pJoinPoint) throws Throwable {
		long beginTime = System.nanoTime();
		Object object = pJoinPoint.proceed();
		Long endTime = System.nanoTime();
		System.out.print(pJoinPoint.getSignature());
		System.out.println("运行时间为:" + (endTime - beginTime) / 1000000000 + "秒");
	}
}
