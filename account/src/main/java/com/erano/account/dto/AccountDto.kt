package com.erano.account.dto

import java.math.BigDecimal
import java.time.LocalDateTime

//SOLID
//DTO is OpenClosed
data class AccountDto (

		val id:String?,
		val balance: BigDecimal? = BigDecimal.ZERO,
		val creationDate: LocalDateTime,
		val customer:AccountCustomerDto?,
		val transaction:Set<TransactionDto>?,
) {
    constructor(Id: Long, Balance: BigDecimal, CreationDate: LocalDateTime, customer: AccountCustomerDto, collect: MutableSet<TransactionDto>) : this(id=null, balance= BigDecimal.ONE, creationDate= LocalDateTime.now(), customer, transaction= setOf()) {

    }
}