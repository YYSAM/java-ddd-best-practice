package com.aws.proserve.mad.common;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public abstract class CommonEvent extends ApplicationEvent {

    // 是否需要继续冒泡，默认是false；
    private boolean isPropagation = false;

    public CommonEvent(Object source) {
        super(source);
    }

    public void stopPropagation() {
        this.isPropagation = true;
    }
}