package org.example.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class GithubLookupService {

    private static final Logger logger = LoggerFactory.getLogger(GithubLookupService.class);

    @Autowired
    RestTemplate restTemplate;

    @Async
    public CompletableFuture<User> findUser(String user) throws InterruptedException {
        logger.info("Looking up " + user);
        String url = String.format("https://api.github.com/users/%s", user);
        User results = restTemplate.getForObject(url, User.class);
        Thread.sleep(1000);
        return CompletableFuture.completedFuture(results);
    }
}
