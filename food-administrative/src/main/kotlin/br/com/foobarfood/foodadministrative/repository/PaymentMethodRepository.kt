package br.com.foobarfood.foodadministrative.repository

import br.com.foobarfood.foodadministrative.domain.entity.PaymentMethod
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentMethodRepository : CrudRepository<PaymentMethod, Long> {

    fun findAllByOrderByNameAsc(): List<PaymentMethod>

}