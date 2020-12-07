package com.aws.proserve.dip.common.application.dto;

import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

@Value
public class OrderDTO {
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

}
