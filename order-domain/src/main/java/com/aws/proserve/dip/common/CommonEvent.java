package com.aws.proserve.dip.common;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public abstract class CommonEvent {
    private final String id = UUID.randomUUID().toString();
    private final LocalDateTime createDateTime = LocalDateTime.now();
    private EventStatus status = EventStatus.INITIALIZED;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
