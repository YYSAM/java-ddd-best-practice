package com.aws.proserve.mad.common.event;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName(value = "domain_event")
public class EventPO implements Serializable {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * sns，sqs
     */
    @TableField(value = "`queue_type`")
    private String queueType;

    /**
     * 队列名称，根据queueType类型发送
     */
    @TableField(value = "`queue_name`")
    private String queueName;

    /**
     * json数据
     */
    @TableField(value = "`data`")
    private String data;


    /**
     * SNS到SQS路由key
     */
    @TableField(value = "`route_keys`")
    private String routeKeys;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 发送sns时间
     */
    @TableField(value = "send_time")
    private LocalDateTime sendTime;

    /**
     * 1:未处理2:已处理3:失败
     */
    @TableField(value = "`status`")
    private Integer status;

    private static final long serialVersionUID = 1L;
}