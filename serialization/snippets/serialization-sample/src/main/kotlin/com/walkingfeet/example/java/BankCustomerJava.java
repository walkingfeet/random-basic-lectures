package com.walkingfeet.example.java;

import java.io.Serial;
import java.io.Serializable;
// see implementation in BankCustomerSerializeJavaTest
// #region SampleOuterClassForJavaSerialization
public record BankCustomerJava(long id, String name, BankAccountJava bankAccount) implements Serializable { //....
    // #endregion
    @Serial
    private static final long serialVersionUID = 1L;
}
