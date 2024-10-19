package org.example.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AsyncRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(AsyncRunner.class);

    private final GithubLookupService githubLookupService;

    public AsyncRunner(GithubLookupService githubLookupService) {
        this.githubLookupService = githubLookupService;
    }

    @Override
    public void run(String... args) throws Exception {
        long start = System.currentTimeMillis();

        CompletableFuture<User> page1 = githubLookupService.findUser("demanda1");
        CompletableFuture<User> page2 = githubLookupService.findUser("CloudFoundry");
        CompletableFuture<User> page3 = githubLookupService.findUser("Spring-Projects");

        CompletableFuture.allOf(page1, page2, page3).join();

        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        logger.info("--> " + page1.get());
        logger.info("--> " + page2.get());
        logger.info("--> " + page3.get());

    }
}
