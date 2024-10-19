package org.example.nonrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class NonRestApp
{
    private static Logger log = LoggerFactory.getLogger(NonRestApp.class);
    public static void main( String[] args )
    {
        SpringApplication.run(NonRestApp.class, args);
    }


    @Bean //It allows you to explicitly define a bean in a Spring configuration class. giving you fine-grained control over your beans
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

}
