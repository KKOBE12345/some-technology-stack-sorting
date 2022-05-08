package com.kobe.pool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: AllPrpject
 * @description
 * @author: George
 * @create: 2022-05-08 18:49
 **/
public class ScheduleThreadPoolTest {
    public static void main(String[] args) {
        //开启一个定时任务线程池
        ScheduledExecutorService scheduledThreadPool= Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 2; i++) {
            scheduledThreadPool.scheduleAtFixedRate(new Task("task-"+i), 0,2, TimeUnit.SECONDS);
        }
    }
}

class Task implements Runnable{

    private String name;

    public Task(String name) {
        this.name = name;
    }

    public void run() {
        try {
            System.out.println("name="+name+"startTime="+new Date());
            Thread.sleep(3000);
            System.out.println("name="+name+"endTime="+new Date());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
