package com.kodilla.patterns2.observer.forum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ForumUserTestSuite {
    @Test
    public void  testUpdate() {
        //Given
        ForumTopic javaHelpFroum = new JavaHelpForumTopic();
        ForumTopic javaToolsForum = new JavaToolsForumTopic();
        ForumUser johnSmith = new ForumUser("John Smith");
        ForumUser ivoneEscobar = new ForumUser("Ivone Escobar");
        ForumUser jessiePinman = new ForumUser("Jessie Pinkman");
        javaHelpFroum.registerObserver(johnSmith);
        javaToolsForum.registerObserver(ivoneEscobar);
        javaHelpFroum.registerObserver(jessiePinman);
        javaToolsForum.registerObserver(jessiePinman);
        //When
        javaHelpFroum.addPost("Hi everyone! Could you help me with for loop?");
        javaHelpFroum.addPost("Better try use while loop in this case.");
        javaToolsForum.addPost("Help pls, my MySql db doesn't want to work :( ");
        javaHelpFroum.addPost("Why while? Is it better?");
        javaToolsForum.addPost("When I try to log in I got 'bad credentials' message.");
        //Them
        assertEquals(3,johnSmith.getUpdateCount());
        assertEquals(2,ivoneEscobar.getUpdateCount());
        assertEquals(5,jessiePinman.getUpdateCount());
    }
}
