package br.com.foobarfood.foodadministrative.controller

import br.com.foobarfood.foodadministrative.domain.entity.PaymentMethod
import br.com.foobarfood.foodadministrative.domain.enums.PaymentType
import br.com.foobarfood.foodadministrative.domain.request.PaymentMethodRequest
import br.com.foobarfood.foodadministrative.service.PaymentMethodService
import com.sun.istack.logging.Logger
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid

@RestController
class PaymentMethodController (
        val paymentMethodService: PaymentMethodService
){

    private val log = Logger.getLogger(javaClass)

    @GetMapping("/payment-methods")
    @ApiOperation("Lists all payment methods")
    fun listAllPaymentMethods(): ResponseEntity<List<PaymentMethod>> {
        log.info("Listing all payment methods")

        return ResponseEntity.ok(paymentMethodService.listAll())
    }

    // TODO: ANALISAR O PORQUE ESTÁ RETORNANDO UMA LISTA DE UMA LISTA DE TIPOS
    @GetMapping("/payment-methods/types")
    @ApiOperation("Lists all payment method types")
    fun listAllPaymentMethodsTypes() = listOf(PaymentType.values())

    @GetMapping("/payment-methods/{id}")
    @ApiOperation("Gets one payment methods by id")
    fun findPaymentMethodById(@PathVariable("id") id: Long): ResponseEntity<PaymentMethod> {
        log.info("Finding payment method by id, id=$id")

        return ResponseEntity.ok(paymentMethodService.findById(id))
    }

    @PostMapping("/payment-methods")
    @ApiOperation("Adds new payment method")
    fun addPaymentMethod(@Valid @RequestBody paymentMethodRequest: PaymentMethodRequest): ResponseEntity<*> {
        log.info("Adding new payment method, paymentMethodRequest=$paymentMethodRequest")

        val paymentMethod = paymentMethodService.add(paymentMethodRequest)

        val location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/payment-methods/{id}")
                .buildAndExpand(paymentMethod.id)
                .toUri()

        return ResponseEntity.created(location).build<Any>()
    }

    @PutMapping("/payment-methods/{id}")
    @ApiOperation("Updates a payment method")
    fun updatePaymentMethod(@PathVariable("id") id: Long,
                            @Valid @RequestBody paymentMethodRequest: PaymentMethodRequest): ResponseEntity<*> {

        log.info("Updating payment method, id= $id, paymentMethodRequest=$paymentMethodRequest")

        paymentMethodService.update(id, paymentMethodRequest)

        return ResponseEntity.ok().build<Any>()
    }

    @DeleteMapping("/payment-methods/{id}")
    @ApiOperation("Deletes a payment method")
    fun updatePaymentMethod(@PathVariable("id") id: Long): ResponseEntity<*> {
        log.info("Deleting payment method, id= $id")

        paymentMethodService.delete(id)

        return ResponseEntity.ok().build<Any>()
    }
}