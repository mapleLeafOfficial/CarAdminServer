package com.yeqifu.sys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@WebAppConfiguration

@EnableSwagger2

@EnableWebMvc

@ComponentScan(basePackages = "com.yeqifu.stat.controller")

public class SwaggerConfig {

    @Bean

    public Docket customDocket() {

        //

        return new Docket(DocumentationType.SWAGGER_2)

                .select()

                .apis(RequestHandlerSelectors.any())

                .build()

                .apiInfo(apiInfo());

    }



    private ApiInfo apiInfo() {

        Contact contact = new Contact("娜", "https://www.baidu.me", "baidu666@icloud.com");

        return new ApiInfo("API接口",//大标题 title

                "Swagger测试demo",//小标题

                "0.0.1",//版本

                "www.baidu.com",//termsOfServiceUrl

                "contact",//作者

                "Blog",//链接显示文字

                "https://www.baidu.me"//网站链接

        );

    }





}