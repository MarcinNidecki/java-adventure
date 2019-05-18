package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publisher.FacebookPublisher;

public class ZGeneration extends User {
    public ZGeneration(String name) {
        super(name);
        this.socialPublisher = new FacebookPublisher();
    }
}
