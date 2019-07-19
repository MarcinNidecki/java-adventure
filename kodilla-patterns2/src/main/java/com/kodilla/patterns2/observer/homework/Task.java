package com.kodilla.patterns2.observer.homework;

public class Task {
    private final String taskName;
    private final int userId;
    private final String studentName;

    public Task(String taskName, Student student) {
        this.taskName = taskName;
        this.userId = student.getStudentId();
        this.studentName = student.getStudentName();
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStudentName() {
        return studentName;
    }
}
