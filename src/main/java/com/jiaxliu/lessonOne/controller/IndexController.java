package com.jiaxliu.lessonOne.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("/user")
public class IndexController {
    /**
     * 返回resources/templates/sign-in-view
     * 初始化登录界面
     * @return
     */

    @RequestMapping(value = "/sign-in-view", method = RequestMethod.GET)
    public String signInView(){
        return "sign-in";
    }
    @RequestMapping(value = "/sign-up-view", method = RequestMethod.GET)
    public String signUpView(){ return "sign-up"; }
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "index";
    }
    @RequestMapping(value = "/list-view", method = RequestMethod.GET)
    public String listView(){return "list";}


}
