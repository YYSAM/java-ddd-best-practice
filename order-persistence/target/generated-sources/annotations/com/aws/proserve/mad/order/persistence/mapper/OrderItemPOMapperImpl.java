package com.aws.proserve.mad.order.persistence.mapper;

import com.aws.proserve.mad.order.domain.order.entity.OrderItem;
import com.aws.proserve.mad.order.domain.order.entity.OrderItem.OrderItemBuilder;
import com.aws.proserve.mad.order.persistence.po.OrderItemPO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-14T12:15:37+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.9 (JetBrains s.r.o.)"
)
@Component
public class OrderItemPOMapperImpl implements OrderItemPOMapper {

    @Override
    public OrderItemPO toOrderItemPO(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemPO orderItemPO = new OrderItemPO();

        orderItemPO.setProductId( orderItem.getProductId() );
        orderItemPO.setProductCount( orderItem.getProductCount() );
        orderItemPO.setTotalPrice( orderItem.getTotalPrice() );

        return orderItemPO;
    }

    @Override
    public OrderItem toOrderItem(OrderItemPO orderItemPO) {
        if ( orderItemPO == null ) {
            return null;
        }

        OrderItemBuilder orderItem = OrderItem.builder();

        orderItem.productId( orderItemPO.getProductId() );
        orderItem.productCount( orderItemPO.getProductCount() );
        orderItem.totalPrice( orderItemPO.getTotalPrice() );

        return orderItem.build();
    }
}
