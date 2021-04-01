package com.aws.proserve.dip.order.application.mapper;

import com.aws.proserve.dip.common.type.Money;
import com.aws.proserve.dip.order.application.dto.OrderDTO;
import com.aws.proserve.dip.order.domain.order.entity.Order;
import com.aws.proserve.dip.order.domain.order.entity.Order.OrderBuilder;
import com.aws.proserve.dip.order.domain.order.entity.OrderAddress;
import com.aws.proserve.dip.order.domain.order.entity.OrderAddress.OrderAddressBuilder;
import com.aws.proserve.dip.order.domain.order.entity.types.OrderId;
import com.aws.proserve.dip.order.domain.order.entity.types.OrderStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-01T09:59:21+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
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
        BigDecimal finalPrice = null;
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
        finalPrice = orderFinalPriceAmount( order );
        customerName = orderAddressCustomerName( order );
        fullAddress = orderAddressFullAddress( order );
        cellPhoneNumber = orderAddressCellPhoneNumber( order );
        if ( order.getStatus() != null ) {
            status = order.getStatus().name();
        }
        createPersonId = order.getCreatePersonId();
        createDateTime = order.getCreateDateTime();

        Currency currency = null;

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
        order.finalPrice( orderDTOToMoney1( orderDTO ) );
        order.address( orderDTOToOrderAddress( orderDTO ) );
        if ( orderDTO.getStatus() != null ) {
            order.status( Enum.valueOf( OrderStatus.class, orderDTO.getStatus() ) );
        }
        order.createPersonId( orderDTO.getCreatePersonId() );
        order.createDateTime( orderDTO.getCreateDateTime() );

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

        return money;
    }

    protected Money orderDTOToMoney1(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Money money = new Money();

        money.setAmount( orderDTO.getFinalPrice() );

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
