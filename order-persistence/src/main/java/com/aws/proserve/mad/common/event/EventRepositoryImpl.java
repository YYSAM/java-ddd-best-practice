package com.aws.proserve.mad.common.event;

import org.springframework.stereotype.Component;

@Component
public class EventRepositoryImpl {

    private final EventDAO eventDAO;

    public EventRepositoryImpl(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    public void insert(EventPO eventPO) {
        eventDAO.insert(eventPO);
    }
}
