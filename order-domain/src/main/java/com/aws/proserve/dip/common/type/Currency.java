package com.aws.proserve.dip.common.type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Currency {

    private String value;

    public Currency(String value) {
        if (value == null || "".equals(value)) {
            throw new IllegalArgumentException("the currency value cannot be null");
        }
        this.value = value;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "value='" + value + '\'' +
                '}';
    }
}
