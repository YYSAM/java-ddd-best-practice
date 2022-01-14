package com.aws.proserve.mad.common.event;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EventDAO extends BaseMapper<EventPO> {
}