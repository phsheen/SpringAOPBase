package online.qsx.project.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import online.qsx.project.service.RegisterService;

@Component
public class SpringAOPTest {

	@Autowired
	private RegisterService registerService;

	public static void main(String[] args) {
		// ��ʼ�� ApplicationContext
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:applicationContext.xml" });

		SpringAOPTest aopTest = context.getBean(SpringAOPTest.class);
		aopTest.testRegister();
		// �ر� ApplicationContext
		((ClassPathXmlApplicationContext) context).close();
	}

	// ����ע��������е� doRegister����
	public void testRegister() {
		registerService.doRegister("��ʵѵ");
	}
}
