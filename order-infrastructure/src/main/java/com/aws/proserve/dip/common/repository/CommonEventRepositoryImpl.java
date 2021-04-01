package com.aws.proserve.dip.common.repository;

import com.aws.proserve.dip.common.CommonEvent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommonEventRepositoryImpl implements CommonEventRepository {

    @Override
    public void save(List<CommonEvent> events) {

    }

    @Override
    public void remove(String eventId) {

    }

    @Override
    public CommonEvent queryById(String eventId) {
        return null;
    }

    @Override
    public void publishSuccess(String eventId) {

    }

    @Override
    public void publishFailed(String eventId) {

    }

    @Override
    public void removeAll() {

    }
}
