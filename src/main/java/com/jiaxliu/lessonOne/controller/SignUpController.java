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
    UserJPA userJPA;

    @RequestMapping(value = "/sign-up")
    public boolean signUp(UserEntity user) {
        boolean flag = true;
        //根据用户名查询用户是否存在
        UserEntity userEntity = userJPA.findOne(new Specification<UserEntity>() {
            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.where(criteriaBuilder.equal(root.get("name"), user.getName()));
                return null;
            }
        });
        //用户名不存在
        if (userEntity == null){

            userJPA.save(user);

            return true;

        }else
            return false;

    }

}
