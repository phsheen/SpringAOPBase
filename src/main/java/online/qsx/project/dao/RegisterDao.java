package online.qsx.project.dao;

import org.springframework.stereotype.Repository;

// ���ݳ־û���
@Repository
public class RegisterDao {
	public void saveUser(String userName){
		System.out.println("������ϢΪ��"+userName);
		System.out.println("�û���Ϣ�ѱ����棡");
	}
}
