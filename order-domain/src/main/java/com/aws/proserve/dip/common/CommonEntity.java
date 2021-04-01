package com.aws.proserve.dip.common;

import java.util.ArrayList;
import java.util.List;

public abstract class CommonEntity {
    private List<CommonEvent> events;

    protected final void publishEvent(CommonEvent event) {
        getEvents().add(event);
    }

    final void clearEvent() {
        getEvents().clear();
    }

    final List<CommonEvent> getEvents() {
        if (events == null) {
            events = new ArrayList();
        }
        return events;
    }

}
