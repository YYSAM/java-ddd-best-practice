package com.aws.proserve.mad.order.persistence.mapper;

import com.aws.proserve.mad.common.entity.type.Money;
import com.aws.proserve.mad.order.domain.order.entity.Order;
import com.aws.proserve.mad.order.domain.order.entity.Order.OrderBuilder;
import com.aws.proserve.mad.order.domain.order.entity.OrderAddress;
import com.aws.proserve.mad.order.domain.order.entity.OrderAddress.OrderAddressBuilder;
import com.aws.proserve.mad.order.domain.order.entity.OrderItem;
import com.aws.proserve.mad.order.domain.order.entity.OrderItem.OrderItemBuilder;
import com.aws.proserve.mad.order.domain.order.entity.types.OrderId;
import com.aws.proserve.mad.order.persistence.po.OrderItemPO;
import com.aws.proserve.mad.order.persistence.po.OrderPO;
import com.aws.proserve.mad.order.persistence.po.OrderPO.OrderPOBuilder;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-20T17:11:26+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.14 (Amazon.com Inc.)"
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
        orderPO.currency( orderTotalPriceCurrency( order ) );
        orderPO.customerName( orderAddressCustomerName( order ) );
        orderPO.fullAddress( orderAddressFullAddress( order ) );
        orderPO.cellPhoneNumber( orderAddressCellPhoneNumber( order ) );
        if ( order.getStatus() != null ) {
            orderPO.status( order.getStatus().name() );
        }
        if ( order.getCreatePersonId() != null ) {
            orderPO.createPersonId( Long.parseLong( order.getCreatePersonId() ) );
        }
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
        order.address( orderPOToOrderAddress( orderPO ) );
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

    private Currency orderTotalPriceCurrency(Order order) {
        if ( order == null ) {
            return null;
        }
        Money totalPrice = order.getTotalPrice();
        if ( totalPrice == null ) {
            return null;
        }
        Currency currency = totalPrice.getCurrency();
        if ( currency == null ) {
            return null;
        }
        return currency;
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
        money.setCurrency( orderPO.getCurrency() );

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
