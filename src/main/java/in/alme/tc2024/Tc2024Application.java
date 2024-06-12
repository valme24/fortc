package in.alme.tc2024;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@SpringBootApplication
public class Tc2024Application {

    public static void main(String[] args) {
        SpringApplication.run(Tc2024Application.class, args);
    }
    @Bean
    public Docket swaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/cloudvendor/*"))
                .apis(RequestHandlerSelectors.basePackage("in.alme.tc2024"))
                .build()
                .apiInfo(apiCustomData());
    }

    private ApiInfo apiCustomData(){
        return new ApiInfo(
                "Cloud Vendor API Application",
                "Cloud Vendor Documentation",
                "1.0",
                "Cloud Vendor Service Terms",
                new Contact("Esha Puri", "http://thinkconstructive.com",
                        "contact@thinkconstructive.com"),
                "Think Constructive License",
                "http://thinkconstructive.com",
                Collections.emptyList()
        );
    }
}
