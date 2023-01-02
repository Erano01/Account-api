package com.erano.account.model

import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime
import jakarta.persistence.*

//kotlinde nesne oluştururken sadece constructor metodları kullanıyoruz
//setter getter methodları yok typescriptteki gibi 

@Entity
data class Customer (

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		val id:Long?,
		val name: String?,
		val surname: String?,
		@OneToMany(mappedBy="customer",fetch = FetchType.LAZY)
		val account:Set<Account>?
) {
	constructor() : this(id= null, name="", surname="", account= setOf()) {

	}

}