package com.aws.proserve.dip.common.repository;

import com.aws.proserve.dip.common.CommonEvent;

import java.util.List;

public interface CommonEventRepository {

    void save(List<CommonEvent> events);

    void remove(String eventId);

    CommonEvent queryById(String eventId);

    void publishSuccess(String eventId);

    void publishFailed(String eventId);

    void removeAll();
}
