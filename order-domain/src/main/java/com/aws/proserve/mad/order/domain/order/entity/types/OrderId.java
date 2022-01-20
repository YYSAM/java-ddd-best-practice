package com.aws.proserve.mad.order.domain.order.entity.types;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderId {

    private String value;

    public OrderId(String value) {
        if (value == null || "".equals(value)) {
            throw new IllegalArgumentException("the order id cannot be null");
        }
        this.value = value;
    }

}
