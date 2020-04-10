package br.com.foobarfood.foodadministrative.controller

import br.com.foobarfood.foodadministrative.service.PaymentMethodService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/payment-methods")
class PaymentMethodController (
        val paymentMethodService: PaymentMethodService
){

    @GetMapping
    fun listAllPaymentMethods() = paymentMethodService.listAll()

}