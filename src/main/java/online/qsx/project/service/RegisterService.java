package online.qsx.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.qsx.project.aop.PerformanceAware;
import online.qsx.project.dao.RegisterDao;

// 服务类，处理业务逻辑
@Service
public class RegisterService {

	@Autowired
	private RegisterDao registerDao;

	@PerformanceAware
	public void doRegister(String userName) {
		int randomSleepTime = (int) (Math.random() * 5000);
		try {
			Thread.sleep(randomSleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		registerDao.saveUser(userName);
	}
}
