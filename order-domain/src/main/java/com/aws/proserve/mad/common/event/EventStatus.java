package com.aws.proserve.mad.common.event;

public enum EventStatus {

    INITIALIZED("初始化", 1),
    PUBLISHED("已发送", 2),
    FAILED("失败", 3);

    private final String description;
    private final Integer status;

    EventStatus(String description, Integer status) {
        this.description = description;
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}
