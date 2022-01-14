package com.aws.proserve.mad.order.application.mapper;

import com.aws.proserve.mad.common.entity.type.Money;
import com.aws.proserve.mad.order.application.dto.OrderDTO;
import com.aws.proserve.mad.order.domain.order.entity.Order;
import com.aws.proserve.mad.order.domain.order.entity.Order.OrderBuilder;
import com.aws.proserve.mad.order.domain.order.entity.OrderAddress;
import com.aws.proserve.mad.order.domain.order.entity.OrderAddress.OrderAddressBuilder;
import com.aws.proserve.mad.order.domain.order.entity.types.OrderId;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-14T12:23:51+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.9 (JetBrains s.r.o.)"
)
@Component
public class OrderDTOMapperImpl implements OrderDTOMapper {

    @Override
    public OrderDTO toOrderDTO(Order order) {
        if ( order == null ) {
            return null;
        }

        Long id = null;
        BigDecimal totalPrice = null;
        Currency currency = null;
        String customerName = null;
        String fullAddress = null;
        String cellPhoneNumber = null;
        String status = null;
        Long createPersonId = null;
        LocalDateTime createDateTime = null;

        String value = orderIdValue( order );
        if ( value != null ) {
            id = Long.parseLong( value );
        }
        totalPrice = orderTotalPriceAmount( order );
        currency = orderTotalPriceCurrency( order );
        customerName = orderAddressCustomerName( order );
        fullAddress = orderAddressFullAddress( order );
        cellPhoneNumber = orderAddressCellPhoneNumber( order );
        if ( order.getStatus() != null ) {
            status = order.getStatus().name();
        }
        if ( order.getCreatePersonId() != null ) {
            createPersonId = Long.parseLong( order.getCreatePersonId() );
        }
        createDateTime = order.getCreateDateTime();

        BigDecimal finalPrice = null;

        OrderDTO orderDTO = new OrderDTO( id, totalPrice, finalPrice, currency, status, createPersonId, createDateTime, customerName, fullAddress, cellPhoneNumber );

        return orderDTO;
    }

    @Override
    public Order toOrder(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        OrderBuilder order = Order.builder();

        order.id( orderDTOToOrderId( orderDTO ) );
        order.totalPrice( orderDTOToMoney( orderDTO ) );
        order.address( orderDTOToOrderAddress( orderDTO ) );

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

    protected OrderId orderDTOToOrderId(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        OrderId orderId = new OrderId();

        if ( orderDTO.getId() != null ) {
            orderId.setValue( String.valueOf( orderDTO.getId() ) );
        }

        return orderId;
    }

    protected Money orderDTOToMoney(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Money money = new Money();

        money.setAmount( orderDTO.getTotalPrice() );
        money.setCurrency( orderDTO.getCurrency() );

        return money;
    }

    protected OrderAddress orderDTOToOrderAddress(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        OrderAddressBuilder orderAddress = OrderAddress.builder();

        orderAddress.customerName( orderDTO.getCustomerName() );
        orderAddress.fullAddress( orderDTO.getFullAddress() );
        orderAddress.cellPhoneNumber( orderDTO.getCellPhoneNumber() );

        return orderAddress.build();
    }
}
