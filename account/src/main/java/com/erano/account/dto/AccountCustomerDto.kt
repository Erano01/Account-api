package com.erano.account.dto

data class AccountCustomerDto (
	
	val id: Long?,
	val name: String,
	val surname: String,

){
    constructor(Id: Long, Name: String, Surname: String) : this(id=null, name="", surname="") {

    }

}