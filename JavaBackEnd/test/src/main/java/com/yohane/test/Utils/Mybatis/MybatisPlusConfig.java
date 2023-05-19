package com.yohane.test.Utils.Mybatis;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created on 2023/4/16
 *
 * @Time 1:14
 * @Program test
 * @Author YoHaNe/XiaoShuai
 */
@Configuration
@MapperScan("com.yohane.test.dao.mybatis.*")
public class MybatisPlusConfig implements WebMvcConfigurer {

    @Bean
    public PaginationInterceptor paginationInnerInterceptor(){
        PaginationInterceptor innerInterceptor =
                new PaginationInterceptor();
        innerInterceptor.setOverflow(false);
        innerInterceptor.setLimit(500);
        innerInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return innerInterceptor;
    }




}
