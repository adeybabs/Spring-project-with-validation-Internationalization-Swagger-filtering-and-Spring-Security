package com.Swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Configuration file
//Enable Swagger
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //Bean - Docket
    //swagger 2
    //All the paths
    //All the apis

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2);
    }
}
