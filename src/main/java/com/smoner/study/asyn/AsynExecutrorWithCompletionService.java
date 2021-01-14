package com.smoner.study.asyn;

import java.util.List;
import java.util.concurrent.*;

public class AsynExecutrorWithCompletionService {

    //经过处理
    private final ResultExecuteService resultExecuteService;
    //线程池
    private final ExecutorService executorService;
    public AsynExecutrorWithCompletionService(ExecutorService executorService) {
        this(executorService,new DefaultResultExecuteService());
    }
    public AsynExecutrorWithCompletionService(ExecutorService executorService,ResultExecuteService resultExecuteService) {
        this.executorService = executorService;
        this.resultExecuteService=resultExecuteService;
    }

    public void renderProductDetail(final List<TaskInfo> TaskInfos) {
        CompletionService<ExecuteResult> completionService = new ExecutorCompletionService<ExecuteResult>(executorService);
        //为每个任务建立一个工作任务
        for (final TaskInfo info : TaskInfos) {
            completionService.submit(new TaskWorker<ExecuteResult>(info));
        }
        try {
            for (int i = 0, n = TaskInfos.size(); i < n; i++){
                Future<ExecuteResult> imageFuture = completionService.take();
                ExecuteResult result = imageFuture.get();
                resultExecuteService.executeResult(result);
            }
        } catch (InterruptedException e) {
            // 如果发生中断异常则重新设置线程的中断状态
            // 这样做可以让wait中的线程唤醒
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            try {
                throw new Throwable(e.getCause());
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }finally {
            executorService.shutdown();
            System.out.println("all task is over !");
        }
    }
}