package com.jiaxliu;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * =====================================================
 *
 * @Created with Intellij IDEA 2017.2
 * @PROJECT lessonone http://www.cnblogs.com/chry/p/5877979.html
 * @PACKAGE com.jiaxliu
 * @Author jiaxliu [ jiaxliu@outlook.com ]
 * @GitHub https://github.com/jiaxliu
 * @Date Aug 8/7/2017 12:17
 * <p>
 * <p>
 * =====================================================
 */
@Configuration
public class MyWebAppConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/myResource/**").addResourceLocations("classpath:/myResource/");
        super.addResourceHandlers(registry);
    }
}
