package br.com.foobarfood.foodadministrative.service

import br.com.foobarfood.foodadministrative.domain.entity.PaymentMethod
import br.com.foobarfood.foodadministrative.domain.request.PaymentMethodRequest
import br.com.foobarfood.foodadministrative.exception.ResourceNotFoundException
import br.com.foobarfood.foodadministrative.repository.PaymentMethodRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PaymentMethodService(
        private val paymentMethodRepository: PaymentMethodRepository
) {

    fun listAll() = paymentMethodRepository.findAllByOrderByNameAsc()

    fun findById(id: Long): PaymentMethod = paymentMethodRepository.findByIdOrNull(id)
            ?: throw ResourceNotFoundException()

    fun add(paymentMethodRequest: PaymentMethodRequest): PaymentMethod {
        val paymentMethod = PaymentMethod()
        paymentMethod.copyFromRequest(paymentMethodRequest)

        return paymentMethodRepository.save(paymentMethod)
    }

}