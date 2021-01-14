package com.smoner.study.asyn2;

import java.util.concurrent.Callable;

public class TaskWorker<ExecuteResult> implements Callable<ExecuteResult> {
    private final TaskInfo taskInfo ;
    public TaskWorker(TaskInfo taskInfo){
        this.taskInfo = taskInfo;
    }
    @Override
    public ExecuteResult call() throws Exception {
        String subOrgId = taskInfo.getSubOrgId();
        taskInfo.getExecuteResult().setMessage(subOrgId);
        return (ExecuteResult) taskInfo.getExecuteResult();
    }
}