package com.jiaxliu.lessonOne.controller;

import com.jiaxliu.lessonOne.entity.UserEntity;
import com.jiaxliu.lessonOne.jpa.UserJPA;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

/**
 * =====================================================
 *
 * @Created with Intellij IDEA 2017.2
 * @PROJECT lessonone
 * @PACKAGE com.jiaxliu.lessonOne.controller
 * @Author jiaxliu [ jiaxliu@outlook.com ]
 * @GitHub https://github.com/jiaxliu
 * @Date Aug 8/6/2017 09:26
 * <p>
 * <p>
 * =====================================================
 */

@RestController
@RequestMapping(value = "/user")
public class SignUpController {

    @Autowired
    UserJPA userJPA =null;
    @RequestMapping(value = "/sign-up")
    public String signUp(HttpServletRequest request, UserEntity userEntity) {

        String result="注册成功!";

        String username = request.getParameter("userName");
        String userFirstName = request.getParameter("first_name");
        String userLastName = request.getParameter("last_name");
        String gender = request.getParameter("option1");
        String userEmail = request.getParameter("userEmail");
        String password = request.getParameter("password");
        String password_confirm = request.getParameter("password_confirm");

        userEntity.setId(1234123l);
        userEntity.setUserFirstName(userFirstName);
        userEntity.setUserLastName(userLastName);
        userEntity.setUserName(username);
        userEntity.setUserGender("M");
        userEntity.setUserGender(gender);
        userEntity.setEmail(userEmail);
        userEntity.setUserPassword(password);

    //    if (!password.equals(password_confirm))
       //     return "密码不一致!";



            userJPA.save(userEntity);

        System.out.println("---"+userFirstName+"---"+userLastName+
                "---"+username+
                "---"+userEmail+
                "---"+gender);

        return result;

}}
