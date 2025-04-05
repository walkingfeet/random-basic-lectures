package com.walkingfeet.java;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankCustomerSerializeJavaTest {

    @Test
    public void shouldEncodeAndDecodeObject() throws IOException, ClassNotFoundException {

        // #region serializerImplementation
        // Create objects
        BankAccountJava bankAccount = new BankAccountJava(1L, new BigDecimal("1000.50"));
        BankCustomerJava customer = new BankCustomerJava(1L, "John Doe", bankAccount);
        // Encoding
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteArrayOut);
        out.writeObject(customer);
        // Decoding
        byte[] serializedData = byteArrayOut.toByteArray();
        ByteArrayInputStream byteArrayIn = new ByteArrayInputStream(serializedData);
        ObjectInputStream in = new ObjectInputStream(byteArrayIn);
        BankCustomerJava deserializedCustomer = (BankCustomerJava) in.readObject();
        // #endregion

        // Assert
        assertEquals(customer, deserializedCustomer);
    }
}