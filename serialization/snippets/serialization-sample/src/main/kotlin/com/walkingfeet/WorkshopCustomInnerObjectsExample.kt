package com.walkingfeet

import java.math.BigDecimal

// #region dataClass
data class BankCustomer(val id: Long, val name: String, val bankAccount: BankAccount)
data class BankAccount(val regionId: Long, val balanceAmount: BigDecimal)
// #endregion

object BankCustomerSerializer {

    private const val CUSTOMER_OBJECT_PREFIX = "BankCustomer:"
    // #region serializerImplementation
    fun encode(customer: BankCustomer) = with(customer) {
        "${CUSTOMER_OBJECT_PREFIX}${id};${name};${BankAccountSerializer.encode(bankAccount)}"
    }

    fun decode(encodedString: String): BankCustomer {
        if (!encodedString.startsWith(CUSTOMER_OBJECT_PREFIX)) {
            throw RuntimeException("Cannot parse bank customer - it's not a bank customer")
        }
        val withoutPrefix = encodedString.removePrefix(CUSTOMER_OBJECT_PREFIX)
        val fields = withoutPrefix.split(";")
        return BankCustomer(
            id = fields[0].toLong(),
            name = fields[1],
            bankAccount = BankAccountSerializer.decode(fields[2] + fields[3])
        )
    }
    // #endregion
}

object BankAccountSerializer {

    private const val BANK_ACCOUNT_OBJECT_PREFIX = "BankAccount:"

    fun encode(bankAccount: BankAccount): String {
        return "${BANK_ACCOUNT_OBJECT_PREFIX}${bankAccount.balanceAmount};${bankAccount.regionId}"
    }

    fun decode(encodedString: String): BankAccount {
        if (!encodedString.startsWith(BANK_ACCOUNT_OBJECT_PREFIX)) {
            throw RuntimeException("Cannot parse bank account - it's not a bank account")
        }
        val withoutPrefix = encodedString.removePrefix(BANK_ACCOUNT_OBJECT_PREFIX)
        val fields = withoutPrefix.split(";")
        return BankAccount(
            regionId = fields[0].toLong(),
            balanceAmount = BigDecimal(fields[1])
        )
    }

}