package com.kodilla.testing.forum.statistics;

public class StatisticsCalculation {

    Statistics statistics;
    int numberOfUsers;
    int numberOfPost;
    int numberOfComments;
    double averageUserPost;
    double averageUserComments;
    double averagePostComments;


    public void CalculateAdvStatistics(Statistics statistics) {
        if (statistics.usersNames().size() >0) {

            numberOfUsers = statistics.usersNames().size();
            numberOfPost = statistics.postsCount();        // total quantity of forum posts
            numberOfComments = statistics.commentsCount();
            averageUserPost = (double) statistics.postsCount() / statistics.usersNames().size();
            averageUserComments = (double) statistics.commentsCount() / statistics.usersNames().size();
            if (statistics.postsCount() > 0)
                averagePostComments = (double) statistics.commentsCount() / statistics.postsCount();
            else averagePostComments = 0;
        } else {
            numberOfUsers = 0;
            numberOfPost = 0;        // total quantity of forum posts
            numberOfComments =0;
            averageUserPost = 0;
            averageUserComments =0;
        }

    }

    public void showStatistic(){
        System.out.println("Number of forum users: " + numberOfUsers);
        System.out.println("Number of forum post: " + numberOfPost);
        System.out.println("Number of forum Comments: " + numberOfComments);
        System.out.println("The average number of user posts: " + averageUserPost);
        System.out.println("The average number of user comments: " + averageUserComments);
        System.out.println("Average number of comments per post: " + averagePostComments);
    }


}
