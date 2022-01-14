package com.aws.proserve.mad.common.event;

import org.springframework.context.ApplicationEvent;

public abstract class CommonEvent<T> extends ApplicationEvent {

    // 是否是内部事件，默认是true；
    private boolean isInnerEvent = true;

    private EventStatus status;

    public CommonEvent(T source) {
        super(source);
    }

    public boolean isInnerEvent() {
        return isInnerEvent;
    }

    @Override
    public T getSource() {
        return (T) super.getSource();
    }

    public void setInnerEvent(boolean innerEvent) {
        isInnerEvent = innerEvent;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }
}