package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TestStatisticCalculation {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeClass() {

        System.out.println("Test Suite: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }

    @Before
    public void before() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @After
    public void after() {
        System.out.println("success");
    }

    @Test
    public void testCalculateAdvStatisticsWhenIsNoPost() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCalculation statisticsCalculation = new StatisticsCalculation();
        int numberOfPost = 0;
        int numberOfComments = 0;
        List<String> userList = new ArrayList<>();
        userList.add("Tom");
        userList.add("John");
        userList.add("Paul");
        when(statisticsMock.usersNames()).thenReturn(userList);
        when(statisticsMock.postsCount()).thenReturn(numberOfPost);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);

        //When
        statisticsCalculation.calculateAdvStatistics(statisticsMock);
        double averageUserPost = statisticsCalculation.getAverageUserPost();
        double averageUserComments = statisticsCalculation.getAverageUserComments();
        double averagePostComments = statisticsCalculation.getAveragePostComments();

        //Then
        Assert.assertEquals(0, averageUserPost, 0);
        Assert.assertEquals(0, averageUserComments, 0);
        Assert.assertEquals(0, averagePostComments, 0);
    }

    @Test
    public void testCalculateAdvStatisticsWhenIs1000Posts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCalculation statisticsCalculation = new StatisticsCalculation();
        int numberOfPost = 1000;
        int numberOfComments = 0;
        List<String> userList = new ArrayList<>();
        userList.add("Tom");
        userList.add("John");
        when(statisticsMock.usersNames()).thenReturn(userList);
        when(statisticsMock.postsCount()).thenReturn(numberOfPost);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);

        //When
        statisticsCalculation.calculateAdvStatistics(statisticsMock);
        double averageUserPost = statisticsCalculation.getAverageUserPost();
        double averageUserComments = statisticsCalculation.getAverageUserComments();
        double averagePostComments = statisticsCalculation.getAveragePostComments();
        //Then
        Assert.assertEquals(500, averageUserPost, 0);
        Assert.assertEquals(0, averageUserComments, 0);
        Assert.assertEquals(0, averagePostComments, 0);
    }

    @Test
    public void testCalculateAdvStatisticsWhenIsNoComments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCalculation statisticsCalculation = new StatisticsCalculation();
        int numberOfPost = 500;
        int numberOfComments = 0;
        List<String> userList = new ArrayList<>();
        userList.add("Tom");
        userList.add("John");
        when(statisticsMock.usersNames()).thenReturn(userList);
        when(statisticsMock.postsCount()).thenReturn(numberOfPost);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);

        //When
        statisticsCalculation.calculateAdvStatistics(statisticsMock);
        double averageUserPost = statisticsCalculation.getAverageUserPost();
        double averageUserComments = statisticsCalculation.getAverageUserComments();
        double averagePostComments = statisticsCalculation.getAveragePostComments();

        //Then
        Assert.assertEquals(250, averageUserPost, 0);
        Assert.assertEquals(0, averageUserComments, 0);
        Assert.assertEquals(0, averagePostComments, 0);
    }

    @Test
    public void testCalculateAdvStatisticsWhenIsMorePostsThenComments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCalculation statisticsCalculation = new StatisticsCalculation();
        int numberOfPost = 10;
        int numberOfComments = 6;
        List<String> userList = new ArrayList<>();
        userList.add("Tom");
        userList.add("John");
        when(statisticsMock.usersNames()).thenReturn(userList);
        when(statisticsMock.postsCount()).thenReturn(numberOfPost);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);

        //When
        statisticsCalculation.calculateAdvStatistics(statisticsMock);
        double averageUserPost = statisticsCalculation.getAverageUserPost();
        double averageUserComments = statisticsCalculation.getAverageUserComments();
        double averagePostComments = statisticsCalculation.getAveragePostComments();

        //Then
        Assert.assertEquals(5, averageUserPost, 0);
        Assert.assertEquals(3, averageUserComments, 0);
        Assert.assertEquals(0.6, averagePostComments, 0);
    }

    @Test
    public void testCalculateAdvStatisticsWhenIsMorCommentsThenPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCalculation statisticsCalculation = new StatisticsCalculation();
        int numberOfPost = 10;
        int numberOfComments = 20;
        List<String> userList = new ArrayList<>();
        userList.add("Tom");
        userList.add("John");
        when(statisticsMock.usersNames()).thenReturn(userList);
        when(statisticsMock.postsCount()).thenReturn(numberOfPost);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);

        //When
        statisticsCalculation.calculateAdvStatistics(statisticsMock);
        double averageUserPost = statisticsCalculation.getAverageUserPost();
        double averageUserComments = statisticsCalculation.getAverageUserComments();
        double averagePostComments = statisticsCalculation.getAveragePostComments();

        //Then
        Assert.assertEquals(5, averageUserPost, 0);
        Assert.assertEquals(10, averageUserComments, 0);
        Assert.assertEquals(2, averagePostComments, 0);
    }

    @Test
    public void testCalculateAdvStatisticsWhenIsNoUser() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCalculation statisticsCalculation = new StatisticsCalculation();
        int numberOfPost = 10;
        int numberOfComments = 20;
        List<String> userList = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(userList);
        when(statisticsMock.postsCount()).thenReturn(numberOfPost);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);

        //When
        statisticsCalculation.calculateAdvStatistics(statisticsMock);
        double averageUserPost = statisticsCalculation.getAverageUserPost();
        double averageUserComments = statisticsCalculation.getAverageUserComments();
        double averagePostComments = statisticsCalculation.getAveragePostComments();

        //Then
        Assert.assertEquals(0, averageUserPost, 0);
        Assert.assertEquals(0, averageUserComments, 0);
        Assert.assertEquals(0, averagePostComments, 0);
    }

    @Test
    public void testCalculateAdvStatisticsWhenIs100User() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCalculation statisticsCalculation = new StatisticsCalculation();

        int numberOfPost = 10;
        int numberOfComments = 20;
        List<String> userList = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            userList.add("Adam");

        when(statisticsMock.usersNames()).thenReturn(userList);
        when(statisticsMock.postsCount()).thenReturn(numberOfPost);
        when(statisticsMock.commentsCount()).thenReturn(numberOfComments);

        //When

        statisticsCalculation.calculateAdvStatistics(statisticsMock);
        double averageUserPost = statisticsCalculation.getAverageUserPost();
        double averageUserComments = statisticsCalculation.getAverageUserComments();
        double averagePostComments = statisticsCalculation.getAveragePostComments();

        //Then
        Assert.assertEquals(0.1, averageUserPost, 0);
        Assert.assertEquals(0.2, averageUserComments, 0);
        Assert.assertEquals(2, averagePostComments, 0);
    }
}
