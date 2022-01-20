package com.aws.proserve.mad.common.event;

import com.aws.proserve.mad.common.event.po.EventPO;
import org.springframework.stereotype.Component;

@Component
public class EventRepositoryImpl {

    private final EventDemoDAO eventDemoDAO;

    public EventRepositoryImpl(EventDemoDAO eventDemoDAO) {
        this.eventDemoDAO = eventDemoDAO;
    }

    public void insert(EventPO eventPO) {
        eventDemoDAO.insert(eventPO);
    }
}
