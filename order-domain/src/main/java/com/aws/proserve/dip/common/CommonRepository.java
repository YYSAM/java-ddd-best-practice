package com.aws.proserve.dip.common;


import com.aws.proserve.dip.common.repository.CommonEventRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CommonRepository<T extends CommonEntity> {

    @Autowired
    private CommonEventRepository commonEventRepository;

    public final T save(T commonEntity) {
        commonEventRepository.save(commonEntity.getEvents());
        commonEntity.clearEvent();
        return save(commonEntity);
    }

    protected abstract T saveEntity(T commonEntity);
}
