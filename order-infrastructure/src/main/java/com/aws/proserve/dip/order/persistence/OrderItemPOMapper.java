package com.aws.proserve.dip.order.persistence;

import com.aws.proserve.dip.order.domain.order.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderItemPOMapper {
    OrderItemPOMapper INSTANCE = Mappers.getMapper(OrderItemPOMapper.class);

    OrderItemPO toOrderItemPO(OrderItem orderItem);

    OrderItem toOrderItem(OrderItemPO orderItemPO);
}
