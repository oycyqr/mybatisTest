package cn.com.bestoyc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author oyc
 * @Description: 用户实体类
 * @date 2018/7/2815:06
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    private String id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String passWord;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
