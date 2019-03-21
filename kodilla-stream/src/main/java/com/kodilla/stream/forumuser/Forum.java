package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> forumUserList = new ArrayList<>();


    public void userForumList() {

        forumUserList.add(new ForumUser(1,"Tom",'M',2010,
                12,12,123));
        forumUserList.add(new ForumUser(2,"John",'M',1980,
                11,11,0));
        forumUserList.add(new ForumUser(3,"Paul",'M',1990,
                10,17,12));
        forumUserList.add(new ForumUser(4,"Mike",'M',2015,
                9,11,16));
        forumUserList.add(new ForumUser(5,"LittlePony",'F',2000,
                8,21,95));
        forumUserList.add(new ForumUser(6,"Unicorn",'M',2001,
                4,7,2));
        forumUserList.add(new ForumUser(7,"Cruz",'M',2018,
                1,26,13123));
        forumUserList.add(new ForumUser(8,"Lion",'F',1998,
                1,28,45));
        forumUserList.add(new ForumUser(9,"Cat",'F',1983,
                8,31,3541));


    }

    public List<ForumUser> getUserList() {
        return forumUserList;
    }




}
