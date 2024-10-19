package org.example.reactiverest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

//Not working
@Component
public class GreetingHandler {

    /*
     * A Mono is a reactive type that represents a single asynchronous computation
     * ServerResponse represents the HTTP response.
     * method takes and incoming HTTP request as parameter.
     * BodyInserters utility to create a response body with the given value.
     * Reactive Programming: Using Mono for asynchronous and non-blocking operations.
     * Spring WebFlux: The code is part of a Spring WebFlux application, which supports reactive web applications.
     * Fluent API: Using method chaining to build the response in a readable and concise manner.
     * JSON Response: Sets the response content type to JSON and includes a JSON object in the body.
     *
     */

    public Mono<ServerResponse> hello2(ServerRequest request){
         return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new Greeting("Hello Reactive App")));
    }

    public HandlerFunction<ServerResponse> hello() {
        return request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new Greeting("Hello, Spring!")));
    }

}
