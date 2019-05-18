package com.kodilla.patterns.strategy.social;

public class User {
    final private String name;


    protected SocialPublisher socialPublisher;


    public User(String name) {
        this.name = name;
    }
    public String sharePost() {

        return "Post was published in " + socialPublisher.share();

    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }

}
