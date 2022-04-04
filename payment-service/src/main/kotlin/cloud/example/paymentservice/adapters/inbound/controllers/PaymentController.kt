package cloud.example.paymentservice.adapters.inbound.controllers

import cloud.example.paymentservice.adapters.dtos.request.PaymentRequestDto
import cloud.example.paymentservice.adapters.dtos.response.PaymentResponseDto
import cloud.example.paymentservice.application.domain.Payment
import cloud.example.paymentservice.application.services.PaymentService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/payment")
class PaymentController(
    private val paymentService: PaymentService
) {

    @PostMapping("/doPayment")
    fun doPayment(@RequestBody paymentDto: PaymentRequestDto): PaymentResponseDto {
        return paymentService.doPayment(paymentDto)
    }

    @GetMapping("/{orderId}")
    fun findPaymentHistoryByOrderId(@PathVariable orderId: Int): Payment {
        return paymentService.findPaymentHistoryByOrderId(orderId)
    }
}