package br.com.project.rest.cashback.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.project.rest.cashback.resources"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .globalResponseMessage(RequestMethod.GET, mensagensRespostaGet());
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Bem vindo ao Beblue CashBack API")
                .description("Projeto de uma API REST em Java (Spring Framework) referente ao teste técnico para desenvolvedor java na Fintech Beblue.")
                .version("0.0.1")
                .contact(new Contact("Hugo Gois", "gudshugo@gmail.com"))
                .build();
    }
    
    private List<ResponseMessage> mensagensRespostaGet() {
        
        List<ResponseMessage> listaErros = new ArrayList<>();
        listaErros.add(new ResponseMessageBuilder()
                .code(500)
                .message("Algo inesperado ocorreu no servidor.")
                .build());
        listaErros.add(new ResponseMessageBuilder()
                .code(403)
                .message("Acesso não permitido, acesse a rota /login passando username e password e envie o token na header da requisição.")
                .build());
        
        return listaErros;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
