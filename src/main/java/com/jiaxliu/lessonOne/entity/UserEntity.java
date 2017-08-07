package com.jiaxliu.lessonOne.entity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;

/**
 * =====================================================
 *
 * @Created with Intellij IDEA 2017.2
 * @PROJECT lessonone
 * @PACKAGE com.jiaxliu.lessonOne.entity
 * @Author jiaxliu [ jiaxliu@outlook.com ]
 * @GitHub https://github.com/jiaxliu
 * @Date Aug 8/5/2017 10:35
 * <p>
 * <p>
 * =====================================================
 */
@Entity
@Table(name = "tb_lessonone")
public class UserEntity implements Serializable{

   @Id
   @GeneratedValue
   @Column(name = "t_id")
    private Long id;

   @Column(name = "t_name")
    private String userName;

   @Column(name = "t_age")
    private int age;

   @Column(name = "t_email")
    private String email;

   @Column(name = "t_pwd")
    private String userPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
