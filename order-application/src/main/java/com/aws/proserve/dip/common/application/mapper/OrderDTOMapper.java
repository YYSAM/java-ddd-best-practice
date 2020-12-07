package com.aws.proserve.dip.common.application.mapper;

import com.aws.proserve.dip.common.application.dto.OrderDTO;
import com.aws.proserve.dip.order.domain.order.entity.Order;
import com.aws.proserve.dip.order.persistence.OrderPO;
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
            @Mapping(source = "finalPrice.amount",target = "finalPrice"),
            @Mapping(source = "address.customerName",target = "customerName"),
            @Mapping(source = "address.fullAddress",target = "fullAddress"),
            @Mapping(source = "address.cellPhoneNumber",target = "cellPhoneNumber")
    })
    OrderDTO toOrderDTO(Order order);

    @Mappings({
            @Mapping(source = "id",target = "id.value"),
            @Mapping(source = "totalPrice",target = "totalPrice.amount"),
            @Mapping(source = "finalPrice",target = "finalPrice.amount"),
            @Mapping(source = "customerName",target = "address.customerName"),
            @Mapping(source = "fullAddress",target = "address.fullAddress"),
            @Mapping(source = "cellPhoneNumber",target = "address.cellPhoneNumber")
    })
    Order toOrder(OrderDTO orderDTO);
}
