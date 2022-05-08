package com.kobe.quartz;

import org.quartz.*;

/**
 * @program: AllPrpject
 * @description
 * @author: George
 * @create: 2022-05-08 20:42
 **/

//这个注解可以禁止同一个Job的任务并发执行   一般我们都会加上这个注解 防止同一个Job并发执行
@DisallowConcurrentExecution
//下面这个注解可以将JobDataMap进行持久化
@PersistJobDataAfterExecution
public class MyJob implements Job {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
//        System.out.println("我的工作终于开始了！！！！"+new Date());
//        JobDataMap jobDetailMap = context.getJobDetail().getJobDataMap();
//        JobDataMap triggerMap = context.getTrigger().getJobDataMap();
//        JobDataMap mergeMap = context.getMergedJobDataMap();
//        System.out.println("嘿嘿嘿"+"jobDetailMap---"+jobDetailMap.getString("job"));
//        System.out.println("哈哈哈"+"triggerMap---"+mergeMap.getString("trigger"));
//        System.out.println("嘻嘻嘻"+"mergeMap---"+mergeMap.getString("trigger"));

//        System.out.println("这边定义的名字是"+name);



        //每次执行的任务其实都是不一样的对象
//        System.out.println("jobDetail---"+System.identityHashCode(context.getJobDetail()));
//        System.out.println("job---"+System.identityHashCode(context.getJobInstance()));

        //接下来演示怎么进行的并发执行  同一个JOB每次执行的任务其实都不一样 因此可以进行并发执行
//        System.out.println("哈哈哈哈哈哈execute---"+new Date());
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //TriggerDetail中的持久化是没有效果的  只有JobDataDetail中的持久化有效果
        JobDataMap triggerMap = context.getTrigger().getJobDataMap();
        triggerMap.put("count", triggerMap.getInt("count")+1);
        System.out.println("triggerMap============="+triggerMap.getInt("count"));
        //只有JobDataDetail中的持久化有效果
        JobDataMap jobDetailMap = context.getJobDetail().getJobDataMap();
        jobDetailMap.put("count1", jobDetailMap.getInt("count1")+1);
        System.out.println("JObDataMap++++++-----"+jobDetailMap.getInt("count1"));



    }
}
