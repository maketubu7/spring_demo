package com.make.scheduler;

import com.make.common.EmailTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.security.auth.Subject;
import java.io.IOException;
import java.util.Random;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/8/27
 * Description:
 */
//（1）0 0 2 1 * ? *   表示在每月的1日的凌晨2点调整任务
//　　（2）0 15 10 ? * MON-FRI   表示周一到周五每天上午10:15执行作业
//　　（3）0 15 10 ? 6L 2002-2006   表示2002-2006年的每个月的最后一个星期五上午10:15执行作
//　　（4）0 0 10,14,16 * * ?   每天上午10点，下午2点，4点
//　　（5）0 0/30 9-17 * * ?   朝九晚五工作时间内每半小时
//　　（6）0 0 12 ? * WED    表示每个星期三中午12点
//　　（7）0 0 12 * * ?   每天中午12点触发
//　　（8）0 15 10 ? * *    每天上午10:15触发
//　　（9）0 15 10 * * ?     每天上午10:15触发
//　　（10）0 15 10 * * ? *    每天上午10:15触发
//　　（11）0 15 10 * * ? 2005    2005年的每天上午10:15触发
//　　（12）0 * 14 * * ?     在每天下午2点到下午2:59期间的每1分钟触发
//　　（13）0 0/5 14 * * ?    在每天下午2点到下午2:55期间的每5分钟触发
//　　（14）0 0/5 14,18 * * ?     在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
//　　（15）0 0-5 14 * * ?    在每天下午2点到下午2:05期间的每1分钟触发
//　　（16）0 10,44 14 ? 3 WED    每年三月的星期三的下午2:10和2:44触发
//　　（17）0 15 10 ? * MON-FRI    周一至周五的上午10:15触发
//　　（18）0 15 10 15 * ?    每月15日上午10:15触发
//　　（19）0 15 10 L * ?    每月最后一日的上午10:15触发
//　　（20）0 15 10 ? * 6L    每月的最后一个星期五上午10:15触发//　　
//    （21）0 15 10 ? * 6L 2002-2005   2002年至2005年的每月的最后一个星期五上午10:15触发
//　　（22）0 15 10 ? * 6#3   每月的第三个星期五上午10:15触发
@Component
public class SchedulerDemo {
    private static Logger logger = LoggerFactory.getLogger(SchedulerDemo.class);
    @Scheduled(fixedRate = 60000,initialDelay = 1000)
    public void everyMinute(){
        System.out.println("应用开启后1秒后首次执行，之后每分钟调度");
        logger.info("应用开启后1秒后首次执行，之后每分钟调度");
    }
//    （1）cron：cron表达式，指定任务在特定时间执行；
//        （2）fixedDelay：表示上一次任务执行完成后多久再次执行，参数类型为long，单位ms；
//        （3）fixedDelayString：与fixedDelay含义一样，只是参数类型变为String；
//        （4）fixedRate：表示按一定的频率执行任务，参数类型为long，单位ms；
//        （5）fixedRateString: 与fixedRate的含义一样，只是将参数类型变为String；
//        （6）initialDelay：表示延迟多久再第一次执行任务，参数类型为long，单位ms；
//        （7）initialDelayString：与initialDelay的含义一样，只是将参数类型变为String；
//        （8）zone：时区，默认为当前时区，一般没有用到
    @Scheduled(cron = "0 0 2 * * ?")
    public void everyDayTwo(){
        System.out.println("每天凌晨两点调度");
        logger.info("每天凌晨两点调度");
    }

    @Scheduled(fixedRate = 600000,initialDelay = 1000)
    public void sendEmail() throws IOException, MessagingException {
        System.out.println("应用开启后1秒后首次执行，之后每10分钟调度");
        Random random = new Random();
        String Subject = String.valueOf(random.nextInt());
        String content = String.valueOf(random.nextInt());
        EmailTool.sendEmail("dengwenxingae61@163.com",Subject,content);
        logger.info("邮件发送成功");
    }
}
