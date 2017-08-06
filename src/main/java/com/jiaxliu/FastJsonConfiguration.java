package com.jiaxliu;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * =====================================================
 *
 * @Created with Intellij IDEA 2017.2
 * @PROJECT lessonone
 * @PACKAGE com.jiaxliu
 * @Author jiaxliu [ jiaxliu@outlook.com ]
 * @GitHub https://github.com/jiaxliu
 * @Date Aug 8/5/2017 14:16
 * <p>
 * <p>
 * =====================================================
 */

@Configuration
public class FastJsonConfiguration extends WebMvcConfigurerAdapter{
    /**
     *
     * 修改自定义消息转换器
     * @Param converters 消息转换器列表
     *
     *
     */

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        //调用父类的配置
        super.configureMessageConverters(converters);

        //创建fastjson消息转换器
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter =new FastJsonHttpMessageConverter();

        //创建配置类
        FastJsonConfig fastJsonConfig = new FastJsonConfig();

        //修改配置返回内容的过滤
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue

                //SerializerFeature.UseSingleQuotes
               // SerializerFeature.WriteNullStringAsEmpty
        );

        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        //将fastJson添加到视图消息转换器列表内
        converters.add(fastJsonHttpMessageConverter);

    }

}
