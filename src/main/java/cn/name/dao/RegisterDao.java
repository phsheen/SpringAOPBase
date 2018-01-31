package cn.name.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by Nominal on 2017/12/28 0028.
 * 微博：@李明易DY
 */
@Repository
public class RegisterDao {
    public void saveUser(String name){
        System.out.println("插入信息为："+name);
        System.out.println("用户信息已保存！");
    };
}
