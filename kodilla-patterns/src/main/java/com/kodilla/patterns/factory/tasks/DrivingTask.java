package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task {

    private String taskName;
    private String where;
    private String using;
    private boolean isExecuted = false;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public String executeTask() {
        isExecuted = true;
        return "taken  to " + where + " by " + using;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public Boolean isTaskExecuted() {
        return isExecuted;
    }
}
