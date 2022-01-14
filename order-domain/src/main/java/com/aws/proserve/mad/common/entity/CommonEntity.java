package com.aws.proserve.mad.common.entity;

import com.aws.proserve.mad.common.Status;
import com.aws.proserve.mad.common.context.ApplicationContextProvider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class CommonEntity {

    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * 公共属性；
     */
    private String createPersonId;
    private String createPersonName;
    private LocalDateTime createDateTime;

    private String modifyPersonId;
    private String modifyPersonName;
    private LocalDateTime modifyDateTime;

    private Status status;
    private Integer version;

    protected final void publishEvent(ApplicationEvent event) {
        getApplicationEventPublisher().publishEvent(event);
    }

    public ApplicationEventPublisher getApplicationEventPublisher() {
        if (applicationEventPublisher == null) {
            applicationEventPublisher = ApplicationContextProvider.getBean(ApplicationEventPublisher.class);
        }
        return applicationEventPublisher;
    }

}
