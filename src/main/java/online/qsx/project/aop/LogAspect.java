package online.qsx.project.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect // ����
public class LogAspect {

	// �����
	@Pointcut(value = "execution(public * online.qsx.project.service.*.*(..))")
	public void myPointCut() {
	}

	// ǰ����ǿ
	@Before(value = "execution(public * online.qsx.project.dao.*.*(..))")
	public void myBefore(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature() + "����������");
	}

	// ������ǿ
	@Around(value = "myPointCut()")
	public void timeAround(ProceedingJoinPoint pJoinPoint) throws Throwable {
		long beginTime = System.nanoTime();
		Object object = pJoinPoint.proceed();
		Long endTime = System.nanoTime();
		System.out.print(pJoinPoint.getSignature());
		System.out.println("����ʱ��Ϊ:" + (endTime - beginTime) / 1000000000 + "��");
	}
}
