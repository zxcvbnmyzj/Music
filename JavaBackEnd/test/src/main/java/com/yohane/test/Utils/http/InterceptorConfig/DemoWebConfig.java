package com.yohane.test.Utils.http.InterceptorConfig;

import com.yohane.test.service.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created on 2023/4/13
 *
 * @Time 15:49
 * @Program test
 * @Author YoHaNe/XiaoShuai
 */
@Configuration
public class DemoWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/**");//放行路径
    }
}
