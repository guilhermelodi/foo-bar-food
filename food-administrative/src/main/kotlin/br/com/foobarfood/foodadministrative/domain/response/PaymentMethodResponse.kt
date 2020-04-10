package br.com.foobarfood.foodadministrative.domain.response

import br.com.foobarfood.foodadministrative.domain.enums.PaymentType

data class PaymentMethodResponse (

        val id: Long,

        val type: PaymentType,

        val name: String

)