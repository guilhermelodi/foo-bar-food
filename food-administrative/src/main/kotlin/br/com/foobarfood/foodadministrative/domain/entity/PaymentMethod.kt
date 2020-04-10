package br.com.foobarfood.foodadministrative.domain.entity

import br.com.foobarfood.foodadministrative.domain.enums.PaymentType
import javax.persistence.Entity
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Enumerated
import javax.persistence.EnumType

@Entity
data class PaymentMethod (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,

        @Column(nullable = false)
        var name: String,

        @Column(nullable = false)
        @Enumerated(EnumType.STRING)
        var type: PaymentType

)