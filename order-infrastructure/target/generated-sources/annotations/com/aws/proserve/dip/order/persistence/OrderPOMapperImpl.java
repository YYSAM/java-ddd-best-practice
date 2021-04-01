package com.aws.proserve.dip.order.persistence;

import com.aws.proserve.dip.common.type.Money;
import com.aws.proserve.dip.order.domain.order.entity.Order;
import com.aws.proserve.dip.order.domain.order.entity.Order.OrderBuilder;
import com.aws.proserve.dip.order.domain.order.entity.OrderAddress;
import com.aws.proserve.dip.order.domain.order.entity.OrderAddress.OrderAddressBuilder;
import com.aws.proserve.dip.order.domain.order.entity.OrderItem;
import com.aws.proserve.dip.order.domain.order.entity.OrderItem.OrderItemBuilder;
import com.aws.proserve.dip.order.domain.order.entity.types.OrderId;
import com.aws.proserve.dip.order.domain.order.entity.types.OrderStatus;
import com.aws.proserve.dip.order.persistence.OrderPO.OrderPOBuilder;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-01T09:59:22+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
@Component
public class OrderPOMapperImpl implements OrderPOMapper {

    @Override
    public OrderPO toOrderPO(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderPOBuilder orderPO = OrderPO.builder();

        String value = orderIdValue( order );
        if ( value != null ) {
            orderPO.id( Long.parseLong( value ) );
        }
        orderPO.totalPrice( orderTotalPriceAmount( order ) );
        orderPO.finalPrice( orderFinalPriceAmount( order ) );
        orderPO.customerName( orderAddressCustomerName( order ) );
        orderPO.fullAddress( orderAddressFullAddress( order ) );
        orderPO.cellPhoneNumber( orderAddressCellPhoneNumber( order ) );
        if ( order.getStatus() != null ) {
            orderPO.status( order.getStatus().name() );
        }
        orderPO.createPersonId( order.getCreatePersonId() );
        orderPO.createDateTime( order.getCreateDateTime() );

        return orderPO.build();
    }

    @Override
    public Order toOrder(OrderPO orderPO) {
        if ( orderPO == null ) {
            return null;
        }

        OrderBuilder order = Order.builder();

        order.id( orderPOToOrderId( orderPO ) );
        order.totalPrice( orderPOToMoney( orderPO ) );
        order.finalPrice( orderPOToMoney1( orderPO ) );
        order.address( orderPOToOrderAddress( orderPO ) );
        if ( orderPO.getStatus() != null ) {
            order.status( Enum.valueOf( OrderStatus.class, orderPO.getStatus() ) );
        }
        order.createPersonId( orderPO.getCreatePersonId() );
        order.createDateTime( orderPO.getCreateDateTime() );
        order.items( orderItemPOListToOrderItemList( orderPO.getItems() ) );

        return order.build();
    }

    private String orderIdValue(Order order) {
        if ( order == null ) {
            return null;
        }
        OrderId id = order.getId();
        if ( id == null ) {
            return null;
        }
        String value = id.getValue();
        if ( value == null ) {
            return null;
        }
        return value;
    }

    private BigDecimal orderTotalPriceAmount(Order order) {
        if ( order == null ) {
            return null;
        }
        Money totalPrice = order.getTotalPrice();
        if ( totalPrice == null ) {
            return null;
        }
        BigDecimal amount = totalPrice.getAmount();
        if ( amount == null ) {
            return null;
        }
        return amount;
    }

    private BigDecimal orderFinalPriceAmount(Order order) {
        if ( order == null ) {
            return null;
        }
        Money finalPrice = order.getFinalPrice();
        if ( finalPrice == null ) {
            return null;
        }
        BigDecimal amount = finalPrice.getAmount();
        if ( amount == null ) {
            return null;
        }
        return amount;
    }

    private String orderAddressCustomerName(Order order) {
        if ( order == null ) {
            return null;
        }
        OrderAddress address = order.getAddress();
        if ( address == null ) {
            return null;
        }
        String customerName = address.getCustomerName();
        if ( customerName == null ) {
            return null;
        }
        return customerName;
    }

    private String orderAddressFullAddress(Order order) {
        if ( order == null ) {
            return null;
        }
        OrderAddress address = order.getAddress();
        if ( address == null ) {
            return null;
        }
        String fullAddress = address.getFullAddress();
        if ( fullAddress == null ) {
            return null;
        }
        return fullAddress;
    }

    private String orderAddressCellPhoneNumber(Order order) {
        if ( order == null ) {
            return null;
        }
        OrderAddress address = order.getAddress();
        if ( address == null ) {
            return null;
        }
        String cellPhoneNumber = address.getCellPhoneNumber();
        if ( cellPhoneNumber == null ) {
            return null;
        }
        return cellPhoneNumber;
    }

    protected OrderId orderPOToOrderId(OrderPO orderPO) {
        if ( orderPO == null ) {
            return null;
        }

        OrderId orderId = new OrderId();

        if ( orderPO.getId() != null ) {
            orderId.setValue( String.valueOf( orderPO.getId() ) );
        }

        return orderId;
    }

    protected Money orderPOToMoney(OrderPO orderPO) {
        if ( orderPO == null ) {
            return null;
        }

        Money money = new Money();

        money.setAmount( orderPO.getTotalPrice() );

        return money;
    }

    protected Money orderPOToMoney1(OrderPO orderPO) {
        if ( orderPO == null ) {
            return null;
        }

        Money money = new Money();

        money.setAmount( orderPO.getFinalPrice() );

        return money;
    }

    protected OrderAddress orderPOToOrderAddress(OrderPO orderPO) {
        if ( orderPO == null ) {
            return null;
        }

        OrderAddressBuilder orderAddress = OrderAddress.builder();

        orderAddress.customerName( orderPO.getCustomerName() );
        orderAddress.fullAddress( orderPO.getFullAddress() );
        orderAddress.cellPhoneNumber( orderPO.getCellPhoneNumber() );

        return orderAddress.build();
    }

    protected OrderItem orderItemPOToOrderItem(OrderItemPO orderItemPO) {
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

    protected List<OrderItem> orderItemPOListToOrderItemList(List<OrderItemPO> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItem> list1 = new ArrayList<OrderItem>( list.size() );
        for ( OrderItemPO orderItemPO : list ) {
            list1.add( orderItemPOToOrderItem( orderItemPO ) );
        }

        return list1;
    }
}
