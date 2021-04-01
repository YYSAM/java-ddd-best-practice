package com.aws.proserve.dip.order.persistence;

import com.aws.proserve.dip.order.domain.order.entity.OrderItem;
import com.aws.proserve.dip.order.domain.order.entity.OrderItem.OrderItemBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-01T09:59:22+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
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
        orderItemPO.setFinalPrice( orderItem.getFinalPrice() );

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
        orderItem.finalPrice( orderItemPO.getFinalPrice() );

        return orderItem.build();
    }
}
