package cn.com.bestoyc.test;

import cn.com.bestoyc.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * @author oyc
 * @Title:
 * @Description:
 * @date 2018/7/2815:17
 */
public class HelloHibernateTest {

    public static void main(String[] args) {
        // 1. 声明配置⽂文件的⺫⽬目录渎职
        String resource = "hibernate.xml";
        // 2. 加载应⽤用配置⽂文件
        Session session = new AnnotationConfiguration().configure("hibernate.xml").buildSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        User u = new User();
        u.setId("1001");
        u.setUserName("ouyangcheng");
        u.setPassWord("asdf");

        session.persist(u);

        t.commit();
        session.close();
        System.out.println("successfully saved");
    }
}
