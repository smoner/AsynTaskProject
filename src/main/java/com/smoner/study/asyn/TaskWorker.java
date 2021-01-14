package com.smoner.study.asyn;

import java.util.concurrent.Callable;

public class TaskWorker<ExecuteResult> implements Callable<ExecuteResult> {
    private TaskInfo taskInfo = null;
    public TaskWorker(TaskInfo taskInfo){
        this.taskInfo = taskInfo;
    }
    @Override
    public ExecuteResult call() throws Exception {
        Thread.sleep(100);
        System.out.println(taskInfo.getKey());
        return null;
    }
}
