package cn.name.service;

import cn.name.dao.RegisterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Nominal on 2017/12/28 0028.
 * 微博：@李明易DY
 */
@Service
public class RegisterService {
    @Autowired
    RegisterDao registerDao;

    public void doRegister(String name){
        int rendomSleepTime = (int) (Math.random()*5000);
        try{
            Thread.sleep(rendomSleepTime);

        }catch(InterruptedException e){
            e.printStackTrace();
        }

        registerDao.saveUser(name);

    }
}
