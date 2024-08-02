package org.originit.async.deal.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    public static final String EXECUTOR_SERVICE = "scheduledExecutor";

    @Bean(EXECUTOR_SERVICE)
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        // 设置最大线程数
        executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors() * 10);
        // 设置队列容量
        executor.setQueueCapacity(Runtime.getRuntime().availableProcessors() * 10);
        // 设置线程活跃时间（秒）
        executor.setKeepAliveSeconds(10);
        // 设置默认线程名称
        executor.setThreadNamePrefix("scheduled-");
        // 设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

}