package org.originit.async.deal.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DealTimeoutJob {



    @Scheduled(fixedDelay = 1000)
    public void dealTimeout() {
        // 1. 查询出所有的任务类型
    }

}
