package cn.com.bestoyc.test;

import cn.com.bestoyc.dao.UserDao;
import cn.com.bestoyc.entity.User;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author oyc
 * @Title:
 * @Description:
 * @date 2018/7/2815:17
 */
public class HelloMyBatisTest {

    public static void main(String[] args) {
        // 1. 声明配置⽂文件的⺫⽬目录渎职
        String resource = "mybatis-config.xml";
        // 2. 加载应⽤用配置⽂文件
        InputStream is = HelloMyBatisTest.class.getClassLoader() .getResourceAsStream(resource);
        // 3. 创建SqlSessonFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        Configuration conf = sessionFactory.getConfiguration();
        conf.addMapper(UserDao.class);
        // 4. 获取Session
        SqlSession session = sessionFactory.openSession();
        try {
            // 5. 获取操作类
            UserDao userDao = session.getMapper(UserDao.class);
            // 6. 完成查询操作
            User user = userDao.getUserInfoById("1");
            System.out.println(user.getId() + " " + user.getUserName());
        } finally {
            // 7.关闭Session
            session.close();
        }
    }
}
