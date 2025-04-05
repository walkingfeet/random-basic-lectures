package com.walkingfeet

import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.test.assertEquals

class CustomerSerializerTest {
    @Test
    fun `should encode and decode customer`() {
        val expected = Customer(2, "My name", BigDecimal(221))

        val encoded = CustomerSerializer.encode(expected)
        val decoded = CustomerSerializer.decode(encoded)

        assertEquals(expected, decoded)
    }
}