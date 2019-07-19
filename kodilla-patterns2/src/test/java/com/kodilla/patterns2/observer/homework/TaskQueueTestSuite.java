package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaskQueueTestSuite {
    @Test
    public void  testUpdate() {
        //Given
        TaskQueue backendTaskQueue = new BackendTaskQueue();
        TaskQueue frontendTaskQueu = new FrontendTaskQueue();
        Mentor johnSmith = new Mentor("John Smith");
        Mentor ivoneEscobar = new Mentor("Ivone Escobar");
        Student jessiePinman = new Student("Jessie Pinkman", 1);
        Student frankMiller = new Student("Frank Miller", 2);
        Task task1 = new Task("Task nr 1",jessiePinman);
        Task task2 = new Task("Task nr 2",frankMiller);
        Task task3 = new Task("Task nr 3",jessiePinman);
        backendTaskQueue.registerObserver(johnSmith);
        backendTaskQueue.registerObserver(ivoneEscobar);
        frontendTaskQueu.registerObserver(ivoneEscobar);

        //When
        backendTaskQueue.addTask(task1);
        frontendTaskQueu.addTask(task2);
        backendTaskQueue.addTask(task3);

        //Them
        assertEquals(2,johnSmith.getUpdateCount());
        assertEquals(3,ivoneEscobar.getUpdateCount());

    }
}
