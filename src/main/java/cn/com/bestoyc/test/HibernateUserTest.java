package cn.com.bestoyc.test;

import cn.com.bestoyc.dao.UserBaseDao;
import cn.com.bestoyc.entity.User;

/**
 * @author oyc
 * @Title:
 * @Description:
 * @date 2018/7/3022:18
 */
public class HibernateUserTest {
    public static void main(String[] args) {
        new HibernateUserTest().test();
    }
   public void test(){
       UserBaseDao ub = new UserBaseDao();
       ub.getById(User.class,"1");
       System.out.println("asdfasdfasdfadsf");
   }
}
