package com.smoner.study.asyn2;

import java.util.concurrent.*;

public class AsynExecutrorWithCompletionService {
    //线程池
    private final ExecutorService executorService;
    public AsynExecutrorWithCompletionService(ExecutorService executorService) {
        this.executorService = executorService;
    }
    public void execute(final Callable[] taskInfos) {
        CompletionService<ExecuteResult> completionService = new ExecutorCompletionService<ExecuteResult>(executorService);
        //为每个任务建立一个工作任务
        for (final Callable callable : taskInfos) {
            completionService.submit(callable);
        }
        try {
            for (int i = 0, n = taskInfos.length; i < n; i++){
                Future<ExecuteResult> imageFuture = completionService.take();
                ExecuteResult result = imageFuture.get();
                System.out.println("execute-successfull-:"+result.getMessage());
            }
        } catch (InterruptedException e) {
            System.out.println("com.yonyoucloud.upc.service.api.mcupdate.AsynExecutrorWithCompletionService.execute-error1:"+e.getMessage());
            // 如果发生中断异常则重新设置线程的中断状态
            // 这样做可以让wait中的线程唤醒
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            System.out.println("com.yonyoucloud.upc.service.api.mcupdate.AsynExecutrorWithCompletionService.execute-error2:"+e.getMessage());
        }finally {
            executorService.shutdown();
            System.out.println("all task is over !");
        }
    }
}
