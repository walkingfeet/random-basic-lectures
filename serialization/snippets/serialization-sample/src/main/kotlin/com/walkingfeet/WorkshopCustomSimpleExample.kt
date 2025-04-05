package com.walkingfeet

import java.math.BigDecimal

// #region dataClass
data class Customer(val id: Long, val name: String, val balanceAmount: BigDecimal)
// #endregion


object CustomerSerializer {
   
    private const val CUSTOMER_OBJECT_PREFIX = "Customer:"
    // #region serializerImplementation
    fun encode(customer: Customer): String {
        return "${CUSTOMER_OBJECT_PREFIX}${customer.id};${customer.name};${customer.balanceAmount}"
    }

    fun decode(encodedString: String): Customer {
        if (!encodedString.startsWith(CUSTOMER_OBJECT_PREFIX)) {
            throw RuntimeException("Cannot parse customer - it's not a customer")
        }
        val withoutPrefix = encodedString.removePrefix(CUSTOMER_OBJECT_PREFIX)
        val fields = withoutPrefix.split(";")
        return Customer(
            id = fields[0].toLong(),
            name = fields[1],
            balanceAmount = BigDecimal(fields[2])
        )
    }
    // #endregion
}

