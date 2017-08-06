package com.jiaxliu;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * =====================================================
 *
 * @Created with Intellij IDEA 2017.2
 * @PROJECT lessonone
 * @PACKAGE com.jiaxliu.lessonOne
 * @Author jiaxliu [ jiaxliu@outlook.com ]
 * @GitHub https://github.com/jiaxliu
 * @Date Aug 8/5/2017 16:56
 * <p>
 * <p>
 * =====================================================
 */

@Configuration
public class SessionConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
    }
}
