package com.walkingfeet.java;

import java.io.Serial;
import java.io.Serializable;
// see implementation in BankCustomerSerializeJavaTest
// region #
public record BankCustomerJava(long id, String name, BankAccountJava bankAccount) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}