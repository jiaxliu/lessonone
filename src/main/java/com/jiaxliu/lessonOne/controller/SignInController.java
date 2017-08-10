package com.jiaxliu.lessonOne.controller;

import com.jiaxliu.lessonOne.entity.UserEntity;
import com.jiaxliu.lessonOne.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * =====================================================
 *
 * @Created with Intellij IDEA 2017.2
 * @PROJECT lessonone
 * @PACKAGE com.jiaxliu.lessonOne.controller
 * @Author jiaxliu [ jiaxliu@outlook.com ]
 * @GitHub https://github.com/jiaxliu
 * @Date Aug 8/5/2017 16:23
 * <p>
 * <p>
 * =====================================================
 */

@RestController
@RequestMapping(value = "/user")
public class SignInController {

    @Autowired
    UserJPA userJPA;

    @RequestMapping(value = "/sign-in")
    public String signIn(UserEntity user, HttpServletRequest request, HttpServletResponse response)
            throws Exception     {
        String result ="登录成功";

        boolean flag = true;
        //根据用户名查询用户是否存在
        UserEntity userEntity =  userJPA.findOne(new Specification<UserEntity>() {
            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.where(criteriaBuilder.equal(root.get("userName"),user.getUserName()));
                return null;
            }
        });
        System.out.println("----"+userEntity.getUserPassword()+"---"+user.getUserPassword());
        //用户名不存在
        if(userEntity==null){
            flag = false;
            result = "用户不存在,登录失败!";
        }

        //密码错误
        else if (!userEntity.getUserPassword().equals(user.getUserPassword())){
            flag = false;
            result = "用户密码不相符,登录失败";
        }
        //登录成功
        if(flag){
            //将用户写入session
         ///  request.getSession().setAttribute("_session_user",userEntity);
        }

        response.sendRedirect("/user/list-view");
        return result;


    }




}
