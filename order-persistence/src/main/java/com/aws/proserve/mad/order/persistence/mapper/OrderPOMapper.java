package com.aws.proserve.mad.order.persistence.mapper;

import com.aws.proserve.mad.order.domain.order.entity.Order;
import com.aws.proserve.mad.order.persistence.po.OrderPO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderPOMapper {
    OrderPOMapper INSTANCE = Mappers.getMapper(OrderPOMapper.class);

    @Mappings({
            @Mapping(source = "id.value", target = "id"),
            @Mapping(source = "totalPrice.amount", target = "totalPrice"),
            @Mapping(source = "totalPrice.currency", target = "currency"),
            @Mapping(source = "address.customerName", target = "customerName"),
            @Mapping(source = "address.fullAddress", target = "fullAddress"),
            @Mapping(source = "address.cellPhoneNumber", target = "cellPhoneNumber")
    })
    @Mapping(target = "items", ignore = true)
    OrderPO toOrderPO(Order order);

    @InheritInverseConfiguration
    Order toOrder(OrderPO orderPO);
}
