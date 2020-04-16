package br.com.foobarfood.foodadministrative.domain.request

import br.com.foobarfood.foodadministrative.domain.enums.PaymentType
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class PaymentMethodRequest (

        @field:NotBlank
        var name: String,

        @field:NotNull
        var type: PaymentType

)