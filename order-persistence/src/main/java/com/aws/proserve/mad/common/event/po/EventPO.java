package com.aws.proserve.mad.common.event.po;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class EventPO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Long id;
    /**
     * json数据
     */
    private String data;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 1:未处理2:已处理3:失败
     */
    private Integer status;
}