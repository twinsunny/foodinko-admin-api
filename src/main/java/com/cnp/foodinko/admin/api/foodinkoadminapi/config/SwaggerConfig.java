package com.cnp.foodinko.admin.api.foodinkoadminapi.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // 스웨거 사이트 설명
    private ApiInfo swaggerInfo() {
        return new ApiInfoBuilder().title("foodinko API Documentation")
                .description("푸딘코 어드민 API swagger")
                .license("").licenseUrl("").version("1.0").build();
    }

    // 스웨거 빈 등록
    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(swaggerInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.cnp.foodinko.admin.api.foodinkoadminapi.controller"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET,
                        newArrayList(new ResponseMessageBuilder()
                                        .code(500)
                                        .message("Internal Server Error")
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(400)
                                        .message("Bad Request")
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(404)
                                        .message("Not Found")
                                        .build()));
    }


}
