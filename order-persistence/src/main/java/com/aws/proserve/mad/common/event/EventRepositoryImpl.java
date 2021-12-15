package com.aws.proserve.mad.common.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class EventRepositoryImpl {

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT, fallbackExecution = true)
    public void processEvent(ApplicationEvent event) {
        // 保存事件到事件表中；
        System.out.println(event);
    }

}
