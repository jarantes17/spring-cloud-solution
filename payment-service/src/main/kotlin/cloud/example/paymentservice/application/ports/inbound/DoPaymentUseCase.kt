package cloud.example.paymentservice.application.ports.inbound

import cloud.example.paymentservice.adapters.dtos.request.PaymentRequestDto
import cloud.example.paymentservice.adapters.dtos.response.PaymentResponseDto

interface DoPaymentUseCase {
    fun doPayment(paymentDto: PaymentRequestDto): PaymentResponseDto
}