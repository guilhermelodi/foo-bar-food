package br.com.foobarfood.foodadministrative.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Controller
@Configuration
@EnableSwagger2
class SwaggerConfiguration {

    @Bean
    fun api(): Docket = Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("br.com.foobarfood.foodadministrative.controller"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(metaData())

    private fun metaData() = ApiInfoBuilder()
                .title("Administrative - Api Documentation")
                .build()

    @GetMapping("/")
    fun index() = "redirect:swagger-ui.html"

}