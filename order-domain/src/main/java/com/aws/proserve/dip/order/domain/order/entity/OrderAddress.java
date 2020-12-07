package com.aws.proserve.dip.order.domain.order.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OrderAddress {
    private String customerName;
    private String fullAddress;
    private String cellPhoneNumber;

}
