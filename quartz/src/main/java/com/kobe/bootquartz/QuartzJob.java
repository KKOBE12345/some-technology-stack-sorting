package com.kobe.bootquartz;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @program: AllPrpject
 * @description
 * @author: George
 * @create: 2022-05-08 22:47
 **/
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class QuartzJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        try {
            Thread.sleep(2000);
            System.out.println(context.getScheduler().getSchedulerInstanceId());

            System.out.println("taskname="+context.getJobDetail().getKey().getName());
            System.out.println("执行时间="+new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
