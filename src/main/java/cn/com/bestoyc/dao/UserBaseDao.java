package cn.com.bestoyc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * @author oyc
 * @Title:
 * @Description:
 * @date 2018/7/3022:33
 */

@Repository
@Transactional
public class UserBaseDao extends HibernateDaoSupport {

    private HibernateTemplate getTemplate() {
        return this.getHibernateTemplate();
    }

    /**
     * 将sessionFactory注入到dao的超类的SessionFactory属性当中
     */
    @Autowired
    private SessionFactory sessionFactory;

    @PostConstruct
    public void setSessionFactory() {
        super.setSessionFactory(sessionFactory);
    }


    public <T> T getById(Class<T> clazz, String id) throws DataAccessException {
        T entity = null;
        try {
            HibernateTemplate template = this.getHibernateTemplate();
            entity = template.get(clazz, id);
        } catch (DataAccessException e) {
            throw e;
        }
        return entity;
    }
}
