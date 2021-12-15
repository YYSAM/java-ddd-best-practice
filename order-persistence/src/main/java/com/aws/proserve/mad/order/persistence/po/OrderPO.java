package com.aws.proserve.mad.order.persistence.po;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderPO {
    private Long id;
    private BigDecimal totalPrice;
    private BigDecimal finalPrice;
    private Currency currency;
    private String status;
    private Long createPersonId;
    private LocalDateTime createDateTime;

    private String customerName;
    private String fullAddress;
    private String cellPhoneNumber;

    private List<OrderItemPO> items;
}
