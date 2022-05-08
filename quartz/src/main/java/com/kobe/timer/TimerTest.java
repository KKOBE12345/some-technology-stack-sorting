package com.kobe.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @program: AllPrpject
 * @description
 * @author: George
 * @create: 2022-05-08 16:40
 **/
public class TimerTest {
    public static void main(String[] args) {
        Timer t = new Timer();//任务启动
        for (int i = 0; i < 2; i++) {
            FooTimerTask task = new FooTimerTask("FOO" + i);
//            t.schedule(task,new Date(),2000);
            t.scheduleAtFixedRate(task, new Date(),2000 );
            //schedule（）这边其实是任务的添加   这边两秒的是预设两秒任务执行的间隔
            //真正任务执行的时间是  上一个任务结束的时间
            //scheduleAtFixedRate()严格按照预设的时间去执行任务
            //在任务执行超时的时候
            //scheduleAtFixedRate会导致任务提前执行  schedule会导致丢任务
            //单线程 任务阻塞  任务超时

        }
    }
}

class FooTimerTask extends TimerTask{

    private String name;

    public FooTimerTask(String name) {
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
