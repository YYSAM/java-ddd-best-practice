package com.aws.proserve.mad.common.event;

import com.aws.proserve.mad.common.CommonEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class EventRepositoryImpl {

    @Order
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT,
            condition = "#event.isPropagation == false", fallbackExecution = true)
    public void processEvent(CommonEvent event) {
        // 保存事件到事件表中；
        System.out.println(event.getSource());
    }

}
