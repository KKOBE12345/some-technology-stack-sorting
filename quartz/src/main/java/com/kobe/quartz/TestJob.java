package com.kobe.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


/**
 * @program: AllPrpject
 * @description
 * @author: George
 * @create: 2022-05-08 20:43
 **/
public class TestJob {
    public static void main(String[] args) {
        //将Job包装成一个JobDetail
        JobDetail jobDetail= JobBuilder.newJob(MyJob.class)
                .withIdentity("job1","group1")
                .usingJobData("job","jobDetail1")
                .usingJobData("name","kobe123")
                .usingJobData("count1",0)
                .build();

        //创建触发器
        int count=0;
        Trigger trigger= TriggerBuilder.newTrigger()
                .withIdentity("trigger1","group1")
                .usingJobData("trigger","trigger")
                .usingJobData("count",count)
//                .usingJobData("name","james123")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever())
                .build();

        //创建控制器
        try {
            Scheduler scheduler= StdSchedulerFactory.getDefaultScheduler();
            scheduler.scheduleJob(jobDetail,trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
