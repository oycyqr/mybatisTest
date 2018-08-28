package cn.com.bestoyc.test;

import cn.com.bestoyc.dao.UserDao;
import cn.com.bestoyc.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * @author oyc
 * @Title:
 * @Description:
 * @date 2018/7/2815:17
 */
public class HelloMyBatis {
    public static void main(String[] args) {
        //1. 声明配置文件的目录
        String resource = "mybatis-config.xml";
        SqlSessionFactory sqlSessionFactory = null;
        Reader reader;
        try {
            //2. 加载应用配置文件
            reader = Resources.getResourceAsReader(resource);
            // 3. 创建SqlSessonFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Configuration conf = sqlSessionFactory.getConfiguration();
        conf.addMapper(UserDao.class);
        // 4. 获取Session
        SqlSession session = sqlSessionFactory.openSession();
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
