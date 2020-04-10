package br.com.foobarfood.foodadministrative.service

import br.com.foobarfood.foodadministrative.repository.PaymentMethodRepository
import org.springframework.stereotype.Service

@Service
class PaymentMethodService(
        private val paymentMethodRepository: PaymentMethodRepository
) {

    fun listAll() = paymentMethodRepository.findAllByOrderByNameAsc()

}