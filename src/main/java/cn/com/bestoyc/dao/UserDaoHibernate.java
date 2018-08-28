package cn.com.bestoyc.dao;

import cn.com.bestoyc.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author oyc
 * @Description: 用户dao
 * @date 2018/7/2815:14
 */
public interface UserDaoHibernate {
    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    public User getUserInfoById(String id);

}
