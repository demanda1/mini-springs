package org.example.reactiverest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

//Not working
@Configuration
public class GreetingRouter {

    @Bean
    public RouterFunction<ServerResponse> route2(GreetingHandler greetingHandler){
        return RouterFunctions.route().GET("/hello2", greetingHandler::hello2)
                .GET("/routes", request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(getRegisteredRoutes())))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
        return RouterFunctions
                .route(GET("/hello"), greetingHandler::hello2);
    }

    private List<String> getRegisteredRoutes() {
        // Add your routes manually here or use a dynamic approach to fetch them
        return Arrays.asList("/hello", "/routes");
    }
}
