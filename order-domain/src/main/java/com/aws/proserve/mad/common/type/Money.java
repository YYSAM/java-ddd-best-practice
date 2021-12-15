package com.aws.proserve.mad.common.type;

import com.aws.proserve.mad.common.exception.MoneyNotNullException;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class Money {

    private BigDecimal amount;

    private Currency currency;

    public Money() {
    }

    public Money(BigDecimal amount) {
        this(amount, Currency.getInstance(Locale.CHINA));
    }

    public Money(BigDecimal amount, Currency currency) {

        if (amount == null) {
            throw new com.aws.proserve.mad.common.exception.MoneyNotNullException();
        }
        this.amount = amount;
        this.currency = currency;
    }

    public static Money ZERO() {
        return new Money(BigDecimal.ZERO);
    }

    public int compareTo(Money money) {
        return this.amount.compareTo(money.getAmount());
    }

    public Money subtract(Money money) throws Exception {
        BigDecimal resultAmount = this.amount.subtract(money.getAmount());
        return new Money(resultAmount, this.currency);
    }

    public Money add(Money money) throws MoneyNotNullException {
        BigDecimal resultAmount = this.amount.add(money.getAmount());
        return new Money(resultAmount, this.currency);
    }

    public Money multiply(int count) throws MoneyNotNullException {
        BigDecimal resultAmount = this.amount.multiply(new BigDecimal(count));
        return new Money(resultAmount, this.currency);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
