package cn.dface;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * Created by akun on 2017/7/11.
 */
public class CsvJobListener implements JobExecutionListener{

    long startTime;
    long endTime;
    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime = System.currentTimeMillis();
        System.out.println("任务处理开始");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        endTime = System.currentTimeMillis();
        System.out.println("任务处理结束");
        System.out.println("耗时："+(endTime - startTime) + "ms");
    }
}
