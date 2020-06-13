package com.login.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //设置swagger跨域，提供给service调用


    @Bean
    public Docket docket(Environment environment){
/*        //设置要显示的生产环境
        Profiles profiles = Profiles.of("pro");
        //获得环境
        boolean flag = environment.acceptsProfiles(profiles);
        System.out.println(flag);*/
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //RequestHandlerSelectors配置接口扫描的方式
                //basePackage("com.login.controller")指定扫描的包
                //withClassAnnotation()扫描类上注解
                //withMethodAnnotation()扫描方法上注解
                .apis(RequestHandlerSelectors.basePackage("com.login.controller"))
                //paths过滤路径
                .paths(PathSelectors.any()).build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfo(
                //描述
                "Swagger",
                "接口",
                "1.0",
                "locahost",
                //作者信息
                new Contact(
                        "陈先绪",
                        "localhost",
                        "398384209@qq.com"),
                        "1",
                        "1",
                new ArrayList());
    }
}
