package com.smoner.study.asyn;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TaskTest {
    public static void main(String[] args) {
        try{
            List<TaskInfo> list = new ArrayList<>();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 100; i++) {
                TaskInfo info = new TaskInfo(String.valueOf("task--"+(i+1)));
                list.add(info);
            }
            System.out.println(Thread.currentThread().getName() + " load products info! "
                    + new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(new Date()));
            AsynExecutrorWithCompletionService cd = new AsynExecutrorWithCompletionService(Executors.newFixedThreadPool(2));
            cd.renderProductDetail(list);
        }catch (Exception e){
            System.out.println("----------error---------");
            System.out.println(e.getMessage());
        }
    }
}
