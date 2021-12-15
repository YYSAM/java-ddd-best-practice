package com.aws.proserve.mad.order.application.mapper;

import com.aws.proserve.mad.order.application.dto.OrderDTO;
import com.aws.proserve.mad.order.domain.order.entity.Order;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderDTOMapper {
    OrderDTOMapper INSTANCE = Mappers.getMapper( OrderDTOMapper.class );

    @Mappings({
            @Mapping(source = "id.value",target = "id"),
            @Mapping(source = "totalPrice.amount",target = "totalPrice"),
            @Mapping(source = "totalPrice.currency",target = "currency"),
            @Mapping(source = "address.customerName",target = "customerName"),
            @Mapping(source = "address.fullAddress",target = "fullAddress"),
            @Mapping(source = "address.cellPhoneNumber",target = "cellPhoneNumber")
    })
    OrderDTO toOrderDTO(Order order);

    @InheritInverseConfiguration
    Order toOrder(OrderDTO orderDTO);
}
