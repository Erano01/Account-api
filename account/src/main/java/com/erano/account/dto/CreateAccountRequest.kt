package com.erano.account.dto

import java.math.BigDecimal

data class CreateAccountRequest (
	val customerId:Long,
	val initialCredit: BigDecimal

){
}