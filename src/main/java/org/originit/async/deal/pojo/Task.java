package org.originit.async.deal.pojo;


import lombok.Data;

/**
 * 任务
 * @author xxc
 */
@Data
public class AsyncFlowTask {
    
    private String id;

    /**
     * 所属用户id
     */
    private String userId;

    /**
     * 任务的id
     */
    private String taskId;

    /**
     * 任务类型
     */
    private String taskType;

    /**
     * 任务当前所处的阶段
     */
    private String taskStage;

    /**
     * 任务状态
     */
    private Integer status;

    /**
     * 当前已经重试了几次
     */
    private Integer crtRetryNum;

    /**
     * 最大重试次数
     */
    private Integer maxRetryNum;

    /**
     * 用于综合当前时间、优先级、重试延迟等因素的排序字段
     */
    private Long orderTime;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 最大重试间隔
     */
    private Integer maxRetryInterval;

    /**
     * 调度日志
     */
    private String scheduleLog;

    /**
     * 任务上下文
     */
    private String taskContext;
    
    private Long createTime;
    
    private Long modifyTime;

}
