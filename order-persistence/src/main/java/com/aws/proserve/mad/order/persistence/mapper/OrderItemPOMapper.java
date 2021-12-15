package com.aws.proserve.mad.order.persistence.mapper;

import com.aws.proserve.mad.order.domain.order.entity.OrderItem;
import com.aws.proserve.mad.order.persistence.po.OrderItemPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderItemPOMapper {
    OrderItemPOMapper INSTANCE = Mappers.getMapper(OrderItemPOMapper.class);

    OrderItemPO toOrderItemPO(OrderItem orderItem);

    OrderItem toOrderItem(OrderItemPO orderItemPO);
}
