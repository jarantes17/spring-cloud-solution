package cloud.example.paymentservice.adapters.inbound.controllers

import cloud.example.paymentservice.adapters.dtos.PaymentDto
import cloud.example.paymentservice.application.services.PaymentService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/payment")
class PaymentController(
    private val paymentService: PaymentService
) {

    @PostMapping("/doPayment")
    fun doPayment(@RequestBody paymentDto: PaymentDto): PaymentDto {
        return paymentService.doPayment(paymentDto)
    }
}