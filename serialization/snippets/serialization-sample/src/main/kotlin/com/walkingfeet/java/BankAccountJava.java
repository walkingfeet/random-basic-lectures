package com.walkingfeet.java;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public record BankAccountJava(long regionId, BigDecimal balanceAmount) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}