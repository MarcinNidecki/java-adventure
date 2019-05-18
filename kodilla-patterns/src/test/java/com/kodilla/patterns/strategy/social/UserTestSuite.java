package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publisher.FacebookPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test

    public void testDefaultSharingStrategies() {

        User tom = new Millenials("Tom");
        User john = new YGeneration("John");
        User steven = new ZGeneration("Steven");

        String tomSocial = tom.sharePost();
        String johnSocial = john.sharePost();
        String stevenSocial = steven.sharePost();

        Assert.assertEquals("Post was published in Snapchat.",tomSocial);
        Assert.assertEquals("Post was published in Twitter.",johnSocial);
        Assert.assertEquals("Post was published in Facebook.",stevenSocial);

    }
    @Test
    public  void testIndividualSharingStrategy() {
        User tom = new Millenials("Tom");
        System.out.println(tom.sharePost());

        tom.setSocialPublisher(new FacebookPublisher());
        String tomSocial = tom.sharePost();
        System.out.println(tom.sharePost());
        Assert.assertEquals("Post was published in Facebook.",tomSocial);

    }
}
