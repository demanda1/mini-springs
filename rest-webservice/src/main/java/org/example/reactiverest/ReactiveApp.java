package org.example.reactiverest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//Not working
@SpringBootApplication
public class ReactiveApp {
    public static void main(String[] args) {
        SpringApplication.run(ReactiveApp.class, args);
        // We need to block for the content here or the JVM might exit before the message is logged
        //System.out.println(">> message = " + greetingClient.getMessage().block());
    }
}
