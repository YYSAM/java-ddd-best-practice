package com.aws.proserve.mad.common.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EventPersistenceListener {

    private final EventRepositoryImpl eventRepository;

    private final ObjectMapper mapper;

    public EventPersistenceListener(EventRepositoryImpl eventRepository, ObjectMapper mapper) {
        this.eventRepository = eventRepository;
        this.mapper = mapper;
    }

    @Order
    @EventListener(condition = "#event.isInnerEvent == false")
    public void processEvent(CommonEvent event) throws JsonProcessingException {

        // 保存事件到事件表中；
        EventPO eventPO = new EventPO();
        eventPO.setCreateTime(LocalDateTime.now());
        eventPO.setStatus(EventStatus.INITIALIZED.getStatus());
        eventPO.setData(mapper.writeValueAsString(event.getSource()));

        eventRepository.insert(eventPO);
    }

}
