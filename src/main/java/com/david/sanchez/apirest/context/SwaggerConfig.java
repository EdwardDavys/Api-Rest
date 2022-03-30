package com.david.sanchez.apirest.context;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.david.sanchez.apirest.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());


    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "Api-Rest",
                "Api de Gestión de tareas",
                "v1",
                "terminos de servicio",
                new Contact("David Eduardo Sanchez","https://github.com/EdwardDavys","desanchez08@gmail.com"),
                        "Licencia de Api","https://github.com/EdwardDavys", Collections.emptyList());

    }
}
