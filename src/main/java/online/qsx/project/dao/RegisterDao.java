package online.qsx.project.dao;

import org.springframework.stereotype.Repository;

// 数据持久化类
@Repository
public class RegisterDao {
	public void saveUser(String userName){
		System.out.println("插入信息为："+userName);
		System.out.println("用户信息已被保存！");
	}
}
