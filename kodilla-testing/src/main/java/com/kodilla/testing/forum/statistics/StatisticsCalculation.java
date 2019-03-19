package com.kodilla.testing.forum.statistics;

public class StatisticsCalculation {

    Statistics statistics;


    private int numberOfUsers;
    private int numberOfPost;
    private int numberOfComments;
    private double averageUserPost;
    private double averageUserComments;
    private double averagePostComments;


    public void calculateAdvStatistics(Statistics statistics) {
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
    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public int getNumberOfPost() {
        return numberOfPost;
    }

    public void setNumberOfPost(int numberOfPost) {
        this.numberOfPost = numberOfPost;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(int numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public double getAverageUserPost() {
        return averageUserPost;
    }

    public void setAverageUserPost(double averageUserPost) {
        this.averageUserPost = averageUserPost;
    }

    public double getAverageUserComments() {
        return averageUserComments;
    }

    public void setAverageUserComments(double averageUserComments) {
        this.averageUserComments = averageUserComments;
    }

    public double getAveragePostComments() {
        return averagePostComments;
    }

    public void setAveragePostComments(double averagePostComments) {
        this.averagePostComments = averagePostComments;
    }

}
